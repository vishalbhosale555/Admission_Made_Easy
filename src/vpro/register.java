

package vpro;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;





public class register extends JFrame implements ActionListener
{

JButton b1;
JTextField t1,t2,t3,t4,t5;


ImageIcon c,d;
JLabel l1;

public register()
{
setLayout(new FlowLayout());

d=new ImageIcon("sb.jpg");

b1=new JButton(d);


t1=new JTextField(25);
t2=new JTextField(25);
t3=new JTextField(25);
t4=new JTextField(25);
t5=new JTextField(25);

c=new ImageIcon("register.jpg");
l1=new JLabel(c);
JScrollPane jsp=new JScrollPane(l1);
getContentPane().add(jsp);

getContentPane().add(t1);
getContentPane().add(t2);
getContentPane().add(t3);
getContentPane().add(t4);
getContentPane().add(t5);
getContentPane().add(b1);



setSize(900,870);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setTitle("Admission made easy");
setVisible(true);


t1.setLocation(590,280);
t1.setSize(300,40);
t1.setBackground(Color.white);
t2.setLocation(590,355);
t2.setSize(300,40);
t2.setBackground(Color.white);
t3.setLocation(590,430);
t3.setSize(300,40);
t3.setBackground(Color.white);
t4.setLocation(590,500);
t4.setSize(300,40);
t4.setBackground(Color.white);
t5.setLocation(590,570);
t5.setSize(300,40);
t5.setBackground(Color.white);


b1.setLocation(475,628);
b1.setSize(375,35);

l1.add(t1);
l1.add(t2);
l1.add(t3);
l1.add(t4);
l1.add(t5);
l1.add(b1);



b1.addActionListener(this);
}

public void  actionPerformed(ActionEvent e)
{




if(e.getSource()==b1)
{
   JOptionPane.showMessageDialog(null,"account is created");

    
Login l=new Login();
}


repaint();
}



public static void main(String args[])
{
register r=new register();


}

}
