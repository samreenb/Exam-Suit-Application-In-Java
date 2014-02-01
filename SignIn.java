import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class SignIn implements ActionListener
{
Label id,password,newUser;
TextField tid;
JPasswordField pwd;
Frame f1;
Panel p1;
GridBagLayout gd;
GridBagConstraints gbc;
Button SignIn,SignUp,Cancel;
Color gre;
JLabel pic;
Connection con;
String s,pw,ed,pa;

    SignIn()
    {
    newUser=new Label("New User Please Click Here");
    id=new Label("Login Id");
    password=new Label("Password");
    tid=new TextField(25);
    pwd=new JPasswordField(18);
    Icon obji=new ImageIcon("login.jpg");
    pic=new JLabel(obji); 
    
    f1=new Frame();
    p1=new Panel();
    SignIn=new Button("Sign In");
    SignUp=new Button("Sign Up");
    Cancel=new Button("Cancel");
    gd=new GridBagLayout();
    gbc=new GridBagConstraints();
   gre=new Color(228,141,126);
    SignIn.addActionListener(this);
    SignUp.addActionListener(this);
    Cancel.addActionListener(this);
}
public void getId()
{
    
gbc.anchor=GridBagConstraints.WEST;
    gbc.gridx=1;
    gbc.gridy=1;
    gd.setConstraints(id,gbc);
    p1.add(id);
    Insets is=new Insets(10,10,10,10);
    gbc.insets=is;
    gbc.anchor=GridBagConstraints.WEST;
    gbc.gridx=2;
    gbc.gridy=1;
    gd.setConstraints(tid,gbc);
    p1.add(tid);
    gbc.gridx=1;
    gbc.gridy=2;
    gd.setConstraints(password,gbc);
    p1.add(password);
    gbc.gridx=2;
    gbc.gridy=2;
    gd.setConstraints(pwd,gbc);
    p1.add(pwd);
    gbc.gridx=2;
    gbc.gridy=3;
    gd.setConstraints(SignIn,gbc);
    p1.add(SignIn);
     gbc.gridx=3;
    gbc.gridy=3;
    gd.setConstraints(Cancel,gbc);
    p1.add(Cancel);
    gbc.gridx=2;
    gbc.gridy=4;  
    gd.setConstraints(newUser,gbc);
    p1.add(newUser);
      gbc.gridx=3;
    gbc.gridy=4;
    gd.setConstraints(SignUp,gbc);
    p1.add(SignUp);   
    p1.setLayout(gd);
    f1.setBackground(gre);
    f1.add(p1);
    f1.setTitle("EXAM SUIT");
    f1.setVisible(true);
    f1.setSize(450,350);
    f1.addWindowListener(new WindowAdapter()
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
        if(obj.equals(SignIn))
       {
           try
           {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        Connection con=DriverManager.getConnection("jdbc:odbc:exam","","");
            Statement stmt=con.createStatement();
            s=tid.getText();
            pw=pwd.getText();
            ResultSet rs=stmt.executeQuery("select * from registration");
            int flag=0;
            while(rs.next())
            {
                 ed=rs.getString("email");
                 pa=rs.getString("password");
            
         
               
                if(s.equals(ed)&&pw.equals(pa))
                {
                    flag=1;
               
                    Rules ob=new Rules(s);
                    f1.setVisible(false);
                }
            }   
                if(flag==0)
                {
                    JOptionPane p2=new JOptionPane();
                    p2.showMessageDialog(null,"INVALID USER NAME OR PASSWORD");
                    tid.setText("");
                    pwd.setText("");
                }
                
            }  
            catch(Exception e2)
            {
                System.out.println(e2.getMessage());
            }   
                
        }      
       else if(obj.equals(SignUp))
       {
           SignUp o=new SignUp();
           o.setting();
           f1.setVisible(false);
        }
        else if(obj.equals(Cancel))
        {
            System.exit(0);
        }    
            
                
    }     
public static void main(String ar[])
{
    SignIn o1=new SignIn();
    o1.getId();
}
}
    
