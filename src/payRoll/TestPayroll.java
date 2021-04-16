
package payRoll;

/**
 * Programmer: Abhishek Jassal
 * Program: PROG24178 OOP Java-2
 * Date: February 2021
 * @version 3.1
 * @author Abhishek
 */

import java.util.*;

public class TestPayroll { //class block
    
/**
 * The Program always starts from main method
 * @param args 
 */
public static void main(String[] args)
  { // main method block
    try{ //this is try block
    
    //this is for scanner class
    Scanner input = new Scanner(System.in);
    
    //declaring an array for id number
    int[] idn = new int[5];
    //declaring an array for pay Rate 
    double[] pr = new double[5];
    //declaring and array for number of hours
    int[] nh = new int[5];
    //declaring and array for total payment
    double[] tp = new double[5];
    
    //this loop takes the value from user to intialize the array
    for(int i=0;i<idn.length;i++)
    {
        System.out.print("Enter the Employees identification Number: ");
        idn[i] = input.nextInt();
        System.out.print("Enter the number of hours Employees worked: ");
        nh[i] = input.nextInt();
        System.out.print("Enter the Employees pay Rate of each employee: ");
        pr[i] = input.nextDouble();
        System.out.println();
    }
    
    //declaring an object of Payroll class
    Payroll pay = new Payroll(idn,pr,nh);
    //initializing an array object with EmployeeId from payroll class
    int[] idn1 = pay.getEmployeeId();
    //initializing an array object with pay rate payroll class
    double[] pr1 = pay.getPayRate();
    //initializing an array object with pay rate payroll class
    int[] nh1 = pay.getNHrs();
    
    //initializing an array of gross pay
    for(int i=0;i<pr1.length;i++)
    {
        tp[i]=pr1[i]*nh1[i];
    }
    
    //printing the respective value entered bu user and calling the methods from Payroll class
    System.out.println("EmployeeId"+"           "+"Hours"+"         "+"Pay Rate"+"          "+"Gross Pay");
    for(int i=0;i<idn1.length;i++)
    {
    System.out.println(idn1[i]+"                     "+nh[i]+"            "+pr1[i]+"                "+tp[i]);
    }
    
    System.out.println();
    
    //calling the methods from Payroll class
    System.out.println("Gross pay of employee: "+pay.searchEmployee(idn));
    System.out.println("Highest pay rate of employee: "+ pay.getHighest());
    }//end of try block
    catch(Exception e)
    {
     System.out.println(e.getMessage());
    }

  }// end of method block

}//end of class block
