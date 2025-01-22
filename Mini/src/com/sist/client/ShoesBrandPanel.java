package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.*;
import java.net.URL;

import com.sist.commons.ImageChange;
import com.sist.dao.*;
import com.sist.vo.*;
import java.util.*;
import java.util.List;
/*
 *   1. JFrame / JDialog => BorderLayout 
 *   2. JPanel => FlowLayout 
 */
public class ShoesBrandPanel extends JPanel
implements ActionListener,MouseListener
{
     ControlPanel cp;
     JButton[] genre=new JButton[5]; // 브랜드별
     JButton prev,next; // 이전 , 다음 
 	 JLabel la=new JLabel("0 page / 0 pages");
 	 JLabel[] imgs=new JLabel[12];
 	 int curpage=1;
 	 int totalpage=0;
 	 JPanel pan=new JPanel(); // 이미지 
 	 // 데이터베이스 연동 
 	 ShoesDAO dao=ShoesDAO.newInstance();
 	 String strGenre="Nike";
 	 public ShoesBrandPanel(ControlPanel cp)
 	 {
 		 this.cp=cp;
 		 
 		 
 		 prev=new JButton("이전");
 		 next=new JButton("다음");
 		 
 		 JPanel p1=new JPanel();
 		 p1.setLayout(new GridLayout(1,5,5,5));
 		 String[] temp={"Nike","New Balance","Asics","Adidas","etc"};
 		 for(int i=0;i<genre.length;i++)
 		 {
 			 genre[i]=new JButton(temp[i]);
 			 p1.add(genre[i]);
 			 
 			 genre[i].addActionListener(this);
 		 }
 		 
 		 JPanel p2=new JPanel();
 		 p2.add(prev); p2.add(la); p2.add(next);
 		 
 		 pan.setLayout(new GridLayout(3,4,5,5));
 		
 		 setLayout(new BorderLayout());
 		 add("North",p1);
 		 add("Center",pan);
 		 add("South",p2);
 		 print();
 		 
 		 prev.addActionListener(this);
 		 next.addActionListener(this);
 		 
 	 }
 	 
 	// 초기화 
     public void init()
     {
     	for(int i=0;i<imgs.length;i++)
     	{
     		imgs[i]=new JLabel("");
     	}
     	pan.removeAll();// 전체 삭제
     	pan.validate();// 재배치
     }
     // 이미지 출력 
     public void print()
     {
     	// 총페이지 읽기 
     	totalpage=dao.shoesBrandTotalPage(strGenre);
     	List<ShoesVO> list=dao.shoesBrandData(curpage, strGenre);
     	for(int i=0;i<list.size();i++)
     	{
     		ShoesVO vo=list.get(i);
     		try
     		{
     			URL url=new URL(vo.getImg());
     			Image image=ImageChange.getImage(new ImageIcon(url), 200, 180);
     			imgs[i]=new JLabel(new ImageIcon(image));
     			imgs[i].setToolTipText(vo.getName_kor()+"^"+vo.getGoods_id());
     			pan.add(imgs[i]);
     			// 이벤트 등록 
     			imgs[i].addMouseListener(this);
     		}catch(Exception ex) {}
     	}
     	la.setText(curpage+" page / "+totalpage+" pages");
     	
     }
     public void printData(List<ShoesVO> list) {
 	    pan.removeAll();
 	    for (int i = 0; i < list.size(); i++) {
 	        ShoesVO vo = list.get(i);
 	        try {
 	            URL url = new URL(vo.getImg());
 	            Image image = ImageChange.getImage(new ImageIcon(url), 200, 180);
 	            imgs[i] = new JLabel(new ImageIcon(image));
 	            imgs[i].setToolTipText(vo.getName_kor() + "^" + vo.getGoods_id());
 	            pan.add(imgs[i]);
 	            imgs[i].addMouseListener(this);
 	        } catch (Exception ex) {
 	            ex.printStackTrace();
 	        }
 	    }
 	    la.setText(curpage + " page / " + totalpage + " pages");
 	    pan.validate();
 	    
     	prev.setEnabled(curpage > 1);
        next.setEnabled(curpage < totalpage);
 	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				if(e.getClickCount()==2)
				{
					String goods_id=imgs[i].getToolTipText();
					goods_id=goods_id.substring(goods_id.lastIndexOf("^")+1);
					ShoesVO vo=dao.shoesDetailData(Integer.parseInt(goods_id));
					cp.sdp.detailPrint(2, vo);
					cp.card.show(cp, "DETAIL");
				}
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
		// onMouseOver
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				imgs[i].setBorder(new LineBorder(Color.ORANGE,3));
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		// onMouseOut
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				imgs[i].setBorder(null);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    for (int i=0;i<genre.length;i++) 
	    {
	        if (e.getSource()==genre[i]) 
	        {
	            strGenre=genre[i].getText();
	            curpage=1;

	            // "etc" 선택 시 별도 로직 처리
	            if("etc".equals(strGenre)) 
	            {
	                totalpage = dao.shoesBrandTotalPageEtc();
	                init();
	                List<ShoesVO> list = dao.shoesBrandDataEtc(curpage);
	                printData(list);
	            } 
	            else 
	            {
	                totalpage=dao.shoesBrandTotalPage(strGenre);
	                init();
	                List<ShoesVO> list=dao.shoesBrandData(curpage, strGenre);
	                printData(list);
	            }
	        }
	    }

	    // 이전
	    if (e.getSource()==prev)
	    {
	        if (curpage > 1)
	        {
	            curpage--;
	            init();
	            if ("etc".equals(strGenre))
	            {
	                List<ShoesVO> list=dao.shoesBrandDataEtc(curpage);
	                printData(list);
	            } else
	            {
	                List<ShoesVO> list=dao.shoesBrandData(curpage, strGenre);
	                printData(list);
	            }
	        }
	    }
	    // 다음
	    if (e.getSource()==next)
	    {
	        if (curpage<totalpage)
	        {
	            curpage++;
	            init();
	            if ("etc".equals(strGenre))
	            {
	                List<ShoesVO> list=dao.shoesBrandDataEtc(curpage);
	                printData(list);
	            } else
	            {
	                List<ShoesVO> list=dao.shoesBrandData(curpage, strGenre);
	                printData(list);
	            }
	        }
	    }
	}
}