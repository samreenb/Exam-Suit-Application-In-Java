import java.io.*;
import java.util.*;
import java.lang.*;
public class Phrase
{
   
   String phr;
   int count;
   char letter;
   
   public Phrase()
   {
       count = 0;
       occurences();
    }
    
    public void occurences()
    {
        Scanner scan = new Scanner(System.in);
         System.out.println("Enter new Phrase or quit to Exit");
        phr = scan.nextLine();
        
        
        while(phr.equals("quit"))
        {
            count = 0;
             System.out.println("Enter Letter");
            letter = scan.next().charAt(0);
            for(int i = 0 ; i < phr.length() ; i++)
            {
                if(phr.charAt(i) == letter)
                count++;
            }
            display();
            System.out.println("Enter new Phrase or quit to Exit");
           
            phr = scan.next();
        }
    }
    
    public void display()
    {
        System.out.println("Number of Occurences of Letter "+letter+" is "+count+" in the word "+phr);
    }
    
    public static void main(String arg[])
    {
        Phrase obj = new Phrase();
    }
}
        
      
       
       
    
        
            
            
        