package com.sist.vo;
/*
 * 	jdbc => 자바 데이터베이스 연결
 * 	=> java.sql
 * 	1. ojdbc9.jar
 * 	2. lombok.jar
 * 	-------------
 * 	1) 오라클에 있는 데이터를 모아서 윈도우/웹에 전송
 * 	   ----------------------------------
 * 		=> ~VO (value object) : Spring
 * 		=> ~DTO (data transfer object) : MyBatis
 * 		=> ~Bean : JSP
 * 		=> 변수(컬럼) => 데이터의 손실 방지 => 캡슐화
 * 	2) DAO => 데이터베이스 연결
 * 		= Connection : 데이터베이스 연결
 * 		= Statement : SQL문장 전송 / 결과값을 받는 역할
 * 			= Statement : SQL + 데이터를 동시에 전송
 * 				"WHERE no="+no => SQL 완성 후 전송
 * 			= PrepareStatement : SQL문장을 전송
 * 								 나중에 데이터값을 채운다
 * 				"WHERE name=?"
 * 				=> 가장 많이 사용되는 방식
 * 			= CallableStatement : PROCEDURE를 호출
 * 								  --------- 오라클 함수
 * 								  PL/SQL => 중복 SQL
 * 		= ResultSet : 결과값을 저장하는 메모리 공간
 * 			
 * 			
 */

import lombok.Data;
@Data
public class FoodVO {
	private int fno,hit;
	private double score;
	private String name,type,phone,address,theme,poster,images,time,parking,content,price;
}
