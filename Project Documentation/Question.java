
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class Question implements ActionListener,ItemListener
{
TextArea tx;
JRadioButton one,two,three,four4;
Panel p,p1,p2;
Frame f;
Button nex;
GridBagLayout gl;
GridBagConstraints gbc;
Font f1,f2;
int qn=1;
String exam,email;
String com;
String one1,two2,three3;
String four,five,six,seven;
ButtonGroup g;
Connection con;
PreparedStatement stmt;
ResultSet rs;
int gud=0;
int wro=0;
int rest;
int x=0;
int count=0;
String empty="not";

Question(String se,String ex)
{
email=se;
exam=ex;
tx=new TextArea(8,70);
g=new ButtonGroup();
one=new JRadioButton("");
two=new JRadioButton("");
three=new JRadioButton("");
four4=new JRadioButton("PASS");
try{
 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con=DriverManager.getConnection("jdbc:odbc:exam","","");
         stmt=con.prepareStatement("select * from question where scode= ?");
         stmt.setString(1,exam);
         rs=stmt.executeQuery();
        while(rs.next())
        {
            String coun=rs.getString("scode");
            count++;
        }   
    }
        catch(Exception e2)
        {
            System.out.println(e2.getMessage());
        }   
            
    
try
    {
         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         con=DriverManager.getConnection("jdbc:odbc:exam","","");
          stmt=con.prepareStatement("select * from question where scode= ? and qno= ?");
         stmt.setString(1,exam);
         stmt.setString(2,""+qn);
        
          rs=stmt.executeQuery();
                rs.next();    
         
              one1=rs.getString("scode");
              two2=rs.getString("qno");
             three3=rs.getString("qdesc");
             four=rs.getString("choice1");
              five=rs.getString("choice2");
              six=rs.getString("choice3");
              seven=rs.getString("answer");
             tx.setText(three3);
             tx.setEditable(false);
             one.setText(four);
             two.setText(five);
             three.setText(six);
             
           
             
           
            
        }
        catch(Exception e2)
        {
            System.out.println(e2.getMessage());
        }
        
g.add(one);
g.add(two);
g.add(three);
g.add(four4);
nex=new Button("Next");
f1=new Font("Times New Roman",Font.BOLD,22);
f2=new Font("Times New Roman",Font.BOLD,16);
gl=new GridBagLayout();
gbc=new GridBagConstraints();
p=new Panel();
p1=new Panel();
p2=new Panel();
f=new Frame();

tx.setFont(f1);
one.setFont(f2);
two.setFont(f2);
three.setFont(f2);
four4.setFont(f2);
gbc.anchor=GridBagConstraints.WEST;
gl.setConstraints(tx,gbc);
p.add(tx);
gbc.anchor=GridBagConstraints.WEST;
Insets is=new Insets(20,20,20,20);
    gbc.insets=is;
gbc.gridx=1;
gbc.gridy=1;
gl.setConstraints(one,gbc);
p1.add(one);
gbc.gridx=1;
gbc.gridy=2;
gl.setConstraints(two,gbc);
p1.add(two);
gbc.gridx=1;
gbc.gridy=3;
gl.setConstraints(three,gbc);
p1.add(three);
gbc.gridx=1;
gbc.gridy=4;
gl.setConstraints(four4,gbc);
p1.add(four4);
gbc.ipadx=30;
gbc.ipady=8;
gl.setConstraints(nex,gbc);
p2.add(nex);
nex.addActionListener(this);
one.addActionListener(this);
two.addActionListener(this);
three.addActionListener(this);
four4.addActionListener(this);
p.setLayout(gl);
p1.setLayout(gl);
p2.setLayout(gl);
f.add(p,"North");
System.out.println(count);
f.add(p1,"West");
f.add(p2,"South");
f.setVisible(true);
f.setSize(1350,725);
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
    Object obj=e.getSource();
     
       
 if(obj==one)
             {
                 com=one.getText();
                }
                if(obj==two)
                {
                com=two.getText();;
            }
            if(obj==three)
            {
                com=three.getText();
            } 
            if(obj==four4)
            {
                com=four4.getText();
            }   
    
    
    if(obj.equals(nex))
    {
        qn++;
        one.setSelected(false);
        two.setSelected(false);
        three.setSelected(false);
        four4.setSelected(false);
        
        //x++;
       if(com.equals(four4))
            {
            }
     else if(com.equals(seven))
            {
            gud=gud+4;
            //System.out.println("hello");
            }
       else
       {
           wro++;
           //System.out.println("oops");
        }    
             if(qn<=count)
     {
        try
    {
         stmt=con.prepareStatement("select * from question where scode= ? and qno= ?");
         stmt.setString(1,exam);
                  stmt.setString(2,""+qn);
                   rs=stmt.executeQuery();
        
                  rs.next();
                   
         
              one1=rs.getString("scode");
              two2=rs.getString("qno");
             three3=rs.getString("qdesc");
              four=rs.getString("choice1");
              five=rs.getString("choice2");
              six=rs.getString("choice3");
              seven=rs.getString("answer");
             tx.setText(three3);
             tx.setEditable(false);
               
             one.setText(four);
             two.setText(five);
             three.setText(six);
             
                            
            
        }
        catch(Exception e2)
        {
            System.out.println(e2.getMessage());
        }
    }    


else if(qn>count)
{
rest=gud-wro;
f.setVisible(false);
JOptionPane p4=new JOptionPane();
p4.showMessageDialog(null,"YOUR SCORE IS "+rest+" MARKS");
try
{
 stmt=con.prepareStatement("insert into result values(?,?,?,?)");
 stmt.setString(1,email);
 stmt.setString(2,exam);
 stmt.setString(3,""+gud);
 stmt.setString(4,empty);
 stmt.executeUpdate();
 p4.showMessageDialog(null," result submitted successfully");
}
catch(Exception e6)
{
System.out.println(e6.getMessage());
p4.showMessageDialog(null,"error in submitting");
}
}
  }  
}
public void itemStateChanged(ItemEvent ie)
{
    Object o2=ie.getSource();
    if(o2.equals(nex))
    {
         one.setSelected(false);
        two.setSelected(false);
        three.setSelected(false);
        four4.setSelected(false);
    }
}    
 

}
            
    
    
    
























