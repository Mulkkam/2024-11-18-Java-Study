package com.sist.emp;
import java.util.*;
public class EmpUserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDAO dao=EmpDAO.newInstance();
//		HashSet<String> set=dao.empGetJobs();
//		
//		System.out.println("저장 갯수:"+set.size());
//		for(String job:set)
//		{
//			System.out.println(job);
//		}
		TreeSet<String> set=dao.empGetNames();
		System.out.println("사원 인원:"+set.size());
		for(String name:set)
		{
			System.out.println(name);
		}
//		System.out.println("===== 한명 퇴사 =====");
//		set.remove("SCOTT");
//		System.out.println("사원 인원:"+set.size());
//		for(String name:set)
//		{
//			System.out.println(name);
//		}
		System.out.println(set.subSet("K", "WORD"));
		// 순위 검색
	}

}
