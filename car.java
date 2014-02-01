import java.util.Scanner;
import java.io.*;
/**
 * Write a description of class Sum1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class car
{
    // instance variables - replace the example below with your own
    private int DistanceDriven, fuelEconomy,fuelEfficiency, fuelAmount;

    /**
     * Constructor for objects of class Sum1
     */
    public car(int tfuelEfficiency, int tfuelAmount)
    {
        fuelEfficiency = tfuelEfficiency;
        fuelAmount = tfuelAmount;
        DistanceDriven = 0 ;
       fuelEconomy = 0 ;
        // initialise instance variables

    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int distanceDriven()
    {
        Scanner scan = new Scanner(System.in);
        DistanceDriven = scan.nextInt();
        fuelEconomy = scan.nextInt();
        DistanceDriven = fuelEfficiency * fuelEconomy;
        return DistanceDriven;
    }
    
    public void display()
    {
        System.out.println(distanceDriven());
        
        // put your code here
        
    }
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int fuelAmount = 0 ;
        int fuelEfficiency = 0 ;
        fuelAmount = scan.nextInt();
        fuelEfficiency = scan.nextInt();
        car distanceCalculationObj = new car(fuelEfficiency,fuelAmount);
        distanceCalculationObj.display();
    }

    
}
