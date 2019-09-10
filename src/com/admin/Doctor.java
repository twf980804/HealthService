package com.admin;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	public class Doctor {
		public Doctor() {
			super();
			init();
		}
		public void init(){
			final JFrame f = new JFrame("社区健康服务信息系统");
			JPanel imagePanel;
		    ImageIcon background;
			f.setLayout(null);
			f.setBounds(200,90,950,600);
			JLabel l = new JLabel("欢迎进入社区健康服务信息中心：医疗区域");
			l.setBounds(230,20,500,150);
	        l.setFont(new Font("BOLD", Font.BOLD, 25));
			l.setOpaque(false);//因为JLabel是默认透明的，只有先取消其透明度。才可以显示颜色，对其它控件也一样。
	        f.add(l);
	        
	      //背景图片
			background = new ImageIcon("denglu.png");// 背景图片
			JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
			// 把标签的大小位置设置为图片刚好填充整个面板
			label.setBounds(0, 0, background.getIconWidth(),
					background.getIconHeight());
			// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
			imagePanel = (JPanel) f.getContentPane();
			imagePanel.setOpaque(false);
			// 内容窗格默认的布局管理器为BorderLayout
			
			f.getLayeredPane().setLayout(null);
			// 把背景图片添加到分层窗格的最底层作为背景
			f.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(background.getIconWidth(), background.getIconHeight());
			f.setResizable(false);
	        

	        JButton btn1 = new JButton("查看预约状态");
	        f.add(btn1);
	        btn1.setBounds(50,180,150,50);
			btn1.setContentAreaFilled(false); //按钮透明
	        btn1.addMouseListener(new MouseAdapter() {
	        	@Override
	        		public void mouseClicked(MouseEvent e) {
	        			// TODO Auto-generated method stub
//	        		this.setVisible(false);
	        		new View();
	        	}
	        		});
	        JButton btn2 = new JButton("患者个人档案");
	        f.add(btn2);
	        btn2.setBounds(50,270,150,50);
			btn2.setContentAreaFilled(false); //按钮透明
	        btn2.addMouseListener(new MouseAdapter() {
	        	@Override
	        		public void mouseClicked(MouseEvent e) {
	        			// TODO Auto-generated method stub
//	        		this.setVisible(false);
	        		new DangAnView();
	        	}
	        		});
	        JButton btn3 = new JButton("药品售出信息");
	        f.add(btn3);
	        btn3.setBounds(50,360,150,50);
			btn3.setContentAreaFilled(false); //按钮透明
	        btn3.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		// TODO Auto-generated method stub
//	        		this.setVisible(false);
	        		new ypinformation();
	        	}
	        });
	        JButton btn4 = new JButton("医患交流");
	        f.add(btn4);
	        btn4.setBounds(50,450,150,50);
			btn4.setContentAreaFilled(false); //按钮透明
	        btn4.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		// TODO Auto-generated method stub
//	        		this.setVisible(false);
	        		new WindowServer();
	        	}
	        });
	        JButton btn6 = new JButton("退出");
	        f.add(btn6);
			btn6.setContentAreaFilled(false); //按钮透明
	        btn6.setForeground(Color.red);
	        btn6.setBounds(800,480,80,50);
	        
	        btn6.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		// TODO Auto-generated method stub
	        		System.exit(0);	    
            }
	        });
	        f.addWindowListener(new WindowAdapter() {
	        	
	        	@Override
	        	public void windowClosing(WindowEvent e) {
	        		// TODO Auto-generated method stub
	        		//System.exit(0);	
					f.setVisible(false);
	        	}
	        	
	        });
	        f.setVisible(true);
		}
	public static void main(String args[]){
		new Doctor();
	}

}
