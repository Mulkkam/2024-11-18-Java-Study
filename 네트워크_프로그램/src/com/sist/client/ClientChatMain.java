package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;
import com.sist.commons.*;
public class ClientChatMain extends JFrame
implements ActionListener, Runnable{
	JButton b1,b2;
	JTextArea ta;
	JTextField tf;
	private String name; 
	// 서버 연결 => 네트워크 관련
	Socket s;
	// 단방향
	OutputStream out; // 서버에서 들어오는 값은 자동화
	BufferedReader in;
	
	// 레이아웃
	public ClientChatMain()
	{
		b1=new JButton("접속");
		b2=new JButton("종료");
		
		tf=new JTextField(20);
		tf.setEnabled(false);
		ta=new JTextArea();
		ta.setEditable(false);
		JScrollPane js=new JScrollPane(ta);
		
		JPanel p=new JPanel();
		p.add(tf);
		p.add(b1);
		p.add(b2);
		
		add("Center",js);
		add("South",p);
		setSize(450,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		tf.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ClientChatMain();
	}
	// 서버에서 들어오는 값 처리
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
				while(true)
				{
					String msg=in.readLine();
					ta.append(msg+"\n");
				}
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	// 버튼 클릭시 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
		else if(e.getSource()==b1)
		{
			name=JOptionPane.showInputDialog("이름 입력:");
			
			try
			{
//				s=new Socket("localhost",1212);
				s=new Socket("192.168.10.115",1212);
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			}catch (Exception ex) {
				// TODO: handle exception
			}
			tf.setEnabled(true);
			b1.setEnabled(false);
			new Thread(this).start();
		}
		else if(e.getSource()==tf)
		{
			String msg=tf.getText();
			if(msg.trim().length()<1)
			{
				tf.requestFocus();
				return;
			}
			
			try
			{
				out.write(("["+name+"]"+msg+"\n").getBytes());
			}catch (Exception ex) {
				// TODO: handle exception
			}
			tf.setText("");
		}
	}

}
