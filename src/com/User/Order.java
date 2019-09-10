package com.User;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
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

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.admin.View;



public class Order {
	public Order() {
		super();
		OrderGUI();
	}

	  //初始化字体
			Font d = new Font("楷体", Font.BOLD, 22);
			Font f = new Font("楷体", Font.BOLD, 15);
			// 初始化对象
	JFrame orderGUI = new JFrame("预约平台");

	private JPanel imagePanel;
	private ImageIcon background;
	JLabel reservation = new JLabel("预约平台");
	JLabel patient = new JLabel("患   者：");
	JLabel doctor = new JLabel("预约医生：");
	JLabel time = new JLabel("预约时间：");
	TextField userField =new TextField();
	JComboBox box1 = new JComboBox(new String[]{"-请选择-","宁医生","张医生","栾医生"} );
	JComboBox box2 = new JComboBox(new String[]{"-请选择-","宁医生","张医生","栾医生"} );
	JButton bt1 = new JButton("预约");
	JButton bt2 = new JButton("取消");
	JButton bt4 = new JButton("退出系统");
public void OrderGUI() {
	//背景图片
	background = new ImageIcon("denglu.png");// 背景图片
	JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
	// 把标签的大小位置设置为图片刚好填充整个面板
	label.setBounds(0, 0, background.getIconWidth(),
			background.getIconHeight());
	// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
	imagePanel = (JPanel) orderGUI.getContentPane();
	imagePanel.setOpaque(false);
	// 内容窗格默认的布局管理器为BorderLayout
	imagePanel.setLayout(new FlowLayout());
	
	orderGUI.getLayeredPane().setLayout(null);
	// 把背景图片添加到分层窗格的最底层作为背景
	orderGUI.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	orderGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	orderGUI.setSize(background.getIconWidth(), background.getIconHeight());
	orderGUI.setResizable(false);
	
	
	// 设置对象
			orderGUI.setBounds(200, 90, 950, 600);
			//设置退出
			orderGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//取消框架格式
			orderGUI.setLayout(null);
			//设置位置、大小和字体
			reservation.setBounds(380, 60, 400, 40);
			Font font1=new Font("Monospaced",Font.BOLD,38);//设置字体格式和大小
			reservation.setForeground(Color.BLACK);//设置前景色
			reservation.setFont(font1);
			patient.setBounds(300,150,160,30);
			Font font2=new Font("Monospaced",Font.BOLD,30);//设置字体格式和大小
			patient.setForeground(Color.BLACK);//设置前景色
			patient.setFont(font2);
			doctor.setBounds(300, 220, 160, 30);
			doctor.setFont(font2);
			time.setBounds(300, 290, 160, 30);
			time.setFont(font2);
			userField.setBounds(460, 150, 150, 30);
			Font font3=new Font("Monospaced",Font.BOLD,19);//设置字体格式和大小
			reservation.setForeground(Color.BLACK);//设置前景色
			userField.setFont(font3);
			userField.addFocusListener(new FocusListener() {
				
				@Override
				public void focusLost(FocusEvent e) {
					
					// TODO 自动生成的方法存根
					String text = userField.getText();
					//当文本框中用户输入的信息的长度<=0的时候，提示用户输入
					if(text.trim().length()<=0){
						userField.setText("请输入患者姓名");
					}
					
				}
				//当输入框失去焦点时触发
				@Override
				public void focusGained(FocusEvent e) {
					// TODO 自动生成的方法存根
					String text = userField.getText();
					//判断当前输入框中的内容是否和原始数据(请输入用户名)一致，
					//如果一致，代表用户未曾输入，将信息设置""
					if("请输入患者姓名".equals(text)){
						userField.setText("");
					}
				}
			});
			box1.setBounds(460, 220, 150, 30);
			box1.setFont(font3);
			box2.setBounds(460, 290, 150, 30);
			box2.setFont(font3);
			bt1.setBounds(350, 380, 80, 35);
			bt1.setFont(new Font("Monospaced", Font.BOLD, 22)); 
		    bt1.setContentAreaFilled(false); //按钮透明
		    //bt1.setBorderPainted(false); //去掉按钮边框
			bt1.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent e) {
					//IO流创建并写入文件
					//创建一个File的实例对象，创建一个ticket的文件
					File file = new File("ReservationInformation.txt");
					//IO异常
					try {
						String text = userField.getText();
						String doctor1 = (String) box1.getSelectedItem();
						String time1 = (String) box2.getSelectedItem();
						if (!file.exists()) {
							file.createNewFile();
						}
						//通过BufferedWrite方法将数据写入文件
						FileWriter fw = new FileWriter(file,true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(text+"    ");
						bw.write(doctor1+"        ");
						bw.write(time1+"\r\n");
						bw.flush();
						bw.close();
						
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					//	f.setVisible(false);
				}
			});

		    bt1.addMouseListener(new MouseAdapter() {
			    	public void mouseClicked(MouseEvent e) {
			    		
			    		String name = userField.getText();
			    		name = "              "+name;
			    		String doctor1 = 
			    				(String)box1.getSelectedItem();
			    		
			    		String time1 = 
			    				(String)box2.getSelectedItem();
			    	if(box1.getSelectedItem().equals("-请选择-")||
			    			box2.getSelectedItem().equals("-请选择-")
			    			){
			        	// TODO Auto-generated method stub
			    		JOptionPane.showMessageDialog(box1, "预约信息未完善",null, JOptionPane.WARNING_MESSAGE);
			 

			   
			    	}else if(userField.getText().equals("请输入患者姓名")||userField.getText().equals("")){
			        	// TODO Auto-generated method stub
			    		JOptionPane.showMessageDialog(doctor, "请输入患者姓名",null, JOptionPane.WARNING_MESSAGE);

			    	}
			    	else if(name!="请输入患者姓名" && doctor1!= "-请选择-"  && time1!="-请选择-"	){
						//将信息添加到所有信息中。
			    		JOptionPane.showMessageDialog(box2, "预约成功",null, JOptionPane.WARNING_MESSAGE);
			    	}
			    	Information info  = new Information(name, doctor1,time1);
						DB.info.put(name, info);
						//将信息通过 saveData(buyerDB,info,"info");保存
						DB db = new DB();
						db.saveData(DB.info, "info");
			    
			 		
			         /*  orderGUI.setVisible(false);*/}}
			    				);
			bt2.setBounds(490, 380, 80, 35);
			bt2.setFont(new Font("Monospaced", Font.BOLD, 22)); 
		    bt2.setContentAreaFilled(false); //按钮透明
		    //bt2.setBorderPainted(false); //去掉按钮边框
			bt2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					new Patient();
				}
			});
			
			bt4.setBounds(800, 20, 119, 35);
			bt4.setFont(new Font("Monospaced", Font.BOLD, 20));
		    bt4.setContentAreaFilled(false); //按钮透明
			//bt4.setBorder(BorderFactory.createLoweredBevelBorder());  //凹进去的按钮
			bt4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);;
				}
			});
			// 添加对象
			orderGUI.add(reservation);
			orderGUI.add(patient);
			orderGUI.add(doctor);
			orderGUI.add(time);
			orderGUI.add(userField);
			orderGUI.add(box1);
			orderGUI.add(box2);
			orderGUI.add(bt1);
			orderGUI.add(bt2);
			orderGUI.add(bt4);
			// 窗体可视化
			orderGUI.setVisible(true);
			
}

//整个程序执行的入口
public static void main(String[] args) {
	Order o = new Order();
	o.OrderGUI();
	new Order();
}
}
