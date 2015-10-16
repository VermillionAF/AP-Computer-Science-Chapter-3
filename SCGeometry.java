/********************************
 * Name: Patrick Wooden
 * Program: SCGeometry.java
 * 
 * Description: Calculates surface area and volume of several shapes. Also prompts for a material,
 * which is used to calculate the weight of the figure in both kilograms and tons.
 *
 *****************************/

import java.util.Scanner;
import java.text.DecimalFormat;
public class SCGeometry {
	public static double radius, length, width, height, density, a, b, circumference, volume, sa, mass, weight;
	public static int material;
	public static final double g = 9.8, tons = 907.18474;
	public static boolean menudecision = false, maindecision = false, endresponse = false;
	public static Scanner scan = new Scanner(System.in);
	public static DecimalFormat fmt = new DecimalFormat("####.00");
	public static DecimalFormat exp = new DecimalFormat("####.E0");
	
	public static void main(String[] args) {
		
		while (!maindecision) {
			System.out.println("What material is the shape made of? ");
			System.out.println("Enter the corresponding number:");
			System.out.println("\t1 - Concrete");
			System.out.println("\t2 - Steel");
			System.out.println("\t3 - Wood");
			System.out.println("\t4 - Iron");
			material = scan.nextInt();
			switch (material) {
			case 1:// concrete
				density = 2300;
				maindecision = true;
				break;
			case 2:// steel
				density = 7850;
				maindecision = true;
				break;
			case 3:// wood
				density = 600;
				maindecision = true;
				break;
			case 4:// iron
				density = 7874;
				maindecision = true;
				break;
			default:
				System.out.println("Please insert a value between 1 and 4.");
				
				break;
			}// end of switch
			
		
			}// end of while loop - main decision
			menu();	
		
			
	} // end of main
	
	public static void menu() {
		endresponse = false;
		menudecision = false;
		System.out.println("What kind of shape are you calculating for?");
		System.out.println("\t1 - Capsule");
		System.out.println("\t2 - Circular Cone");
		System.out.println("\t3 - Circular Cylinder");
		System.out.println("\t4 - Cube");
		System.out.println("\t5 - Hemisphere");
		System.out.println("\t6 - Sphere");
		System.out.println("\t7 - Spherical Segment");
		System.out.println("\t8 - Tube");
		System.out.println("-----------------------------");
		System.out.println("\t0 - Quit program");
		int shape = scan.nextInt();
		while (!menudecision)  {
			
			switch(shape) {
			case 0:// quit
				menudecision = true;
				break;
			case 1:// capsule
				getRadius();
				System.out.print("Input the a of the capsule: ");
				a = scan.nextDouble();
				circumference = (2 * Math.PI * radius);
				volume = (Math.PI * Math.pow(radius, 2)) * ((4/3)*radius + a);
				sa = circumference * (2 * radius + a);
				menudecision = true;
				answers();
				break;
			case 2:// circular cone
				getRadius();
				System.out.println("Input the height of the cone: ");
				height = scan.nextDouble();
				double volumepart = (Math.PI * Math.pow(radius, 2) * height);
				double oneThird = 0.3333333333333;
				double slant = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
				volume = oneThird * volumepart;
				sa = (Math.PI * Math.pow(radius, 2)) + (Math.PI * radius * slant);
				answers();
				menudecision = true;
				break;
			case 3: // circular cylinder
				getRadius();
				System.out.println("Input the height of the cylinder: ");
				height = scan.nextDouble();
				volume = Math.PI * Math.pow(radius, 2) * height;
				sa = (2 * Math.PI * radius * height) + (2 * (Math.PI * Math.pow(radius, 2)));
				answers();
				menudecision = true;
				break;
			case 4:// cube
				System.out.println("Input a side length of the cube: ");
				length = scan.nextDouble();
				volume = Math.pow(length, 3);
				sa = 6 * Math.pow(length, 2);
				answers();
				menudecision = true;
				break;
			case 5:// hemisphere
				getRadius();
				volume = (2.0 / 3.0) * Math.PI * Math.pow(radius, 3);
				sa = 3 * Math.PI * Math.pow(radius, 2);
				answers();
				menudecision = true;
				break;
			case 6:// sphere
				getRadius();
				volume = (4 / 3) * Math.PI * Math.pow(radius, 3);
				sa = 4 * Math.PI * Math.pow(radius, 2);
				answers();
				menudecision = true;
				break;
			case 7:// Spherical Segment
				System.out.println("Insert the height, then a, then b of the segment: ");
				height = scan.nextDouble();
				a = scan.nextDouble();
				b = scan.nextDouble();
				volume = (1 / 6) * Math.PI * height * ((3 * Math.pow(a, 2)) + (3 * Math.pow(b, 2)) + Math.pow(height, 2));
				double R = Math.sqrt((Math.pow(a-b, 2) + Math.pow(height, 2)) * (Math.pow(a-b, 2) + Math.pow(height, 2))) / ( 4 * Math.pow(height, 2));
				sa = 2 * Math.PI * R * height;
				answers();
				menudecision = true;
				break;
			case 8:// tube
				System.out.print("Insert an outer and inner radius of the tube: ");
				double r1 = scan.nextDouble();
				double r2 = scan.nextDouble();
				System.out.print("Insert the height: ");
				height = scan.nextDouble();
				double v1 = 2 * Math.PI * Math.pow(r1, 2);
				double v2 = 2 * Math.PI * Math.pow(r2, 2);
				volume = v1 - v2;
				double sa1 = 2 * Math.PI * r1 * height;
				double sa2 = 2 * Math.PI * r2 * height;
				sa = sa1 + sa2;
				menudecision = true;
				answers();
				break;
			default:
				System.out.println("Did you really think I'd fall for that? Try again.");
				break;
				
				
			}// end of switch-shape
		}// end of while-loop shape
	}// end of menu
	
	public static void density(){
		mass = density * volume;
		double mass_pounds = mass * 2.20462;
		System.out.println("The mass of the given figure is " + exp.format(mass) + " kilograms"
				 + " or " + exp.format(mass_pounds) + " pounds" );
		System.out.println("Or, it's also " + fmt.format(mass / tons) + " tons");
		weight = mass * g;
		System.out.println("The weight of the given figure is " + exp.format(weight) + " Newtons");
		repeat();
	}// end of density
	
	public static double getRadius() {
		Scanner scan = new Scanner(System.in);
		System.out.print("What is the radius?: ");
		radius = scan.nextDouble();
		return radius;
	}// end of getRadius
	
	public static void answers() {
		System.out.println("The volume is " + fmt.format(volume));
		System.out.println("The surface area is " + fmt.format(sa));
		density();
	}// end of answers
	
	public static void repeat() {
		System.out.print("Insert a 0 to quit, or a 1 to go back to menu: ");
		String response = scan.next();
		if (response.equals("1")) {
			endresponse = true;
			menu();
		}// end of if-response-1
		else if (response.equals("0") || response.equalsIgnoreCase("o")) {
			System.out.println("Ending program...");
			endresponse = true;
		}//end of if-response-0o
		else if (!response.equals("1") && !response.equals("0") && !response.equalsIgnoreCase("o")) {
			System.out.println("Please insert a 1 or 0.");
			repeat();
		}//end of if-else response
	}//end of repeat
	
	

}// end of class
