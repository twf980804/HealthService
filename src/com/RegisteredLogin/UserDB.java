package com.RegisteredLogin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import com.RegisteredLogin.User;
//用来维护所有的注册用户的信息
public class UserDB {
	public static HashMap<String, User> users = 
			new  HashMap<String,User>();
	/**
	 * 此方法用来对数据进行持久化
	 * @param Data 需要被持久化的数据
	 * @param fileName 持久化到的位置
	 */
	 public void saveData(Object Data,String fileName){
    	 ObjectOutputStream y1 = null;
		try {
			y1 = new ObjectOutputStream(new FileOutputStream("users",true));
			y1.writeObject(Data);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(y1!=null)y1.close();
			}catch(Exception e){
				
			}
		}
		
     }
     /**
      * 此方法用来获取原来持久化的数据
      *fileName代码要从哪里获取持久化的数据
      *返回获取到的持久化数据
      */
     public Object getData(String fileName){
    	 //构建文件对象
    	 File f = new File(fileName);
    	 //判断如果文件不存在，那么直接返回null
    	 if(!f.exists()){
    		 return null;
    	 }
    	 ObjectInputStream y2 = null;
    	 Object data = null;
    	 try{
    		 y2 = new ObjectInputStream(new FileInputStream(f));
    		 data = y2.readObject();
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }finally{
    		 try{if(y2!=null) y2.close();
    	 }catch(Exception e){
    	     }
    	 }
         return data;
     }
    
}