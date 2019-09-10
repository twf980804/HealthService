package com.admin;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

public class DangAnView {
	public DangAnView() {
		super();
		try {
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init () throws Exception{
			File file=new File("a1.txt");
			if(file.isFile() && file.exists()){ 
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file));
				BufferedReader bufferedReader = new BufferedReader(read);
				String line ="";
				String lineTxt = line;
				while((lineTxt = bufferedReader.readLine()) != null){
					line=line+lineTxt;
				}
				read.close();
		String filePath = "a1.txt";
		readTxtFile(filePath);
		final Frame f = new Frame("浏览");
		f.setLayout(null);
		f.setBounds(400, 100, 700, 500);
		f.setBackground(Color.CYAN);
		
		Label l1 = new Label("信息");
		l1.setFont(new Font("BOLD", Font.BOLD, 35));
		l1.setBounds(270,20,200,100);
		f.add(l1);

		
		JTextArea a = new JTextArea(20,10);
		a.setFont(new Font("BOLD", Font.BOLD, 25));
		a.setLocation(30, 120);
		a.setSize(650, 380);
		a.setBackground(Color.cyan);
		a.setLineWrap(true);
		a.setWrapStyleWord(true);
        f.add(a);
		a.setText(line);
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				f.setVisible(false);
			}
			
		});
	}
	}
	public static void main(String[] args) {
		
		try {
			String content="GBK";
			
			File file=new File("a1.txt");
			if(file.isFile() && file.exists()){ 
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),content);
				BufferedReader bufferedReader = new BufferedReader(read);
				String line = "";
				String lineTxt = line;
				while((lineTxt = bufferedReader.readLine()) != null){
					line=line+lineTxt;
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		String filePath = "a1.txt";
		readTxtFile(filePath);
		new DangAnView();
	
	}
	private static void readTxtFile(String filePath) {
		
	}
	public void saveData(char[] ticketviewall, Toolkit start) {
		
	}

}
