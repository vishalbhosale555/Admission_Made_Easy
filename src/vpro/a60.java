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

public class a60 extends JFrame {

	private JPanel contentPane;
	private final JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
                    try {
                        a60 frame = new a60();
                        frame.setVisible(true);
                    } catch (Exception e) {
                    }
                });
	}

	/**
	 * Create the frame.
	 */
public a60() {
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
                        PreparedStatement ps=con.prepareStatement("select * from a60",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
		JOptionPane.showMessageDialog(a60.this,sp,"Predicted Colleges ForGiven Percentile", JOptionPane.INFORMATION_MESSAGE);

		contentPane.add(sp, BorderLayout.CENTER);
	}

}






/*
ArrayList<String[]>  tableData=new ArrayList<>(); 

ResultSet rs = statement.executeQuery("SELECT * FROM Customer" ); 

while (rs.next())
{ 

tableData.add(new String[]{rs.getString("customerFirstName"), rs.getString("customerLastName"}); 

}

String[][] tableRows = tableData.toArray(new String[tableData.size()][]);
String[] columnNames = {"First Name", "Last Name"};

JFrame f = new JFrame();
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE ); 

JTable table = new JTable( tableRows,columnNames );   // thats 
f.add( new JScrollPane( table ) );  // 
add the JTable to the window

f.pack();
f.setVisible( true );

*/