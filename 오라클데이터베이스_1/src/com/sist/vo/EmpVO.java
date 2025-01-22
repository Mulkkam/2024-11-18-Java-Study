package com.sist.vo;
import java.util.*;

import lombok.Data;
/* 
 *   오라클에 있는 데이터를 모아서 => 윈도우 ,브라우저에 전송할 목적 
 *   => 한명에 대한 데이터를 가지고 있다 
 *   => 멤버변수는 컬럼명과 동일하게 만든다 
 *      ------  -----
 *   => 데이터형 일치 
 *      -----------
 *      오라클 
 *      문자형 
 *        CHAR
 *        VARCHAR2
 *        CLOB ==========> String
 *      숫자형
 *        NUMBER(4) ====> 정수
 *        NUMBER(7,2) ===> 실수 
 *        ------------------------ int ,double
 *      날짜형 
 *        DATE  ======> java.util.Date
 */
@Data
public class EmpVO {
  private int empno; // 사번 => 중복이 없다 
  private String ename;
  private String job;
  private int mgr;// 사수번호 
  private Date hiredate;
  private int sal;
  private int comm;
  private int deptno;
}