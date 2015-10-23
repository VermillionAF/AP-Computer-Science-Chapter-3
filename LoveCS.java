// **************************************************************** 
//   LoveCS.java 
// 
//   Use a while loop to print many messages declaring your 
//   passion for computer science 
// **************************************************************** 
	import java.util.Scanner;

public class LoveCS {   
	public static void main(String[] args)    
	{  
		Scanner scan = new Scanner(System.in);
		int LIMIT = 10; 
		int count = 1; 
		int sum = 0;
		System.out.print("How many times do you want to print?: ");
			LIMIT = scan.nextInt();
		while (count <= LIMIT){      
			System.out.println(count + " I love Computer Science!!");      
			count++;
			sum = (count - 1) + sum;
			}   
		System.out.print("The sum from 1 to " + LIMIT + " is " + sum);
		}
	}
