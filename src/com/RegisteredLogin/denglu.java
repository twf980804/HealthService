package com.RegisteredLogin;
import java.awt.Font;
import java.awt.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.User.Patient;
import com.admin.Doctor;





public class denglu {

	 	 
public static void main(String[] args) {

				new denglu();
}

			public  denglu() {
				
				JFrame jFrame = new JFrame("登陆界面");
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
				
				jFrame.setVisible(true);
			
				
				
				JLabel label0 = new JLabel("欢迎进入社区健康服务信息中心");
				label0.setFont(new Font("BOLD", Font.BOLD, 25));
				label0.setBounds(300, 80, 500, 50);
				jFrame.add(label0);
				
				JLabel label1 = new JLabel("姓名");
				label1.setFont(new Font("BOLD", Font.BOLD, 15));
				label1.setBounds(400, 140, 100, 50);
				jFrame.add(label1);
				
				JLabel label2 = new JLabel("密码");
				label2.setFont(new Font("BOLD", Font.BOLD, 15));
				label2.setBounds(400, 200, 100, 50);
				jFrame.add(label2);
				
				final JTextField text1 = new JTextField();
				text1.setBounds(450, 145, 130, 25);
				jFrame.add(text1);
				
				final JPasswordField text2 = new JPasswordField();
				text2.setBounds(450, 205, 130,25);
				jFrame.add(text2);
				JRadioButton hbtn = new JRadioButton("患者用户");
				JRadioButton ybtn = new JRadioButton("医疗人员");
				hbtn.setContentAreaFilled(false); //按钮透明
				ybtn.setContentAreaFilled(false); //按钮透明
				ButtonGroup bg = new ButtonGroup();
				bg.add(hbtn);
				bg.add(ybtn);
				hbtn.setBounds(410,250,80,30);
				ybtn.setBounds(500,250,80,30);	   
				jFrame.add(hbtn);
				jFrame.add(ybtn);
				
				
				JButton button = new JButton("登录");
				button.setBounds(105, 295, 180, 40);
				button.setContentAreaFilled(false); //按钮透明
				jFrame.add(button);
				
				button.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
					}
					
					public void mouseClicked(MouseEvent e) {
						
						// TODO Auto-generated method stub
						// this.setVisible(false);
						if(hbtn.isSelected()){
							String pwd = text2.getText();
							User user = UserDB.users.get(text1.getText());
							if(user==null||!pwd.equals(user.getT2())){
								JOptionPane.showMessageDialog(
										button, "用户名或密码错误！");
							}else{
								JOptionPane.showMessageDialog(button, "登陆成功！");
								jFrame.setVisible(false);
									new Patient();
							}}else if(ybtn.isSelected()){
								String pwd = text2.getText();
								Adm adm = AdmDB.adms.get(text1.getText());
								if(adm==null||!pwd.equals(adm.getT2())){
									JOptionPane.showMessageDialog(
											button, "用户名或密码错误！");
								}else{
									JOptionPane.showMessageDialog(button, "登陆成功！");
									jFrame.setVisible(false);
										new Doctor();
								}		
							}else{
								JOptionPane.showMessageDialog(button, "身份未确认！");
							}
							
						}
				});
				
				
				text1.addFocusListener(new FocusListener() {
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						String text = text1.getText();
						if(text.trim().length()<=0)
							text1.setText("请输入用户名");
					}
					
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						String text = text1.getText();
						if("请输入用户名".equals(text)){
							text1.setText("");
						}
					}
				});
				text2.addFocusListener(new FocusListener() {
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						String text1 = text2.getText();
						if(text1.trim().length()<=0)
							text2.setText("请输入密码");
					}
					
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						String text1 = text2.getText();
						if("请输入密码".equals(text1)){
							text2.setText("");
						}
					}
					
					
				});
				
				jFrame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
//			System.exit(0);
						jFrame.setVisible(false);
					}	
				});
				
				jFrame.setVisible(true);
				
				
				JButton button2 = new JButton("注册");
				button2.setBounds(105, 350, 180, 40);
				button2.setContentAreaFilled(false); //按钮透明
				button2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						new zhuce();
						
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
				
				jFrame.setVisible(true);
				
			
			}
			


			public void setVisible(boolean b) {
				// TODO Auto-generated method stub
			}
			static Frame jFrame;
			public static void main1(String[] args) {
//	系统启动时，将原来持久化的数据加载到当前内存中来
				UserDB db = new UserDB();
				@SuppressWarnings("unchecked")
				HashMap<String, User> map = 
				(HashMap<String, User>)db.getData("users");
//	将读取到的上次持久化的数据，放入当前系统数据集合UserDB.users
				System.out.println(map);
				if(map!=null){
					UserDB.users.putAll(map);
				}
				jFrame = new Frame("登陆");
				
				AdmDB db1 = new AdmDB();
				@SuppressWarnings("unchecked")
				HashMap<String, Adm> map1 = 
				(HashMap<String, Adm>)db1.getData("adms");
				
				System.out.println(map1);
				if(map1!=null){
					AdmDB.adms.putAll(map1);
				}
				
			}
}