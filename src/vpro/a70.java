/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class a70 extends JFrame {

	private JPanel contentPane;
	private final JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        a70 frame = new a70();
                        frame.setVisible(true);
                    } catch (Exception e) {
                    }
                });
	}

	/**
	 * Create the frame.
	 */
	public a70() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//String data[][]=null;
		//String column[]=null;

                Vector data1 = new Vector();
                
                
                
                    try (Connection con = DB.getConnection()) {
                        PreparedStatement ps=con.prepareStatement("select * from a70",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                        ResultSet rs=ps.executeQuery();
                        
                        ResultSetMetaData rsmd=rs.getMetaData();
                        int columns=rsmd.getColumnCount();
                       
                        while (rs.next()) {
                                Vector row = new Vector(columns);
                                     for (int i = 1; i <= columns; i++) {
                                         row.addElement(rs.getObject(i));
                                                                        }
                                     data1.addElement(row);
                                    }
} 
                    catch (SQLException e) {
    e.printStackTrace();
}
		Vector columnNames = new Vector();
                columnNames.addElement("College_Name");
                columnNames.addElement("establishment");
                columnNames.addElement("MHTCET_Cuttoff");
                columnNames.addElement("College_Code");
                columnNames.addElement("Branch");
                table=  new JTable(data1,columnNames);
		JScrollPane sp=new JScrollPane(table);
		JOptionPane.showMessageDialog(a70.this,sp,"Predicted Colleges ForGiven Percentile", JOptionPane.INFORMATION_MESSAGE);

		contentPane.add(sp, BorderLayout.CENTER);
	}

}












/*


String myDriver = "com.mysql.jdbc.Driver";
String myUrl = "jdbc:mysql://localhost:3306/mysql";
Class.forName("com.mysql.jdbc.Driver");
System.out.println("Connecting to database");




conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
System.out.println("Connected to databse");
Statement st;
Vector data1 = new Vector();

try {
    st = connection.createStatement();
    ResultSet res = st.executeQuery("SELECT col_name FROM table_name");
    ResultSetMetaData metaData = res.getMetaData();
    int columns = metaData.getColumnCount();
    while (res.next()) {
       Vector row = new Vector(columns);
       for (int i = 1; i <= columns; i++) {
        row.addElement(res.getObject(i));
       }
       data1.addElement(row);
    }
} 



catch (SQLException e) {
    e.printStackTrace();
}
Vector columnNames = new Vector();
columnNames.addElement("col_1");
columnNames.addElement("col_name_n");
 table=  new JTable(data1,columnNames);






*/
























/*
	public a70() {
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
                        PreparedStatement ps=con.prepareStatement("select * from a70",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
*/