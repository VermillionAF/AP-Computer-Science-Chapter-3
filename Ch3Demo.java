/************************************************
 *  File:		Ch3Demo
 *  Author:		J.Foy
 *  Created:	7/14/2015
 *  Demos several Chapter 3 concepts
 *  Revision History
 *  	Rev 0:	Initial Release
 *  
 */

//  Explorations:
//  Number 1: run the program, as is.  Answer yes for GPA
//  Number 2: run the program, as is.  Answer no for GPA
//  Number 3: rerun with a different number of courses
//  Number 4: what happens if you change the declaration 
//     double sumgrades = 0.0 to double sumgrades
//  Number 5: comment out the line done = answer.equalsIgnoreCase, rerun
//     It is just before the closing bracket for while loop
//


import java.util.*;

public class Ch3Demo 
{
	public static void main(String[] args) 
	{
	boolean done = false;
	boolean intgpa = false;
	
	// next two lines are arrays, will learn in Chapter 6
	int[] grades = new int[8];
	String[] classes = new String[8];
	
	int nrcourses = 1;
	int x;
	
	String answer, course;
	double gpa = 2.0;
	double sumgrades = 0.0;
	Scanner invalue = new Scanner(System.in);
	
	x = 0;
	// while statement: pages 136 - 146
	while (!done)
	{
	 System.out.print("Enter name of course: ");
	 course = invalue.next(); 
	 classes[x] = course;
	 System.out.print("\nEnter grade ");
	 grades[x] = invalue.nextInt();
	 nrcourses++;
	 sumgrades = sumgrades + grades[x];
	 x++;
	// System.out.println();
	 answer = "";
	 System.out.print("Are you done (Yes or No): ");
	 answer = invalue.next();
	 
	 // comment out the following line for Exploration number 5
	 done = answer.equalsIgnoreCase("yes");
	}  // end of while loop
	
	System.out.println("\nCourse\t\t Grade");
	
	for (x=0; x< nrcourses-1; x++)
	{
	 System.out.println(classes[x] + "\t" + grades[x]); 	
	} // end of for loop
	System.out.print("Do you want to calculate GPA? (Enter 0 for no, 1 for yes) ");
	x = invalue.nextInt();
	
	// if statement: pages 121 - 130
	if (x > 0)
	{
	  gpa = sumgrades/(nrcourses - 1);
	}  // end of if x > 0
	
	System.out.println("GPA is " + gpa);
	
	} // end of main
} // end of class
