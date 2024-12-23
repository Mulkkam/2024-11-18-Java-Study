package com.sist.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
class Sawon
{
	int sabun;
	String name;
}
public class SawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Sawon a=new Sawon();
        a.sabun=1;
        a.name="홍길동";
        
        Sawon b=new Sawon();
        b.sabun=1;
        b.name="홍길동";
        
        if(a.equals(b))
        {
        	System.out.println("같다");
        }
        else
        {
        	System.out.println("다르다");
        }
	}

}