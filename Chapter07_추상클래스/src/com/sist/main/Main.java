package com.sist.main;

import com.sist.dao.DataBase;
import com.sist.dao.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        DataBase db=new Emp();
        db.listPrint();
        System.out.println("==============");
        db=new Dept();
        db.listPrint();
        
	}

}