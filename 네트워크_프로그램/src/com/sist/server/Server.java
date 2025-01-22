package com.sist.server;
import java.util.*; // 데이터가 여러개 => StringTokenizer
// => 사용자 정보 저장 => Vector (동기화)
import java.io.*; // 송수신
// 전송 => byte 단위 전송 , 받을때 => 2byte
// OutputStream , BufferedReader
import java.net.*; // 다른 컴퓨터와 연동
// ServerSocket : 접속 담당 / Socket : 클라이언트와 통신
import com.sist.commons.*;
public class Server implements Runnable {
	private ServerSocket ss;
	private final int PORT=1212;
	private Vector<Client> waitVc= new Vector<Client>();
	// 초기화
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);
			// bind => IP/PORT 연결
			// listen() => 대기상태
			System.out.println("Server Start...");
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	// 접속시에 처리 => 접속자 정보를 저장(ip,sort)
	// ---- 발신자 IP (전화번호)
	public void run() // 쓰레드
	{
		try
		{
			while(true)
			{
				Socket s=ss.accept();
				Client client=new Client(s);
				waitVc.add(client);
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
		Socket s; // ip/port
		OutputStream out; // 송신
		BufferedReader in; // 수신
	
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		public void run()
		{
			try
			{
				while(true)
				{
					String msg=in.readLine();
					// =>보낼때 \n으로 종료 
					/*
					 *   요청 
					 *    1. 접속자 전체 
					 *    2. 한명에게 전송 
					 */
					messageAll(msg);
				}
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		// 전체적으로 전송 => 동기화 => 안전성 
		public synchronized void messageAll(String msg)
		{
			try
			{
				for(Client c:waitVc)
				{
					c.messageTo(msg);
				}
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		// 한명에게 전송 => 동기화
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

