package com.User;


import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Buy {
	public  Buy() {
	super();
	init();
	
}
public void init(){
	final JFrame f = new JFrame("欢迎使用购药平台");
	JPanel imagePanel;
    ImageIcon background;
	f.setLayout(null);
	f.setBounds(200,90,950,600);
	
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
	
	JLabel  l1 = new JLabel("购药平台");
	l1.setFont(new Font("BOLD", Font.BOLD, 35));
	l1.setBounds(350,90,400,50);
	l1.setOpaque(false);//因为JLabel是默认透明的，只有先取消其透明度。才可以显示颜色，对其它控件也一样。
	f.add(l1);
	
	//站点设置
	JLabel l2 = new JLabel("药    品：");
	l2.setFont(new Font("BOLD", Font.BOLD, 25));
	l2.setBounds(300,180,120,35);
	l2.setOpaque(false);//因为JLabel是默认透明的，只有先取消其透明度。才可以显示颜色，对其它控件也一样。
	f.add(l2);
	
	 final JComboBox<String> kinSelect = 
			new JComboBox<String>(
				new String[]{"-种类-","感冒","退烧","消炎","止咳",
						"外伤","过敏","特效药","杀菌","中药","等等"});
	 
	 final JComboBox<String> name1Select = 
			new JComboBox<String>(
					new String[]{"-名称-"});
	 final String[][] name1s = 
			new String[][]{
			{"氨咖黄敏胶囊  ＄15","双黄连口服液  ＄15","感冒灵  ＄15","快客  ＄15"},
			{"复方氨酚烷胺片  ＄15","阿司匹林  ＄15","布洛芬  ＄15"},
			{"罗红霉素胶囊  ＄15","阿奇霉素  ＄15","红霉素  ＄15"},
			{"半夏糖浆  ＄15","999止咳  ＄15","京都念慈菴  ＄15"},
			{"绷带  ＄15","碘酒  ＄15","百多邦莫匹罗星软膏  ＄15","过氧化氢溶液  ＄15"},
			{"氯雷他定片  ＄15","扑尔敏  ＄15"},
			{"速效救心丸（心脏病）  ＄15","降压药  ＄15"},
			{"盐酸吗啉胍  ＄15","过氧化氢溶液  ＄15"},
			{"板蓝根  ＄15","川贝母  ＄15","甘草  ＄15","云南白药  ＄15","西瓜霜  ＄15"},
			{"。。。。"},
	};
	 kinSelect.setBounds(410, 180,110, 30);
	f.add(kinSelect);
	name1Select.setBounds(530, 180,160, 30);
	f.add(name1Select);
	 
	JLabel l3 = new JLabel("数    量：");
	l3.setFont(new Font("BOLD", Font.BOLD, 25));
	l3.setBounds(300,240,120,50);
	l3.setOpaque(false);//因为JLabel是默认透明的，只有先取消其透明度。才可以显示颜色，对其它控件也一样。
	f.add(l3);
	
 final JComboBox<String> numberSelect = 
			new JComboBox<String>(
					new String[]{"-                      请选择                    -"});
final String[][] numbers = 
     new String[][]{
	    	{"1","2","3","4","5","6","7","8","9","10"},


	};
	
numberSelect.setBounds(410,240,240, 30);
	f.add(numberSelect);

	
	kinSelect.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int index = name1Select.getSelectedIndex();
			//删除原来的信息
			name1Select.removeAllItems();
			//获取当前选中的信息
			String[] name1 = name1s[index];
			for(String c:name1){
				//将每一个信息添加到当前name1Select中 。
				name1Select.addItem(c);
			}
		}
	});
	
	name1Select.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int index = numberSelect.getSelectedIndex();
			//删除原来的信息
			numberSelect.removeAllItems();
			//获取当前选中的信息
			String[] number = numbers[index];
			for(String c:number){
				//将每一个信息添加到当前numberSelect中 。
				numberSelect.addItem(c);
			}
		}
	});
	

	JLabel l4 = new JLabel("社区健康信息中心感谢您的支持。");
	l4.setFont(new Font("BOLD", Font.BOLD, 18));
	l4.setBounds(300,420,280,20);
	l4.setOpaque(false);//因为JLabel是默认透明的，只有先取消其透明度。才可以显示颜色，对其它控件也一样。
	l4.setForeground(Color.black);
	f.add(l4);
	
	
	JButton btn2 = new JButton("取消");
	btn2.setBounds(450,340,90,40);
	btn2.setContentAreaFilled(false); //按钮透明
	f.add(btn2);
	btn2.setForeground(Color.red);
    btn2.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		// TODO Auto-generated method stub
//    		this.setVisible(false);
    		new Patient();
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
	JButton btn3 = new JButton("已购列表");
	btn3.setBounds(580,340,90,40);
	btn3.setContentAreaFilled(false); //按钮透明
	f.add(btn3);
	btn3.setForeground(Color.black);
    btn3.addMouseListener(new MouseAdapter() {
    	@Override
    	public void mouseClicked(MouseEvent e) {
    		// TODO Auto-generated method stub
//    		this.setVisible(false);
    		new yaopininformation();
    		f.setVisible(true);
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
	//购票按钮
	final JButton btn1 = new JButton("确认");
	btn1.setBounds(300,340,90,40);
	btn1.setContentAreaFilled(false); //按钮透明
	//当购票按钮被点击时，获取所有用户输入的信息
	//进行持久化。

    btn1.addMouseListener(new MouseAdapter() {
    	public void mouseClicked(MouseEvent e) {
    		
    	if(kinSelect.getSelectedItem().equals("种类-")||
    
    			name1Select.getSelectedItem().equals("-名称-")){
        	// TODO Auto-generated method stub
    		JOptionPane.showMessageDialog(l2, "购药信息未完善",null, JOptionPane.WARNING_MESSAGE);
 

   
    	}else{	
			String name = 
				(String)name1Select.getSelectedItem();
			String number = 
					(String)numberSelect.getSelectedItem();
		    int n1 = Integer.parseInt(number);
			int p=15* n1;
			int price =p;
			yaopin yaopin  = new yaopin(name,price,number);
			//将信息添加到所有信息中。
		     
		     yaopinDB.yaopins.put(name,yaopin);
			//将信息通过 saveData(buyerDB,yaopins,"yaopins");保存
			yaopinDB db = new yaopinDB();
			db.saveData(yaopinDB.yaopins, "yaopin");

 		JOptionPane.showMessageDialog(l2, "购买成功",null, JOptionPane.WARNING_MESSAGE);
 		

    		f.setVisible(true);}}}
    
    				);
    
	f.add(btn1);
	f.setVisible(true);
	
}
	public static void main(String[] args) {
		new Buy();
	}

}