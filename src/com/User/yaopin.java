package com.User;

import java.io.Serializable;

@SuppressWarnings("serial")
public class yaopin implements Serializable{
	private String name;
	private String number;
	private int price;
	
	public yaopin() {
		//无参构造器
	}
	//有参构造器
	public yaopin(String name,int price,String number){
		this.name = name;
		this.price = price;
		this.number=number;
	}
	public String getT1() {
		return name;
	}
	public void setT1(String name) {
		this.name = name;
	}
	public int getT2() {
		return price;
	}
	public void setT2(int price) {
		this.price = price;
	}
	public String getT3() {
		return number;
	}
	public void setT3(String number) {
		this.number = number;
	}
	public Object getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public Object getNumber() {
		// TODO Auto-generated method stub
		return number;
	}
	public Object getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}