
import java.util.Scanner;
public class Factorials {
	public static boolean isnotnegative = false;
	public static int factor;
	public static void main(String[] args) {
			menu();
	}// end of main
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a non-negative integer: ");
			factor = scan.nextInt();
			notnegative();
	}
	
	public static void notnegative() {
			
			while (!isnotnegative) {
				if (factor < 0) {
					System.out.println("Please insert a non-negative number");
					menu();
				}//end of if factor is negative
				else {
					isnotnegative = true;
				}//end of else
			}//end of while-loop isnegative
			factorial();
	}// end of factor
	
	public static void factorial() {
		int total = 1;
		int count = factor;
		while (count != 0) {
			total = total * count;
			count--;
		}// end of while-factor
		System.out.println(factor + "! = " + total);
	}// end of factorial
}// end of class
