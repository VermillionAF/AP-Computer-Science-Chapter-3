import java.util.Scanner;
import java.text.DecimalFormat;
public class SCGeometry {
	public static double radius, length, width, height, density, a, b, circumference, volume, sa, mass, weight;
	public static int material;
	public static final double g = 9.8, tons = 907.18474;
	public static boolean menudecision = false, maindecision = false;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while (!maindecision) {
			System.out.println("What material is the shape made of? ");
			System.out.println("Enter the corresponding number:");
			System.out.println("\t1 - Concrete");
			System.out.println("\t2 - Steel");
			System.out.println("\t3 - Wood");
			System.out.println("\t4 - Iron");
			material = scan.nextInt();
			switch (material) {
			case 1:
				density = 2300;
				maindecision = true;
				break;
			case 2:
				density = 7850;
				maindecision = true;
				break;
			case 3:
				density = 600;
				maindecision = true;
				break;
			case 4:
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
		Scanner scan = new Scanner(System.in);
		DecimalFormat fmt = new DecimalFormat("####.00");
		System.out.println("What kind of shape are you calculating for?");
		System.out.println("\t1 - Capsule");
		System.out.println("\t2 - Circular Cone");
		System.out.println("\t3 - Circular Cylinder");
		System.out.println("\t4 - Cube");
		System.out.println("\t5 - Hemisphere");
		System.out.println("\t6 - Sphere");
		System.out.println("\t7 - Spherical Segment");
		System.out.println("\t8 - Tube");
		int shape = scan.nextInt();
		while (!menudecision)  {
			
			switch(shape) {
			case 1:// capsule
				System.out.print("Input the r then a of the capsule: ");
				radius = scan.nextDouble();
				a = scan.nextDouble();
				circumference = (2 * Math.PI * radius);
				volume = (Math.PI * Math.pow(radius, 2)) * ((4/3)*radius + a);
				sa = circumference * (2 * radius + a);
				System.out.println("The circumference is " + fmt.format(circumference));
				System.out.println("The volume is " + fmt.format(volume));
				System.out.println("The surface area is " + fmt.format(sa));
				menudecision = true;
				break;
			case 2:// circular cone
				System.out.println("Input the r then h of the cone: ");
				radius = scan.nextDouble();
				height = scan.nextDouble();
				double volumepart = (Math.PI * Math.pow(radius, 2) * height);
				double oneThird = 0.3333333333333;
				volume = oneThird * volumepart;
				double slant = Math.sqrt(Math.pow(height, 2) + Math.pow(radius, 2));
				sa = (Math.PI * Math.pow(radius, 2)) + (Math.PI * radius * slant);
				System.out.println("The volume is " + fmt.format(volume));
				System.out.println("The slant height is " + fmt.format(slant));
				System.out.println("The surface area is " + fmt.format(sa));
				menudecision = true;
				break;
			case 3: // circular cylinder
				System.out.println("Input the r then h of the cylinder: ");
				radius = scan.nextDouble();
				height = scan.nextDouble();
				volume = Math.PI * Math.pow(radius, 2) * height;
				sa = (2 * Math.PI * radius * height) + (2 * (Math.PI * Math.pow(radius, 2)));
				System.out.println("The volume is " + fmt.format(volume));
				System.out.println("The surface area is " + fmt.format(sa));
				menudecision = true;
				break;
			case 4:// cube
				System.out.println("Input a side length of the cube: ");
				length = scan.nextDouble();
				volume = Math.pow(length, 3);
				sa = 6 * Math.pow(length, 2);
				System.out.println("The volume is " + fmt.format(volume));
				System.out.println("The surface area is " + fmt.format(sa));
				menudecision = true;
				break;
			case 5:// hemisphere
				System.out.print("Input the radius of the hemisphere: ");
				radius = scan.nextDouble();
				volume = (2.0 / 3.0) * Math.PI * Math.pow(radius, 3);
				circumference = 2 * Math.PI * radius;
				sa = 3 * Math.PI * Math.pow(radius, 2);
				System.out.println("The volume is " + fmt.format(volume));
				System.out.println("The circumference is " + fmt.format(circumference));
				System.out.println("The surface area is " + fmt.format(sa));
				menudecision = true;
				break;
			case 6:// sphere
				System.out.print("Insert the radius of the sphere: ");
				radius = scan.nextDouble();
				volume = (4 / 3) * Math.PI * Math.pow(radius, 3);
				sa = 4 * Math.PI * Math.pow(radius, 2);
				System.out.println("The volume is " + fmt.format(volume));
				System.out.println("The surface area is " + fmt.format(sa));
				menudecision = true;
				break;
			case 7:// Spherical Segment
				System.out.println("Insert the height, then a, then b of the segment: ");
				height = scan.nextDouble();
				a = scan.nextDouble();
				b = scan.nextDouble();
				volume = (1 / 6) * Math.PI * height * ((3 * Math.pow(a, 2)) + (3 * Math.pow(b, 2)) + Math.pow(height, 2));
				menudecision = true;
				break;
			case 8:// tube
				System.out.print("Inser r1 and r2 for the tube: ");
				double r1 = scan.nextDouble();
				double r2 = scan.nextDouble();
				double v1 = 2 * Math.PI * Math.pow(r1, 2);
				double v2 = 2 * Math.PI * Math.pow(r2, 2);
				volume = v1 - v2;
				menudecision = true;
				System.out.println("The volume is " + fmt.format(volume));
				break;
			default:
				System.out.println("Did you really think I'd fall for that? Try again.");
				break;
				
				
			}// end of switch-shape
		}// end of while-loop shape
		density();
	}// end of menu
	
	public static void density(){
		DecimalFormat fmt = new DecimalFormat("####.00");
		mass = density * volume;
		System.out.println("The mass of the given figure is " + fmt.format(mass) + " kilograms");
		System.out.println("Or, it's also " + fmt.format(mass / tons) + " tons");
		weight = mass * g;
		System.out.println("The weight of the given figure is " + fmt.format(weight) + " Newtons");
		
		
		
	}// end of density
	
	

}// end of class
