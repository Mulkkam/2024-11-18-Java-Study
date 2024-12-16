package com.sist.client;
//   AcrylLookAndFeel  
import javax.swing.*;
							 // 상속 => 재사용 => 변경
public class ClientMainFrame extends JFrame {
	MenuForm mf=new MenuForm(); // 포함 클래스 => 있는 그래도 사용
	ControlPanel cp=new ControlPanel();
	public ClientMainFrame()
	{
		setLayout(null); // 사용자 정의 => 직접 배치
		mf.setBounds(250,10,1000,50);
		add(mf);
		cp.setBounds(50,80,1500,750);
		add(cp);
		setSize(1600,900);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch(Exception ex) {}
		new ClientMainFrame();
	}

}
