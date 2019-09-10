package com.User;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class JuMing extends JFrame{
	JPanel JP = new JPanel();
	JLabel JL1 = new JLabel("用户档案");
	JLabel JL2 = new JLabel("姓      名：");
	JTextField JTF2 = new JTextField("请输入姓名",20);
	JLabel JL3 = new JLabel("年      龄：");
	JTextField JTF3 = new JTextField("请输入年龄",20);
	JLabel JL4 = new JLabel("性      别：");
	JRadioButton JTF41 = new JRadioButton("男",true);
	JRadioButton JTF42 = new JRadioButton("女");
	JLabel JL5 = new JLabel("病      例：");
	JTextField JTF5 = new JTextField("请输入历史病例",20);
	JButton QR = new JButton("确认信息");
	JButton QX = new JButton("取消");
	
	public JuMing(String title) {
		super(title);
		init();
	}
	
	public void init() {
		JP.setLayout(null);
		
		JL1.setBounds(0,0,950,40);
		JL1.setHorizontalAlignment(SwingConstants.CENTER);
		JL1.setFont(new Font("宋体", Font.BOLD, 40));
		JP.add(JL1);
		
		JL2.setBounds(200,60,150,30);
		JL2.setFont(new Font("宋体", Font.BOLD, 20));
		JP.add(JL2);
		JTF2.setSize(400,30);
		JTF2.setLocation(400,60);
		JP.add(JTF2);
		
		JL3.setBounds(200,100,150,30);
		JL3.setFont(new Font("宋体", Font.BOLD, 20));
		JP.add(JL3);
		JTF3.setSize(400, 30);
		JTF3.setLocation(400, 100);
		JP.add(JTF3);
		
		JL4.setBounds(200, 140, 150, 30);
		JL4.setFont(new Font("宋体", Font.BOLD, 20));
		JP.add(JL4);
		ButtonGroup bg = new ButtonGroup();
	    bg.add(JTF41);
		bg.add(JTF42);
		JTF41.setBounds(450,140,40,30);
		JTF42.setBounds(750,140,40,30);	   
		JP.add(JTF41);
		JP.add(JTF42);
		
		
		JL5.setBounds(200, 180,150, 30);
		JL5.setFont(new Font("宋体", Font.BOLD, 20));
		JP.add(JL5);
		JTF5.setSize(400,300);
		JTF5.setLocation(400, 180);
		JP.add(JTF5);
		
		QR.setBounds(380, 500, 100, 40);
		QX.setBounds(500, 500, 100, 40);
		JP.add(QR);
		JP.add(QX);
		this.add(JP);
		this.setResizable(false);
		this.setBounds(200, 90, 950, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JTF2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				String text1 = JTF2.getText();
				if (text1.trim().length()<=0)  
					JTF2.setText("请输入姓名");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				String text1 = JTF2 .getText();
				//判断当前输入框中的内容是否和原始数据（请输入姓名）一样
				if ("请输入姓名".equals(text1)) {
					JTF2.setText("");
					
				}
				
			}
		});
		
		JTF3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				String text2 = JTF3.getText();
				if (text2.trim().length()<=0) 
					JTF3.setText("请输入年龄");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				String text2 = JTF3 .getText();
				if ("请输入年龄".equals(text2)) {
					JTF3.setText("");
					
				}
				
			}
		});

		JTF5.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO 自动生成的方法存根
				String text3 = JTF5.getText();
				if (text3.trim().length()<=0) 
					JTF5.setText("请输入历史病例");
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO 自动生成的方法存根
				String text3 = JTF5.getText();
				if ("请输入历史病例".equals(text3)) {
					JTF5.setText("");
					
				}
				
			}
		});
		  
				QR.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						//IO流创建并写入文件
						//创建一个File的实例对象，创建一个ticket的文件
						File file = new File("a1.txt");
			    		//IO异常
			    		try {
							String text1 = JTF2.getText();
							System.out.println(text1);
							String text2 = JTF3.getText();
							String sex ="";
							if (JTF41.isSelected()) {
								sex = JTF41.getText();
							}else if (JTF42.isSelected()) {
							    sex =JTF42.getText();
							}
							//System.out.println(sex);
			    			String text3 = JTF5.getText();
			    		
			    			 if (!file.exists()) {
			    				 file.createNewFile();
			    			 }
			    			 //通过BufferedWrite方法将数据写入文件
			    			 //System.out.println("aaaaa");
			    			 FileWriter fw = new FileWriter(file,true);
			    			 BufferedWriter bw = new BufferedWriter(fw);
			    			 bw.write("姓名："+text1+"    ");
			    			 bw.write("年龄："+text2+"    ");
			    			 bw.write("性别："+sex+"    ");
			    			 bw.write("历史病例："+text3+"  \r\n  ");
			    			 bw.flush();
			    			 bw.close();
			    			 
			    		} catch (IOException e1) {
			    			e1.printStackTrace();
			            }
						//f.setVisible(false);
			    	
			    		//JOptionPane.showMessageDialog(JTF5, "档案信息已登入");
			    	}
			 
			    });
		
		QR.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		
	    		
				String text1 = JTF2.getText();
				String text2 = JTF3.getText();
				String sex ="";
				if (JTF41.isSelected()) {
					sex = JTF41.getText();
				}else if (JTF42.isSelected()) {
					sex =JTF42.getText();
				}
    			String text3 = JTF5.getText();
    				
    			if (text1.equals("请输入姓名")){	
    				JOptionPane.showMessageDialog(JTF5, "请输入姓名");
    			}else if (text2.equals("请输入年龄")) {
    				JOptionPane.showMessageDialog(JTF5, "请输入年龄");
    			}else if (text3.equals("请输入历史病例")) {
    				JOptionPane.showMessageDialog(JTF5, "请输入历史病例");
    			}else if (text1!="请输入姓名" && text2!= "请输入年龄"  && text3!="请输入历史病例") {
    				JOptionPane.showMessageDialog(JTF5, "档案信息已登入");
	    				
	    				JuMing.this.setVisible(false);
	    				//new view();
    			}
    			Info info  = new Info(text1, text2,sex,text3);
    			//将信息添加到所有信息中。
    			JMDB.info.put(text1, info);
    			//将信息通过 saveData(buyerDB,info,"info");保存
    			JMDB db = new JMDB();
    			db.saveData(JMDB.info, "info");
	    	}});
		QX.addMouseListener(new MouseAdapter() {
			
		
			@Override
			public void mouseClicked(MouseEvent e) {
				JuMing.this.setVisible(false);
				
			}
			
		});
	}

		
	protected String getUserLaber() {
				// TODO Auto-generated method stub
				return null;
	}
	
	
	public static void main(String[] args) {
		new JuMing("档案信息");
		
	}
	
	public void actionPerformed(ActionEvent e) {
	     Object obj = e.getSource();
	     if(QR==obj){
	     }
	  		
	}
}
