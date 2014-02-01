import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class Selection implements ActionListener
{
Label selection,h1;
JComboBox year;
Button conti;
Font f1;
Panel p1,p2,p3;
JLabel pic;
Frame f;
GridBagLayout gl;
GridBagConstraints gbc;
String exam;
String email;
	public Selection(String se)
	{
	    email=se;
		selection=new Label("Select Year");
		h1=new Label("Click Continue To Start The Exam");
		String s[]={"1","2","3","4"};
		year=new JComboBox(s);
		conti=new Button("Continue");
		f1=new Font("Matura MT Script Capitals",Font.BOLD,20);
		gl=new GridBagLayout();
		gbc=new GridBagConstraints();
		Icon image=new ImageIcon("Selection.gif");
		pic=new JLabel(image);
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();
		f=new Frame();
		h1.setFont(f1);
		conti.addActionListener(this);
		selection.setFont(f1);
		p1.add(selection);
		p1.add(year);
		p2.add(h1);
		 gbc.ipadx=14;
       gbc.ipady=8;
    gl.setConstraints(conti,gbc);
    
		p2.add(conti);
		p2.setLayout(gl);
		p3.add(pic);
		f.add(p1,"North");
		f.add(p2,"South");
		f.add(p3,"Center");
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
	    Object ob=e.getSource();
	    if(ob.equals(conti))
	    {
	        exam=""+year.getSelectedItem();
	        Question obj1=new Question(email,exam);
	       
	        f.setVisible(false);
	       }
	   
}  
}
/*public static void main(String a[])
{
	Selection obj=new Selection();
}
}*/
			

		
		
		
		