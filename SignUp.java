import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class SignUp implements ActionListener
{
Label fn,ln,dob,stream,year,phoneNo,Email,Pass;
TextField tfn,tln,tdob,tstream,tyear,tphoneNo,tEmail;
JPasswordField pwd;
Button Sub,Goto;
GridBagLayout gl;
GridBagConstraints gbc;
Frame f2;
Panel p1,p2;
Color gre;
JLabel jlb;
Connection conn;
SignUp()
{
fn=new Label("First Name");
ln=new Label("Last Name");
dob=new Label("Date Of Birth");
stream=new Label("Stream");
year=new Label("Year");
phoneNo=new Label("Phone No");
Email=new Label("Email");
Pass=new Label("Password");
tfn=new TextField(15);
tln=new TextField(15);
tdob=new TextField(15);
tstream=new TextField(15);
tyear=new TextField(15);
tphoneNo=new TextField(15);
tEmail=new TextField(15);
pwd=new JPasswordField(12);
Sub=new Button("SUBMIT");
Goto=new Button("Go To Login");
p1=new Panel();
p2=new Panel();
f2=new Frame();
gl=new GridBagLayout();
gbc=new GridBagConstraints();
gre=new Color(228,141,126);
Icon obj=new ImageIcon("uit.jpg");
jlb=new JLabel(obj);
Sub.addActionListener(this);
Goto.addActionListener(this);
}
public void setting()
{
Insets is=new Insets(15,15,15,15);
gbc.insets=is;
gbc.anchor=GridBagConstraints.WEST;
gbc.gridx=1;
gbc.gridy=1;
gl.setConstraints(fn,gbc);
p2.add(fn);
gbc.gridx=1;
gbc.gridy=2;
gl.setConstraints(ln,gbc);
p2.add(ln);
gbc.gridx=1;
gbc.gridy=3;
gl.setConstraints(dob,gbc);
p2.add(dob);
gbc.gridx=1;
gbc.gridy=4;
gl.setConstraints(stream,gbc);
p2.add(stream);
gbc.gridx=1;
gbc.gridy=5;
gl.setConstraints(year,gbc);
p2.add(year);
gbc.gridx=1;
gbc.gridy=6;
gl.setConstraints(phoneNo,gbc);
p2.add(phoneNo);
gbc.gridx=1;
gbc.gridy=7;
gl.setConstraints(Email,gbc);
p2.add(Email);
gbc.gridx=1;
gbc.gridy=8;
gl.setConstraints(Pass,gbc);
p2.add(Pass);
gbc.gridx=2;
gbc.gridy=1;
gl.setConstraints(tfn,gbc);
p2.add(tfn);
gbc.gridx=2;
gbc.gridy=2;
gl.setConstraints(tln,gbc);
p2.add(tln);
gbc.gridx=2;
gbc.gridy=3;
gl.setConstraints(tdob,gbc);
p2.add(tdob);
gbc.gridx=2;
gbc.gridy=4;
gl.setConstraints(tstream,gbc);
p2.add(tstream);
gbc.gridx=2;
gbc.gridy=5;
gl.setConstraints(tyear,gbc);
p2.add(tyear);
gbc.gridx=2;
gbc.gridy=6;
gl.setConstraints(tphoneNo,gbc);
p2.add(tphoneNo);
gbc.gridx=2;
gbc.gridy=7;
gl.setConstraints(tEmail,gbc);
p2.add(tEmail);
gbc.gridx=2;
gbc.gridy=8;
gl.setConstraints(pwd,gbc);
p2.add(pwd);
 gbc.ipadx=14;
 gbc.ipady=8;
gbc.gridx=1;
gbc.gridy=9;
gl.setConstraints(Sub,gbc);
p2.add(Sub);
gbc.gridx=2;
gbc.gridy=9;
gl.setConstraints(Goto,gbc);
p2.add(Goto);
p1.add(jlb);
p2.setLayout(gl);
f2.add(p2,"Center");
f2.add(p1,"North");
//f2.setBackground(gre);
f2.setTitle("WELCOME TO REGISTRATION");
f2.setVisible(true);
f2.setSize(900,700);
f2.addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
  	 System.exit(0);
  	}
});
}
	public void actionPerformed(ActionEvent e)
	{
		Object obj=e.getSource();
		if(obj.equals(Sub))
		{
		    try
		    {
	
		        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                 conn=DriverManager.getConnection("jdbc:odbc:exam","","");
                 PreparedStatement stmt=conn.prepareStatement("insert into registration values(?,?,?,?,?,?,?,?)");
                 String fn1=tfn.getText();
                 stmt.setString(2,fn1);
                 String ln1=tln.getText();
                 stmt.setString(3,ln1);
                 String dob1=tdob.getText();
                 stmt.setString(4,dob1);
                 String stream1=tstream.getText();
                 stmt.setString(5,stream1);
                 String year1=tyear.getText();
                 stmt.setString(8,year1);
                 String ph1=tphoneNo.getText();
                 stmt.setString(6,ph1);
                 String email=tEmail.getText();
                 stmt.setString(1,email);
                 String pwd1=pwd.getText();
                 stmt.setString(7,pwd1);
                 
                 stmt.executeUpdate();
            }
                catch(Exception e3)
                {
                    System.out.println(e3.getMessage());
                }
                JOptionPane pn=new JOptionPane();
                pn.showMessageDialog(null,"SUBMIT SUCCESSFULLY");
                tfn.setText("");
                tln.setText("");
                tdob.setText("");
                tstream.setText("");
                tyear.setText("");
                tphoneNo.setText("");
                tEmail.setText("");
                pwd.setText("");
		}
		else if(obj.equals(Goto))
		{
			SignIn l1=new SignIn();
			l1.getId();
			f2.setVisible(false);
		}


	}
public static void main(String a[])
{
SignUp o2=new SignUp();
o2.setting();
}
}