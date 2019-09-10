package com.RegisteredLogin;
import java.io.Serializable;
/**
 * 封装好的用户信息，代表所有注册用户
 * @author 
 * 因为将来需要对User对象进行持久，所有实现java.io.Serializable
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String pwd;
	private String id;
	private String add;

	public User() {
		//无参构造器
	}
	//有参构造器
	public User(String name,String pwd,String id,String add){
		this.name = name;
		this.pwd = pwd;
		this.id = id;
		this.add = add;

	}


	public String getT1() {
		return name;
	}
	public void setT1(String name) {
		this.name = name;
	}
	public String getT2() {
		return pwd;
	}
	public void setT2(String pwd) {
		this.pwd = pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}

	

}