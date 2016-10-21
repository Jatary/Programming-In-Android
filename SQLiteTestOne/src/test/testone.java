package test;

import java.util.ArrayList;

import entity.userlogin;

import sqlite.DBManager;

import android.test.AndroidTestCase;

public class testone extends AndroidTestCase {

	public void test(){
		fail("Not yet implemented");
		
	}
	public void checkSQLiteAdd(){
	DBManager dbm=new DBManager(getContext());
	ArrayList<userlogin>userloginArr=new ArrayList<userlogin>();
	userlogin p1=new userlogin("zz","123","0","");
	
	userloginArr.add(p1);
	userloginArr.add(new userlogin("zzz","123","0",""));
	dbm.add(userloginArr);
		System.out.println("++++"+dbm.add(userloginArr));	
		}
}