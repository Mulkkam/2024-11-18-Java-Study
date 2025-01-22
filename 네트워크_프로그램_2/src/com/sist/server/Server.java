package com.sist.server;
import java.io.*;
import java.net.*;
import java.util.*;
import com.sist.common.*;
/*
 *     class Server
 *     {
 *        Vector waitVc=new Vector() 
 *         => 접속자 저장 공간 (IP)
 *        class Client extends Thread
 *        {
 *           접속자마다 따라 통신만 담당 
 *                   -------- Thread
 *                            ------
 *                            | 접속된 사람들과 통신 
 *           멤버클래스를 이용한다 
 *        }
 *     }
 *     
 *     class Server 
 *     {
 *        static Vector w=new Vector()
 *        
 *        => new Server()
 *     }
 *     class Client
 *     {
 *       
 *     }
 *     
 *     => port가 같은 경우는 사용할 수 없다 
 */
// 접속시에 처리 => 교환 소켓 / 대기 소켓 
public class Server implements Runnable{
	// 1. 저장 공간 => 동기화
	/*
     *    Vector ===> 네트워크 
     *    ArrayList ==> 데이터베이스 
     *    LinkedList ==> 추가 / 수정 /삭제이 많은 곳
     */
	private Vector<Client> waitVc=new Vector<Client>();
	// 2. 서버 기동
	private ServerSocket ss;
	// 3. 접속시 => 연결 라인 => PORT
	private final int PORT=1212;
	// 4. 서버 가동 => ServerSocket 초기화
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);
			// bind => 개통
			// listen() => 대기
			System.out.println("Server Start..");
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
	// 5. 접속시에 처리 => 사용자 정보를 받아서 Client 클래스 전송
	// 통신이 가능하게 만든다
	public void run()
	{
		try
		{
			while(true)
			{
				Socket s=ss.accept();
    			Client client=new Client(s);
    			// => 각 쓰레드로 전송 => 각자 따로 통신이 가능
    			client.start();
			}
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();
		new Thread(server).start();
	}
	
	class Client extends Thread
	{
		Socket s; // 클라이언트의 IP
		OutputStream out; // 송신
		BufferedReader in; // 수신
		
		String id,name,sex,pos;
		// DB => id중복체크 => 중복없이 => PRIMARY KEY
		public Client(Socket s)
		{
			/*
	  		 *   서버  ===> 클라이언트  IP
	  		 *   클라이언트 ==> 서버 IP
	  		 *   
	  		 *   => readLine() <==> write()
	  		 *   => write() <==> readLine()
	  		 */
			try
			{
				this.s=s;
				// 클라이언트 정보
				out=s.getOutputStream();		
				// 클라이언트로 전송
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// 클라이언트로부터 값을 수신
			}catch (Exception ex) {
				// TODO: handle exception
		  		/*
		  		 *   자바 프로그램에서 가장 쉬운 프로그램 
		  		 *                     -----------
		  		 *                     패턴이 몇개냐?
		  		 *    => 네트워크 
		  		 *    => 데이터베이스 => MyBatis/JPA
		  		 *   
		  		 */
			}
		}
		public void run()
		{
			try
			{
				while(true)
				{
					// 1. 사용자 요청값 받기
					String msg=in.readLine();
	  				System.out.println("Client=>"+msg);
					StringTokenizer st=new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol)
					{
						case Function.LOGIN: // 로그인을 요청했다면
						{
							// 로그인 => 회원가입 내용을 전송
							id=st.nextToken();
							name=st.nextToken();
							sex=st.nextToken();
							pos="대기실";
							
							// 1. 접속이 된 사람 => 정보 전송
							messageAll(Function.LOGIN+"|"+id+"|"+name+"|"+sex+"|"+pos);
							// 2. 입장메세지 전송
							messageAll(Function.WAITCHAT+"|[알림] "+name+"님 입장하셨습니다");
							// 3. waitVc에 저장
							waitVc.add(this);
							// 4-1. 화면을 변경
							messageTo(Function.MYLOG+"|"+id);
							// 4. 접속된 모든 정보를 로그인된 사람에게 전송
							for(Client c:waitVc)
							{
								messageTo(Function.LOGIN+"|"
										+c.id+"|"
										+c.name+"|"
										+c.sex+"|"
										+c.pos);
							}
						}
						break;
	  				   case Function.WAITCHAT:
	  				   {
	  					   messageAll(Function.WAITCHAT+"|["+name+"] "+st.nextToken());
	  				   }
	  				   break;
	  				   case Function.EXIT:
	  				   {
	  					   messageAll(Function.EXIT+"|"+id);
	  					   messageAll(Function.WAITCHAT+"|[알림] "+name+"님 퇴장하셨습니다");
	  					   messageTo(Function.MYEXIT+"|");
	  					   // 행위를 한 사람 => this
	  					   for(int i=0;i<waitVc.size();i++)
	  					   {
	  						   Client c=waitVc.get(i);
	  						   if(c.id.equals(id))
	  						   {
	  							   waitVc.remove(i);
	  							   try
	  							   {
	  								   in.close();
	  								   out.close();
	  							   }catch (Exception ex) {
									// TODO: handle exception
	  							   }
	  							   break;
	  						   }
	  					   }
	  				   }
	  				   break;
	  				   case Function.INFO:
	  				   {
	  					   String yid=st.nextToken();
	  					   for(Client c:waitVc)
	  					   {
	  						   if(yid.equals(c.id))
	  						   {
	  							   messageTo(Function.INFO+"|"
	  									   +c.id+"|"
	  									   +c.name+"|"
	  									   +c.sex+"|"
	  									   +c.pos);
	  							   break;
	  						   }
	  					   }
	  				   }
	  				}
	  			}
	  		}catch(Exception ex) {}
	  	}
		public synchronized void messageAll(String msg)
		{
			for(int i=0;i<waitVc.size();i++)
			{
				Client c=waitVc.get(i);
				try
				{
					c.messageTo(msg);
				}catch (Exception ex) {
					// TODO: handle exception
	  				waitVc.remove(i);
				}
			}
		}
	  	// 접속자 개인 : 쪽지보내기 , 정보보기, 귓속말 
		public synchronized void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}

}
