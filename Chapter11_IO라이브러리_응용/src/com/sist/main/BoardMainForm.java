package com.sist.main;
import javax.swing.*;

import java.util.Date;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

import com.sist.board.*;

public class BoardMainForm extends JFrame
implements ActionListener , MouseListener
{
	CardLayout card=new CardLayout();
	BoardList bList=new BoardList();
	BoardDetail bDetail=new BoardDetail();
	BoardInsert bInsert=new BoardInsert();
	BoardUpdate bUpdate=new BoardUpdate();
	BoardDelete bDelete=new BoardDelete();
	// 게시판 관리자
	BoardManager bm=new BoardManager();
	// 변수 선언
	int curpage=1;
	int totalpage=0;
	public BoardMainForm()
	{
		setLayout(card);
	
    	// 추가 
		add("LIST",bList);
		add("DETAIL",bDetail);
    	add("INSERT",bInsert);
    	add("UPDATE",bUpdate);
    	add("DELETE",bDelete);
		
		setTitle("윈도우 게시판 ver 1.0");
		listPrint();
		setSize(640,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 이벤트 등록
		bList.inBtn.addActionListener(this);
		bInsert.b1.addActionListener(this); // 글쓰기
		bInsert.b2.addActionListener(this); // 취소
		
		bList.prevBtn.addActionListener(this); // 이전
		bList.nextBtn.addActionListener(this); // 다음
		bList.table.addMouseListener(this); // table
	
		bDetail.b3.addActionListener(this); // 목록
		bDetail.b1.addActionListener(this); // 수정
		bDetail.b2.addActionListener(this); // 삭제
		
		bDelete.b1.addActionListener(this); // 삭제
		bDelete.b2.addActionListener(this); // 취소
		
	}
	public void listPrint()
	{
		for(int i=bList.model.getRowCount()-1;i>=0;i--)
		{
			bList.model.removeRow(i);
		}
    	List<BoardVO> list=bm.boardListData(curpage);
		totalpage=bm.boardTotalPage();
		bList.pageLa.setText(curpage+"page / "+totalpage+" pages");
	
		// 게시물 출력
		for(int i=0;i<list.size();i++)
		{
			BoardVO vo=list.get(i);
			String[] data= {
				String.valueOf(vo.getNo()),
				vo.getSubject(),
				vo.getName(),
				new SimpleDateFormat("yyyy-MM-dd").format(vo.getRegdate()),
				String.valueOf(vo.getHit())
			};
			bList.model.addRow(data);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BoardMainForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(bList.inBtn==e.getSource())
		{
			bInsert.nameTf.setText("");
			bInsert.subTf.setText("");
			bInsert.ta.setText("");
			bInsert.pwdPf.setText("");
			// 카드 변경 => 윈도우창 변경
			card.show(getContentPane(), "INSERT");
			bInsert.nameTf.requestFocus();
		}
		else if(bInsert.b2==e.getSource()) // 글쓰기 취소
		{
			card.show(getContentPane(), "LIST");
			// javascript:history.back()
		}
		else if(bInsert.b1==e.getSource()) // 글쓰기
		{
			String name=bInsert.nameTf.getText();
			// 입력된 값 읽기
			if(name.length()<1)
			{
				bInsert.nameTf.requestFocus();
				return;
			}
			
			/*
			 *   let name=$('#name').val();
			 *   if(name.length<1)
			 *   {
			 *      $('#name').focus()
			 *      return 
			 *   }
			 */
			
			String subject=bInsert.subTf.getText();
			// 입력된 값 읽기 
			if(subject.length()<1)
			{
				bInsert.subTf.requestFocus();
				return;
			}
			String content=bInsert.ta.getText();
			if(content.length()<1)
			{
				bInsert.ta.requestFocus();
				return;
			}
			String pwd=String.valueOf(bInsert.pwdPf.getPassword());
			if(pwd.length()<1)
			{
				bInsert.pwdPf.requestFocus();
				return;
			}
			
			BoardVO vo=new BoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			int no=bm.boardSequence();
			vo.setNo(no);
			vo.setRegdate(new Date());
			
			bm.boardInsert(vo); // 추가
			
			// 목록으로 이동
			card.show(getContentPane(), "LIST");
			listPrint();
		}
		else if(e.getSource()==bList.prevBtn) // 이전
		{
			if(curpage>1)
			{
				curpage--;
				listPrint();
			}
		}
		else if(e.getSource()==bList.nextBtn) // 다음
		{
			if(curpage<totalpage)
			{
				curpage++;
				listPrint();
			}
		}
		// => 웹 => 반드시 현재페이지 전송 
		else if(e.getSource()==bDetail.b3) // 상세보기 => 목록
		{
			card.show(getContentPane(), "LIST");
			listPrint();
		}
		else if(e.getSource()==bDetail.b2)
		{
			card.show(getContentPane(), "DELETE");
			// 화면 변경 
		}
		else if(e.getSource()==bDetail.b1)
		{
			// 수정 요청 
			String no=bDetail.no.getText();
			BoardVO vo=bm.boardUpdateData(Integer.parseInt(no));
			card.show(getContentPane(), "UPDATE");
			bUpdate.nameTf.setText(vo.getName());
			bUpdate.subTf.setText(vo.getSubject());
			bUpdate.ta.setText(vo.getContent());
		
		}
		
		else if(e.getSource()==bDelete.b2)
		{
			card.show(getContentPane(), "DETAIL");
		}
		else if(e.getSource()==bDelete.b1)
		{
			String pwd=String.valueOf(bDelete.pf.getPassword());
			if(pwd.length()<1)
			{
				bDelete.pf.requestFocus();
				return;
			}
			String no=bDetail.no.getText();
			boolean bCheck=bm.boardDelete(Integer.parseInt(no), pwd);
			if(bCheck==false)
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				bDelete.pf.setText("");
				bDelete.pf.requestFocus();
			}
			else
			{
				card.show(getContentPane(), "LIST");
				listPrint();
			}
		}
		// 수정 / 삭제 => 본인여부 확인 => 비밀번호 
		// boolean => 비밀번호 체크 
		/*
		 *    1. 목록 => 추가 => 목록
		 *             삭제 => 목록
		 *    2. 상세보기 
		 *          수정 => 상세보기
		 *    3. 취소 => 이전화면 이동 
		 *          history.back() 
		 */
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bList.table)
		{
			if(e.getClickCount()==2) // 더블 클릭
			{
				int row=bList.table.getSelectedRow();
				String no=bList.model.getValueAt(row, 0).toString();
				//System.out.println(no);
				BoardVO vo=bm.boardDetailData(Integer.parseInt(no));
				card.show(getContentPane(), "DETAIL");
				
				// 출력 => bDetail
				bDetail.no.setText(String.valueOf(vo.getNo()));
				bDetail.name.setText(vo.getName());
				bDetail.sub.setText(vo.getSubject());
				bDetail.ta.setText(vo.getContent());
				bDetail.hit.setText(String.valueOf(vo.getHit()));
				bDetail.day.setText(new SimpleDateFormat("yyyy-MM-dd").format(vo.getRegdate()));
				// 1. 웹 / 윈도우 => 거의 대부분이 String이기 때문에
				// 정수 / 실수 변환 => String.valueOf()
				// --------- Integer.parseInt() Double.parseDouble()
				// 날짜 =>  SimpleDateFormat 
				// 정수 =>  DecimalFormat => 1,000
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
