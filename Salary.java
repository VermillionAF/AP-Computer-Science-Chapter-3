// *************************************************************** 
//   Salary.java 
//   Computes the raise and new salary for an employee 
// *************************************************************** 
import java.util.Scanner;
public class Salary {    
	public static void main (String[] args)    {       
		double currentSalary;  // current annual salary      
		double rating;         // performance rating      
		double raise;          // dollar amount of the raise    
		Scanner scan = new Scanner(System.in);       // Get the current salary and performance rating      
		System.out.print ("Enter the current salary: ");       
		currentSalary = scan.nextDouble();      
		System.out.print ("Enter the performance rating: ");       
		rating = scan.nextDouble();       
		if (rating == 1) {
			raise = currentSalary * .06; 
		}
		else if (rating == 2) {
			raise = currentSalary * .04;
		}
		else {
			raise = currentSalary * .015;
		}
		// Print the results       
		System.out.println ("Amount of your raise: $" + raise);      
		System.out.println ("Your new salary: $" + (currentSalary + raise));   
		}
	}
/* 1. a. if ((x > y) && (y > z)) {
 * 	  b. if ((x < 0) && (y < 0)) {
 * 	  c. if ((x > 0) && (y > 0)) {
 * 	  d. if ((x == y) && (y != z)) {
 * 
 * 2. if (gpa >= 3.5) {
 * 		System.out.println("Congratulations! You made the Dean's List!");
 * 		}
 * 	  else if (gpa < 3.5) {
 * 		System.out.println("Sorry, you didn't make the Dean's List");
 * 		}
 */
