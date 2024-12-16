package com.sist.client;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
import java.awt.Image;
import java.awt.Toolkit;

public class ControlPanel extends JPanel{
	Image back;
	JLabel la1,la2;
	JTextField tf;
	JPasswordField pf;
	JButton b1,b2;
	public ControlPanel()
	{
		back=Toolkit.getDefaultToolkit().getImage("C:\\JavaDev\\Background.jpg");
		la1=new JLabel("ID");
		la2=new JLabel("Password");
		tf=new JTextField();
		pf=new JPasswordField();
		b1=new JButton("로그인");
		b2=new JButton("취소");
		
        // 배치 => 실행과 동시에 실행 명령 => 초기화 => 생성자
		setLayout(null);
		la1.setBounds(10, 15, 80, 30);
		tf.setBounds(95, 15, 200, 30);
		add(la1);add(tf);
		
		la2.setBounds(10, 50, 80, 30);
		pf.setBounds(95, 50, 200, 30);
		add(la2);add(pf);
		
		JPanel p=new JPanel();
		p.setOpaque(false);
		p.add(b1);
		p.add(b2);
		p.setBounds(50, 90, 285, 35);
		add(p);
	}
	@Override
	public void paintComponent(Graphics g)
	{
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}
}
