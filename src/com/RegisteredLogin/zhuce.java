package com.RegisteredLogin;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.RegisteredLogin.denglu;

public class zhuce{
	
	

public static void main(String[] args) {
	new zhuce();
}
public zhuce() {
	JFrame jFrame = new JFrame("注册界面");
    JPanel imagePanel;
    ImageIcon background;
	jFrame.setBounds(200,90,950,600);
	jFrame.setResizable(false);
	jFrame.setLayout(null);
	jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	//背景图片
		background = new ImageIcon("denglu.png");// 背景图片
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		imagePanel = (JPanel) jFrame.getContentPane();
		imagePanel.setOpaque(false);
		// 内容窗格默认的布局管理器为BorderLayout
		
		jFrame.getLayeredPane().setLayout(null);
		// 把背景图片添加到分层窗格的最底层作为背景
		jFrame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(background.getIconWidth(), background.getIconHeight());
		jFrame.setResizable(false);
	
	
	JRadioButton hbtn = new JRadioButton("患者用户");
	JRadioButton ybtn = new JRadioButton("医疗人员");
	hbtn.setContentAreaFilled(false); //按钮透明
	ybtn.setContentAreaFilled(false); //按钮透明
	ButtonGroup hy = new ButtonGroup();
	hy.add(hbtn);
	hy.add(ybtn);
	hbtn.setBounds(220,80,80,30);
	ybtn.setBounds(320,80,80,30);	   
	jFrame.add(hbtn);
	jFrame.add(ybtn);
	
	
	JLabel label1 = new JLabel("姓   名");
	label1.setFont(new Font("BOLD", Font.BOLD, 15));
	label1.setBounds(205, 120, 50, 40);
	jFrame.add(label1);
	
	JLabel label2 = new JLabel("密   码");
	label2.setFont(new Font("BOLD", Font.BOLD, 15));
	label2.setBounds(205, 175, 50, 40);
	jFrame.add(label2);
	
	JLabel label3 = new JLabel("证件号");
	label3.setFont(new Font("BOLD", Font.BOLD, 15));
	label3.setBounds(205, 230, 50, 40);
	jFrame.add(label3);
	
	JLabel label4 = new JLabel("住   址");
	label4.setFont(new Font("BOLD", Font.BOLD, 15));
	label4.setBounds(205, 285, 50, 40);
	jFrame.add(label4);
	
	final JTextField text1 = new JTextField();
	text1.setBounds(260, 130, 150, 25);
	jFrame.add(text1);
	
	final JTextField text2 = new JTextField();
	text2.setBounds(260, 185, 150, 25);
	jFrame.add(text2);
	
	final JTextField text3 = new JTextField();
	text3.setBounds(260, 240, 150, 25);
	jFrame.add(text3);
	
	final JTextField text4 = new JTextField();
	text4.setBounds(260, 295, 150, 25);
	jFrame.add(text4);
	
	
	JButton button = new JButton("确定");
	button.setBounds(205, 340, 200, 40);
	button.setContentAreaFilled(false); //按钮透明
	button.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
//1.如果用户名是原始数据，请弹框提示用户进行输入
//2.根据用户名判断当前用户是否已经被注册
			
//if(!UserDB.exists(p1)){
			if (text1.getText().equals("")) {
				
				JOptionPane.showMessageDialog
				(button, "用户名不能为空！","警告信息",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(text2.getText().equals("")){
				JOptionPane.showMessageDialog
				(button, "密码不能为空！","警告信息",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			if(text3.getText().equals("")){
				JOptionPane.showMessageDialog
				(button, "证件不能为空！","警告信息",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
			else{
				
				String t1 = text1.getText();
				String t2 = text2.getText();
				JOptionPane.showMessageDialog(button,"用户名："+t1+'\n'+
						"密    码："+t2, "恭喜你注册成功",
						JOptionPane.WARNING_MESSAGE);
								
			}
		}	
	});
	
	button.addMouseListener(new MouseAdapter() {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO 自动生成的方法存根
			
			String name = text1.getText();
			String pwd = text2.getText();
			String id = text3.getText();
			String add = text4.getText();
			
			if(hbtn.isSelected()){
				User user = new User(name, pwd, id, add);
//将用户信息添加到所有注册用户信息中。
				UserDB.users.put(name, user);
				UserDB db = new UserDB();
//持久化：
				db.saveData(user,"users");
//System.out.println(UserDB.users);
				
			} else  if(ybtn.isSelected()){
				Adm adm = new Adm(name, pwd, id, add);
				//将用户信息添加到所有注册用户信息中。
				AdmDB.adms.put(name, adm);
				AdmDB db = new AdmDB();
				//持久化：
				db.saveData(adm,"adms");
				//System.out.println(AdmDB.adms);		
			}else{
				JOptionPane.showMessageDialog
				(button, "身份未确定！","警告信息",JOptionPane.WARNING_MESSAGE);
				return;
				
			}
		}
	});
	
	jFrame.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			//System.exit(0);
			jFrame.setVisible(false);
			
		}	
	});
	jFrame.setVisible(true);
	
	JButton button2 = new JButton("返回");
	button2.setBounds(205, 400, 200, 40);
	button2.setContentAreaFilled(false); //按钮透明
	button2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
//		this.setVisible(false);
			new denglu();
			jFrame.setVisible(false);
		}
	});
	jFrame.addWindowListener(new WindowAdapter() {
		
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			//System.exit(0);	
			jFrame.setVisible(false);
		}
		
	});
	
	jFrame.add(button2);
	jFrame.add(button);
	
	jFrame.setVisible(true);
	
}
}
