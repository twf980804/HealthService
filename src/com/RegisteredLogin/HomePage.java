package com.RegisteredLogin;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePage {
	public HomePage() {}
	
	JFrame GUI = new JFrame("社区健康服务信息系统");
	private JPanel imagePanel;
	private ImageIcon background;
	JLabel l1 = new JLabel("社区健康服务信息系统");
	JButton b1 = new JButton("登陆");
	JButton b2 = new JButton("注册");
	JButton b3 = new JButton("退出系统");
public void HomePageGUI() {
	//背景图片
	background = new ImageIcon("denglu.png");// 背景图片
	JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
	// 把标签的大小位置设置为图片刚好填充整个面板
	label.setBounds(0, 0, background.getIconWidth(),
			background.getIconHeight());
	// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
	imagePanel = (JPanel) GUI.getContentPane();
	imagePanel.setOpaque(false);
	// 内容窗格默认的布局管理器为BorderLayout
	imagePanel.setLayout(new FlowLayout());
	
	GUI.getLayeredPane().setLayout(null);
	// 把背景图片添加到分层窗格的最底层作为背景
	GUI.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
	GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	GUI.setSize(background.getIconWidth(), background.getIconHeight());
	GUI.setResizable(false);
	
	GUI.setBounds(200, 90, 950, 600);
	
	GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	GUI.setLayout(null);
	GUI.add(l1);
	l1.setBounds(280, 200, 400, 38);
	Font font=new Font("Monospaced",Font.BOLD,38);//设置字体格式和大小
	l1.setForeground(Color.BLACK);//设置前景色
	l1.setFont(font);
	GUI.add(b1);
	b1.setBounds(340, 370, 80, 35);
	b1.setFont(new Font("Monospaced", Font.BOLD, 22)); 
    b1.setContentAreaFilled(false); //按钮透明
	GUI.add(b2);
	b1.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new denglu();		
			GUI.setVisible(false);
			}
	});
	b2.setBounds(510, 370, 80, 35);
	b2.setFont(new Font("Monospaced", Font.BOLD, 22)); 
    b2.setContentAreaFilled(false); //按钮透明
	b2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new zhuce();
			GUI.setVisible(false);
			}
	});
	GUI.add(b3);
	b3.setBounds(800, 20, 119, 35);
	b3.setFont(new Font("Monospaced", Font.BOLD, 20)); 
    b3.setContentAreaFilled(false); //按钮透明
	b3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);;
		}
	});
	
	ImageIcon img = new ImageIcon("C:\\Users\\lenovo\\Desktop\\新建文件夹 (2)\\src\\com\\RegisteredLogin\\denglu.png"); //传入背景图片路径
	JLabel background = new JLabel(img);//将图片放进标签里
	GUI.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE));//将标签放进容器里
	background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());//设置标签的大小*/
	GUI.setVisible(true);

}
public static void main(String[] args) {
	HomePage hp = new HomePage();
	hp.HomePageGUI();
}
}
