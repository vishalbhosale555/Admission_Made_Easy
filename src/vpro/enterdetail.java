/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vpro;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class enterdetail extends JFrame implements ActionListener
{
JButton b1,b2;
JTextField p,q;
ImageIcon c;

JLabel label,l3;
public enterdetail()
{
setLayout(new FlowLayout());
ImageIcon s=new ImageIcon("s.jpg");
ImageIcon t=new ImageIcon("t.jpg");
ImageIcon i=new ImageIcon("civil.jpg");

 b1=new JButton(s);
 b2=new JButton(t);
l3=new JLabel(i);
p=new JTextField(25);
q=new JTextField(25);

 c=new ImageIcon("aa.jpg");
 label=new JLabel(c);
JScrollPane jsp=new JScrollPane(label);
getContentPane().add(jsp);
getContentPane().add(p);
getContentPane().add(q);
getContentPane().add(b1);
getContentPane().add(b2);
getContentPane().add(l3);

setSize(800,800);
setLocationRelativeTo(null);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setTitle("Admission made easy");
setVisible(true);


p.setLocation(390,400);
p.setSize(150,40);
p.setBackground(Color.white);
q.setLocation(390,470);
q.setSize(150,40);
q.setBackground(Color.white);

b1.setLocation(410,570);
b1.setSize(100,40);
b2.setLocation(290,570);
b2.setSize(100,40);



l3.setLocation(550,400);
l3.setSize(80,120);



label.add(p);
label.add(q);
label.add(b2);
label.add(b1);
label.add(l3);

b2.addActionListener(this);
b1.addActionListener(this);

}

public void  actionPerformed(ActionEvent t)
{
  
Double aa=Double.parseDouble(p.getText());

Double bb=Double.parseDouble(q.getText());

Double cc;
    

if(t.getSource()==b2)
{
cc=((aa+bb)/300)*100;
JOptionPane.showMessageDialog(enterdetail.this, "Your Aggregate Percentage is"+cc,"Aggregate percentile", JOptionPane.INFORMATION_MESSAGE);

if(cc>95 && cc<100)
{
a95.main(new String[]{});
}
if(cc>90 && cc<95)
{
a90.main(new String[]{});
}

if(cc>80 && cc<90)
{
a80.main(new String[]{});
}
if(cc>70 && cc<80)
{
a70.main(new String[]{});
}
if(cc>60 && cc<70)
{
a60.main(new String[]{});

}

}

if(t.getSource()==b1)
{
p.setText("");

q.setText("");
}




repaint();
}



public static void main(String args[])
{
enterdetail p=new enterdetail();
}

}



