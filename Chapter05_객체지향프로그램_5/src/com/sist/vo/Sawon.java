package com.sist.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// [접근지정어] 데이터형 변수명 => 접근지정어(private)
// 특별한 경우 : Button / Table ...
// 공개 / 비공개
/*@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor*/
@Data
@AllArgsConstructor
public class Sawon {
	private int sabun;
	private String name;
	private String dept;
	private String job;
	private String regdate;
	private int pay;
	public int getSabun() {
		return sabun;
	}
	
	// 읽기/쓰기
	
//	public void setSabun(int sabun) {
//		this.sabun = sabun;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDept() {
//		return dept;
//	}
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//	public String getJob() {
//		return job;
//	}
//	public void setJob(String job) {
//		this.job = job;
//	}
//	public String getRegdate() {
//		return regdate;
//	}
//	public void setRegdate(String regdate) {
//		this.regdate = regdate;
//	}
//	public int getPay() {
//		return pay;
//	}
//	public void setPay(int pay) {
//		this.pay = pay;
//	}
	
}
