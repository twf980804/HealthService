package com.User;



import java.util.HashMap;

//用来维护所有的信息
public class JMDB {
	public static HashMap<String, Info> info = 
			new HashMap<String,Info>();
	/**
	 * 此方法用来对数据进行持久化
	 * @param Data 需要被持久化的数据
	 * @param fileName 持久化到的位置
	 */
	public void saveData(Object Data,String fileName){
		/*ObjectOutputStream oos =
				new ObjectOutputStream(
					new FileOutputStream(fileName));*/
	}
	/**
	 * 此方法用来获取原来持久化的数据
	 * @param fileName 代报要从哪里获取持久化的数据
	 * @return  返回获取到的持久化的数据
	 */
	public Object getDate(String fileName){
		
		return null;
	}
}