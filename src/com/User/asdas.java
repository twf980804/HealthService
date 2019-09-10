package com.User;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class asdas extends JFrame{
	JPanel P = new JPanel(
		new FlowLayout(FlowLayout.CENTER,40,5));
	String[] columnNames =
		{"姓名","年龄","性别","病例"};
	DefaultTableModel dtm = 
			new DefaultTableModel(columnNames, 0);
	JTable userTable = new JTable(dtm);
	JScrollPane scrollPane = 
			new JScrollPane(userTable);
	public asdas() {
		this.setLayout(new BorderLayout());
		init();
	}
	public void init(){this.add(P,BorderLayout.NORTH);
		/*将原来持久化的所有的用户信息在表格中显示*/
		Collection<Info> coll = JMDB.info.values();
		for(Info u:coll){
			Object[] rowData = new Object[4];
			rowData[0] = u.getText1();
			rowData[1] = u.getText2();
			rowData[2] = u.getSex();
			rowData[3] = u.getText3();
			
			dtm.addRow(rowData);
		}
		
		this.setBounds(530,180,450,400);
		this.add(scrollPane,BorderLayout.CENTER);
		this.setVisible(true);
		
	}
}
