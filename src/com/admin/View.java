package com.admin;

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

public class View {
	public View() {
		super();
		try {
			init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void init () throws Exception{
			File file=new File("ReservationInformation.txt");
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
		String filePath = "ReservationInformation.txt";
		readTxtFile(filePath);
		final Frame f = new Frame("浏览");
		f.setLayout(null);
		f.setBounds(200, 90, 950, 600);
		
		Label l1 = new Label("预定信息");
		l1.setFont(new Font("BOLD", Font.BOLD, 38));
		l1.setBounds(380, 60, 400, 40);
		f.add(l1);

		
		JTextArea a = new JTextArea(20,10);
		a.setFont(new Font("BOLD", Font.BOLD, 25));
		a.setLocation(30, 120);
		a.setSize(650, 380);
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
			
			File file=new File("ReservationInformation.txt");
			if(file.isFile() && file.exists()){ 
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file),content);
				BufferedReader bufferedReader = new BufferedReader(read);
				String line = "";
				String lineTxt = line;
				while((lineTxt = bufferedReader.readLine()) != null){
					line+=lineTxt;
				}
				read.close();
			}else{
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		String filePath = "ReservationInformation.txt";
		readTxtFile(filePath);
		new View();
	
	}
	private static void readTxtFile(String filePath) {
		
	}
	public void saveData(char[] ticketviewall, Toolkit start) {
		
	}

}
