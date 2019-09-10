package com.User;

import java.io.Serializable;

/**
 * 封装好的用户信息，代表所有注册用户
 * 因为将来需要对Information对象进行持久，所有实现java.io.Serializable
 */
public class Information implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String doctor1;
	private String time1;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDoctor() {
		return doctor1;
	}
	public void setAdres(String doctor1) {
		this.doctor1 = doctor1;
	}
	public String getTime() {
		return time1;
	}
	public void setTime(String time1) {
		this.time1 = time1;
	}
	
	//有参构造器
	public Information(String name,String doctor1,String time1){
		this.name = name;
		this.doctor1 = doctor1;
		this.time1 = time1;
	}
	public static String getText() {
		// TODO Auto-generated method stub
		return null;
	}
}