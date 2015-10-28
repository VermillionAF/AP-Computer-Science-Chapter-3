// ****************************************************************
// PowersOf2.java
//
//   Print out as many powers of 2 as the user requests
//          
// ****************************************************************
import java.util.Scanner;
import java.text.DecimalFormat;
public class PowersOf2{   
	public static void main(String[] args)    {   
		int numPowersOf2;        //How many powers of 2 to compute        
		int nextPowerOf2 = 1;    //Current power of  2        
		int exponent;            //Exponent for current power of 2 -- this                           
		//also serves as a counter for the loop       
		Scanner scan = new Scanner(System.in);  
		DecimalFormat fmt = new DecimalFormat("####");
		System.out.println("How many powers of 2 would you like printed?");       
		numPowersOf2 = scan.nextInt() + 1; //print a message saying how many powers of 2 will be printed
		exponent = 1;
		//initialize exponent -- the first thing printed is 2 to the what?   
		while (numPowersOf2 > exponent)        {      
			System.out.println("2^" + exponent + " = " + fmt.format((Math.pow(2, exponent))));//print out current power of 2 
			exponent++;//find next power of 2 -- how do you get this from the last one?            
   }    
		
}
}