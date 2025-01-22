package com.sist.client;
//   AcrylLookAndFeel  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.vo.*;
import com.sist.commons.Function;
import com.sist.dao.*;
///////////////// 네트워크 통신 
import java.io.*;
import java.util.*;
import java.net.*;

public class ClientMainFrame extends JFrame 
implements ActionListener, Runnable, MouseListener
{
	
	Socket s;
	OutputStream out;
	BufferedReader in;
	
	MenuForm mf=new MenuForm(); // 포함 클래스 => 있는 그래도 사용
	ControlPanel cp=new ControlPanel();
	Login login=new Login();
	int selectRow=-1;
	MemberDAO mDao=MemberDAO.newInstance();
	public ClientMainFrame()
	{
		setLayout(null); // 사용자 정의 => 직접 배치
		mf.setBounds(10, 15, 800, 50);
		add(mf);
		cp.setBounds(10, 75, 820, 570);
		add(cp);
		setSize(850,700);
		
		login.b1.addActionListener(this);
		login.b2.addActionListener(this);
		
		// 메뉴 버튼
		mf.b6.addActionListener(this); // 채팅
		mf.b1.addActionListener(this); // 홈
		mf.b2.addActionListener(this); // 맛집
		mf.b3.addActionListener(this); // 검색
		mf.b5.addActionListener(this); // 커뮤니티
		mf.b7.addActionListener(this); // 뉴스
		// Chat => Socket 
		cp.cp.tf.addActionListener(this);
		cp.cp.table.addMouseListener(this);
		cp.cp.b2.addActionListener(this);
		cp.cp.b1.addActionListener(this);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				try
				{
					out.write((Function.EXIT+"|\n").getBytes());
				}catch(Exception ex) {}
			}
			
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylDefaultTheme");
		} catch(Exception ex) {}
		new ClientMainFrame();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch (protocol)
				{
					case Function.LOGIN:
					{
						String[] data= {
							st.nextToken(),	
							st.nextToken(),	
							st.nextToken()	
						};
						cp.cp.model.addRow(data);
					}
					break;
					case Function.MYLOG:
					{
						String id=st.nextToken();
						setTitle(id);
						login.setVisible(false);
						setVisible(true);
					}
					break;
					case Function.WAITCHAT:
					{
						cp.cp.ta.append(st.nextToken()+"\n");
					}
					break;
					case Function.MYEXIT:
					{
						dispose();
						System.exit(0);
					}
					break;
					case Function.EXIT:
					{
						String yid=st.nextToken();
						for(int i=0;i<cp.cp.model.getRowCount();i++)
						{
							String id=cp.cp.model.getValueAt(i, 0).toString();
							if(yid.equals(id))
							{
								cp.cp.model.removeRow(i);
								break;
							}
						}
					}
				}
			}
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	// 서버에 요청 => 로그인 / 채팅 보내기 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b2)
		{
			dispose();
			System.exit(0);
		}
		else if(e.getSource()==login.b1)
		{
			String id=login.tf.getText();
			if(id.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
				login.tf.requestFocus();
				return;
			}
			String pwd=String.valueOf(login.pf.getPassword());
			if(pwd.trim().length()<1)
			{
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				login.pf.requestFocus();
				return;
			}
			MemberVO vo=mDao.isLogin(id, pwd);
			if(vo.getMsg().equals("NOID"))
			{
				JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
				login.tf.setText("");
				login.pf.setText("");
				login.tf.requestFocus();
			}
			else if(vo.getMsg().equals("NOPWD"))
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				login.pf.setText("");
				login.pf.requestFocus();
			}
			else
			{
				connection(vo);
			}
		}
		else if(e.getSource()==cp.cp.b2)
		{
			if(selectRow==-1)
			{
				JOptionPane.showMessageDialog(this,"정보 볼 대상을 선택하세요");
				return;
			}
			String id=cp.cp.model.getValueAt(selectRow, 0).toString();
			MemberVO vo=mDao.memberInfo(id);
			
			String info="이름:"+vo.getName()+"\n"
						+"성별:"+vo.getSex()+"\n"
						+"이메일:"+vo.getEmail()+"\n"
						+"생년월일:"+vo.getBirthday().toString()+"\n"
						+"주소:"+vo.getAddress()+"\n"
						+"등록일:"+vo.getRegdate().toString();
			JOptionPane.showMessageDialog(this, info);
			selectRow=-1;
		}
		// chat처리 
		else if(e.getSource()==cp.cp.tf)
		{
			String msg=cp.cp.tf.getText();
			if(msg.trim().length()<1)
			{
				cp.cp.tf.requestFocus();
				return;
			}
			
			try
			{
			  out.write((Function.WAITCHAT+"|"+msg+"\n").getBytes());	
			} catch(Exception ex){
				
			}	
			cp.cp.tf.setText("");
		}
		else if(e.getSource()==mf.b6)
		{
			cp.card.show(cp,"CHAT");	
		}
		else if(e.getSource()==mf.b1)
		{
			cp.card.show(cp,"HOME");
		}
		else if(e.getSource()==mf.b2)
		{
			cp.card.show(cp,"FOOD");
		}
		else if(e.getSource()==mf.b3)
		{
			cp.card.show(cp, "FIND");
		}
		else if(e.getSource()==mf.b7)
		{
			cp.card.show(cp, "NP");
		}
		else if(e.getSource()==mf.b5)
		{
			cp.card.show(cp,"BLIST");
		}
	}
	
	public void connection(MemberVO vo)
	{
		try
		{
			s=new Socket("localhost",1521);
			
			out=s.getOutputStream();
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			out.write((Function.LOGIN+"|"
					+vo.getId()+"|"
					+vo.getName()+"|"
					+vo.getSex()+"\n").getBytes());
		}catch (Exception ex) {
			// TODO: handle exception 
		}
		new Thread(this).start(); // run()메소드 호출 
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cp.cp.table)
		{
			selectRow=cp.cp.table.getSelectedRow();
			String myId=getTitle();
			String id=cp.cp.model.getValueAt(selectRow, 0).toString();
			if(myId.equals(id))
			{
				cp.cp.b1.setEnabled(false);
				cp.cp.b2.setEnabled(false);
			}
			else
			{
				cp.cp.b1.setEnabled(true);
				cp.cp.b2.setEnabled(true);
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
