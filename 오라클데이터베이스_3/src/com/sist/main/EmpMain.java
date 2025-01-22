package com.sist.main;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("★★★★★ 사원 목록 ★★★★★");
        // 오라클 연결 
        EmpDao dao=EmpDao.newInstance();
        List<EmpVO> list=dao.empJoinAllData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob()+" "
        			+vo.getHiredate().toString()+" "
        			+vo.getStrSal()+" "
        			+vo.getDvo().getDname()+" "
        			+vo.getDvo().getLoc()+" "
        			+vo.getSvo().getGrade());
        }
	}

}