import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Cheating implements ActionListener
{
    Label h1,h2;
    Button Continue;
    JLabel pic;
    Panel p,p1,p2;
    Frame f;
    GridBagLayout gl;
    GridBagConstraints gbc;
    //BorderLayout bl;
    Font f1;
    String email;
    Cheating(String se)
    {
        email=se;
        h1=new Label("THESE KINDA ACTIVITIES ARE NOT ALLOWED");
        h2=new Label("CLICK CONTINUE TO PROCEED");
        Continue=new Button("Continue");
        Icon image=new ImageIcon("cheating.jpg");
        f1=new Font("Matura MT Script Capitals",Font.BOLD,28);
        Continue.addActionListener(this);
        pic=new JLabel(image);
        gl=new GridBagLayout();
        gbc=new GridBagConstraints();
        //bl=new BorderLayout();
        p=new Panel();
        p1=new Panel();
        p2=new Panel();
        f=new Frame();
        h1.setFont(f1);
        h2.setFont(f1);
        //gbc.anchor=GridBagConstraints.NORTH;
        //gl.setConstraints(h1,gbc);
        p.add(h1);
        p2.add(h2);
        //gbc.anchor=GridBagConstraints.SOUTH;
        gbc.ipadx=8;
       gbc.ipady=8;
        gl.setConstraints(Continue,gbc);
        p2.add(Continue);
        
        p2.setLayout(gl);
       // p.setLayout(gl);
        p1.add(pic);
        f.setTitle("FOLLOW THESE RULES");
        f.add(p,"North");
        f.add(p2,"South");
        f.add(p1,"Center");
        f.setVisible(true);
        f.setSize(1000,600);
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
        ob=Continue;
        Selection ob1=new Selection(email);
        f.setVisible(false);
    }
}
        
            
    /*public static void main(String a[])
    {
        Cheating obj=new Cheating();
    }
}*/    
        
        
      
        
        

   

   
