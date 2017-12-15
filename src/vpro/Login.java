/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpro;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Login extends JFrame implements ActionListener
{

JButton b1,b2;
JTextField t1,t2;


ImageIcon c,d,g;
JLabel l1;

public Login()
{
setLayout(new FlowLayout());

d=new ImageIcon("signb.jpg");

g=new ImageIcon("regb.jpg");
b1=new JButton(d);
b2=new JButton(g);

t1=new JTextField(25);
t2=new JTextField(25);


c=new ImageIcon("log.jpg");
l1=new JLabel(c);
JScrollPane jsp=new JScrollPane(l1);
getContentPane().add(jsp);

getContentPane().add(t1);
getContentPane().add(t2);
getContentPane().add(b1);
getContentPane().add(b2);


setSize(900,870);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setTitle("Admission made easy");
setVisible(true);



t1.setLocation(478,359);
t1.setSize(400,30);
t1.setBackground(Color.white);
t2.setLocation(478,416);
t2.setSize(400,30);
t2.setBackground(Color.white);

b1.setLocation(475,474);
b1.setSize(360,35);
b2.setLocation(720,525);
b2.setSize(180,30);

t1.setText("User");
t1.setForeground(Color.black);
t2.setText("password");
t2.setForeground(Color.black);

l1.add(t1);
l1.add(t2);
l1.add(b1);
l1.add(b2);



b1.addActionListener(this);
b2.addActionListener(this);



}

public void  actionPerformed(ActionEvent e)
{

    
    if(e.getSource()==b1)
    {
    String name=t1.getText();
    String password=String.valueOf(t2.getText());
			if(name.equals("root")&&password.equals("root1") || name.equals("user")&&password.equals("user1")){
enterdetail.main(new String[]{});
			}else{
				JOptionPane.showMessageDialog(Login.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				t1.setText("");
				t2.setText("");
			}
			
    
    
    } 
    
    
    
    


if(e.getSource()==b2)
{
  

register a=new register();
}



















repaint();
}



public static void main(String args[])
{
Login a=new Login();


}

}
