package com.User;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

	public class Near {
		public Near() {
			super();
			init();
		}
		public void init(){
			final Frame f = new Frame("社区周边服务");
			f.setLayout(null);
			f.setBounds(200,90,950,600);
			f.setBackground(Color.cyan);
			Label l = new Label("兰州市七里河区龚家湾");
			l.setBounds(300,70,600,100);
	        l.setFont(new Font("BOLD", Font.BOLD, 30));
	        
			Label a = new Label("彭家坪西路社卫站："
					+ "电话：0931-3645686"+"    地址：xxxxx");
			a.setBounds(230,250,550,50);
	        a.setFont(new Font("BOLD", Font.BOLD, 20));
	        
	        
			Label b = new Label("七里河区xxx诊所："
					+ "电话：6666-9999999"+"    地址：xxxxx");
			b.setBounds(230,350,550,50);
	        b.setFont(new Font("BOLD", Font.BOLD, 20));
	        
	        
	        
	        
			Label c = new Label("七里河区xx医院："
					+ "电话：6666-99988888"+"    地址：xxxxx");
			c.setBounds(230,450,550,50);
	        c.setFont(new Font("BOLD", Font.BOLD, 20));
	        
	        
	        f.add(l);
	        f.add(a);
	        f.add(b);
	        f.add(c);
	        Button btn = new Button("返回");
	        f.add(btn);
	        btn.setBounds(800,480,80,50);
	        
	        btn.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		// TODO Auto-generated method stub
	        		f.setVisible(false);
	        
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
		new Near();
	}

}
