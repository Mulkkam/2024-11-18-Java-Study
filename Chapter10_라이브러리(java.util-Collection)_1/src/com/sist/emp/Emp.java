package com.sist.emp;
import java.util.*;

import lombok.Data;
//클래스는 한개에 대한 정보 => 저장 new를 사용하면 여러개를 저장이 가능 

@Data
public class Emp {
	private int empno;
	private String ename;
	private String job;
	private int mgr;	
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
}
