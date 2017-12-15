/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class signinsuccess extends JFrame {

	private JPanel contentPane;
	private final JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        signinsuccess frame = new signinsuccess();
                        frame.setVisible(true);
                    } catch (Exception e) {
                    }
                });
	}

	/**
	 * Create the frame.
	 */
	public signinsuccess() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		String data[][]=null;
		String column[]=null;
		try{
                    try (Connection con = DB.getConnection()) {
                        PreparedStatement ps=con.prepareStatement("select * from colleges",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs=ps.executeQuery();
                        
                        ResultSetMetaData rsmd=rs.getMetaData();
                        int cols=rsmd.getColumnCount();
                        column=new String[cols];
                        for(int i=1;i<=cols;i++){
                            column[i-1]=rsmd.getColumnName(i);
                        }
                        
                        rs.last();
                        int rows=rs.getRow();
                        rs.beforeFirst();
                        
                        data=new String[rows][cols];
                        int count=0;
                        while(rs.next()){
                            for(int i=1;i<=cols;i++){
                                data[count][i-1]=rs.getString(i);
                            }
                            count++;
                        }
                    }
		}catch(Exception e){System.out.println(e);}
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
	}

}
