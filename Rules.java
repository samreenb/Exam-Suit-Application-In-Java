import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Rules implements ActionListener
{
JOptionPane p1;
Frame f;
Panel p,p2,p3,p4;
JLabel pic,pic1,pic2;
Button conti,rules;
Label head;
GridBagLayout gl;
GridBagConstraints gbc;
String email;

//Color gre;
Rules(String se)
{
email=se;
conti=new Button("Continue");
rules=new Button("ClicK Here For Rules");
p1=new JOptionPane();
Icon image=new ImageIcon("books.jpg");
Icon image1=new ImageIcon("girl.jpg");
Icon image2=new ImageIcon("uit.jpg");
gl=new GridBagLayout();
gbc=new GridBagConstraints();
conti.addActionListener(this);
rules.addActionListener(this);
//gre=new Color(117,102,185);
p=new Panel();
p2=new Panel();
p3=new Panel();
p4=new Panel();
f=new Frame();
pic=new JLabel(image);
pic1=new JLabel(image1);
pic2=new JLabel(image2);
gbc.anchor=GridBagConstraints.SOUTHWEST;
gl.setConstraints(pic1,gbc);
gbc.anchor=GridBagConstraints.SOUTHEAST;
gl.setConstraints(pic,gbc);
 Insets is=new Insets(30,30,30,30);
    gbc.insets=is;
     gbc.ipadx=14;
       gbc.ipady=8;
    gl.setConstraints(rules,gbc);
     gl.setConstraints(conti,gbc);
     p2.setLayout(gl);
     p4.add(pic2);
p2.add(pic);
p3.setLayout(gl);
p3.add(pic1);
p.add(conti);
p.add(rules);
p.setLayout(gl);
f.add(p4,"North");
f.add(p3,"East");
f.add(p2,"West");

f.add(p,"Center");
f.setTitle("RULES BOOK");
//f.setBackground(gre);
f.setVisible(true);
f.setSize(900,600);
f.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
  	 System.exit(0);
  	}
});
}
public void actionPerformed(ActionEvent e)
{
    Object ob=e.getSource();
        if(ob.equals(rules))
        {
            p1.showMessageDialog(null,"THIS IS A SIMPLE SOFTWARE FOR CONDUCTING EXAMINATION.\n"+"SPECIALLY DESIGN FOR COLLEGS N INSTITUTIONS\n"
            +"YOU HAVE TO SELECT YOUR YEAR AND THE PARTICULAR EXAM WILL BE DISPLAYED.\n"+"THERE ARE FOUR OPTIONS OUT OF WHICH ONLY ONE IS CORRECT.\n"
            +"MARKING SCHEME WILL DEPEND UPON THE EXAM SETTER IT WILL BE DISCLOSED TO U BEFORE THE EXAM.\n"
            +"ALL THE BEST \n");

        }
        else if(ob.equals(conti))
        {
            Cheating o=new Cheating(email);
            f.setVisible(false);
        }   
    }   
}
/*public static void main(String a[])
{
Rules obj=new Rules();
}
}*/