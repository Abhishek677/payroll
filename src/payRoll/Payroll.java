
package java_Assignment3;

/**
 * Programmer: Abhishek Jassal
 * Program: PROG24178 OOP Java-2
 * Date: February 2021
 * @version 3.1
 * @author Abhishek
 */

import java.util.*;

public class Payroll {
    
    //This array variable carries the id of different workers
    private int[] employeeId;
    //This array variable carries the payment of different workers
    private double[] payRate;
    //This is constant for validation purpose 
    final double SIZE=6.0;
    //This array variable which carries the number of hours of workers
    private int[] nHrs;
    //Here is max variable for finding the hishest payrate purpose
    public double max=0;
    
    /**
     * This is argument constructor 
     * @param employeeId
     * @param payRate
     * @param nHrs 
     */
    public Payroll(int[] employeeId, double[] payRate, int[] nHrs) {
        setEmployeeId(employeeId);
        setPayRate(payRate);
        setNHrs(nHrs);
        
   
    }
    
    /**
     * This is getter method for worker id
     * @return int[]
     */
    public int[] getEmployeeId() {
        return employeeId;
    }
    
    /**
     * This is setter method for worker id
     * @param employeeId 
     */
    public void setEmployeeId(int[] employeeId)
    {
        this.employeeId = employeeId;
    }
    
    /**
     * This is getter method for pay rate
     * @return double[]
     */
    public double[] getPayRate() {
        return payRate;
    }
    
    /**
     * This setter method for Pay rate and for validation
     * @param payRate 
     */
    public void setPayRate(double[] payRate) 
    {
       for(int i=0;i<payRate.length;i++)
       {
         if(payRate[i]<SIZE) //1<6 false
         {
          throw new IllegalArgumentException("The pay rate of employee should be above 6.0");
          
         }      
         else 
         {
          this.payRate = payRate;  
         }
        
       }
    }
    
    /**
     * This getter method dor number of hours
     * @return int[]
     */
    public int[] getNHrs() {
       
        return nHrs;
    }
    
    /**
     * This setter method for Number of Hours and for its validation
     * @param nHrs 
     */
    public void setNHrs(int[] nHrs) 
    {
        for(int i=0;i<nHrs.length;i++)
       {
        if(nHrs[i] < 0)
        {
          throw new IllegalArgumentException("The Hour rate for employee should be above positive");
        }
        else 
        {
         this.nHrs = nHrs;
        }
       }
    }
    
    
    /**
     * This search method which search the Employee id respectively as user entered
     * @param employeeId
     * @return double
     */
    public double searchEmployee(int[] employeeId)
    {
       Scanner input =new Scanner(System.in);
        
        double grossPay = 1;
        
        Arrays.sort(employeeId);
        System.out.print("Enter the employee identification number to get the gross pay rate: ");
        
        int find= input.nextInt();
        int index=Arrays.binarySearch(employeeId, find);
        
        if(index>=0)
        grossPay = grossPay * (payRate[index] * nHrs[index]); 
        
        else
        throw new IllegalArgumentException("EmployeeId not present in array Index out of bounds for length 5 ");
        
       return grossPay;
       
    }
    
    /**
     * This method is for getting the highest payRate of employee
     * @return double
     */
    public double getHighest()
    {
        for(int i=0;i<employeeId.length;i++)
          {double temp=payRate[i];
              if( temp> max) 
              {
                  max=temp; 
              }
              
          }
          return max;
    }
        
}   
