package com.sist.vo;

import java.util.*;

import lombok.Data;
@Data
public class MemberVO {
	private String id,pwd,name,sex,email,address,msg;
	private Date regdate,birthday;
}
