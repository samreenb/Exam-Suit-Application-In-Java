import java.util.*;
import java.io.*;
/**
 * Write a description of class Letter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Number
{
        int [] array;
        int total;
       
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class Letter
     */
    public Number()
    {
       array = new int[5];
       total = 0;
   
        input();
        
        
    }
    
    public void input()
    {
       int randomInt;
        int num = 0 ;
        Scanner scan = new Scanner(System.in);
        Random randomGenerator = new Random();
        System.out.println("Enter Five Numbers");
        for(int i = 0 ; i < 5 ; i++)
        {
         //Generetae Random numbber between 0-99
            num = scan.nextInt();
            randomInt = randomGenerator.nextInt(100);
            num = randomInt * num;
            array[i] = num;
            total = total + array[i];
        }
        System.out.println("After Multiplication Array is ");
        for(int i = 0 ; i < 5 ; i++)
        {
            System.out.println(array[i]);
        }
        System.out.println("Total is " + total);
        System.out.println("Length is " + array.length);
    }
   
    
    public static void main(String arg[])
    {
     Number obj = new Number();
        
    }
    
}
