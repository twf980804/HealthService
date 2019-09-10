package com.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Collection;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.User.Buy;
import com.User.yaopin;
import com.User.yaopinDB;

public class ypinformation extends JFrame{
	JPanel P = new JPanel(
		new FlowLayout(FlowLayout.CENTER,40,5));
	String[] columnNames =
		{"药品","数量","价格"};
	DefaultTableModel dtm = 
			new DefaultTableModel(columnNames, 0);
	JTable userTable = new JTable(dtm);
	JScrollPane scrollPane = 
			new JScrollPane(userTable);
	public ypinformation() {
		this.setLayout(new BorderLayout());
		init();
	}
	
	public void init(){this.add(P,BorderLayout.NORTH);
		/*将原来持久化的所有的用户信息在表格中显示*/
		Collection<yaopin> coll = yaopinDB.yaopins.values();
		for(yaopin u:coll){
			Object[] rowData = new Object[4];
			rowData[0] = u.getName();
			rowData[1] = u.getNumber();
			rowData[2] = u.getPrice();
			
			dtm.addRow(rowData);
		}
		
		this.setBounds(1250,200,450,400);
		this.add(scrollPane,BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	
}
