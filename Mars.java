
/************************************************
 *  File:		Mars
 *  Author:		P.Wooden
 *  Created:	8/25/2015
 *  Demos several Chapter 3 concepts
 *  Revision History
 *  	Rev 0:	Initial Release
 *  
 *  EXPLORATION 1:
 *  In "main" there is a menu, then a selection based on that menu.  The selection uses a "while" loop.
 *  Comment out the "case 0" code statements, then run the code, selecting 0.  What happens (or does not
 *  happen)?
 *  EXPLORATION 2:
 *  Notice the decimal formatter in method "orbiter".  What does that do for an output listing?
 *  EXPLORATION 3:
 *  In method "friction", after the terrain type selection code, there is a compound "if" statement
 *  What do the double vertical bars || mean in that statement?
 *  EXPLORATION 4:
 *  Also in method "friction", there are "if" statements using terraintype.  Notice the double equal
 *  sign.  Change one of these to the equal sign we are used to using, what happens?
 *  EXPLORATION 5:
 *  In method "transit" there is another if statement, if (distance > 4e11).  What is "4e11"?
 *  Remove the parenthesis around the distance comparison, what happens?
 *  EXPLORATION 6:  NEXT CHAPTER ITEM
 *  Examine case-4 in "main".  Notice how the call to "lifesupport" is made.  Now examine the 
 *  "lifesupport" method definition.  What is the connection?
 *  EXPLORATION 7:  NEXT CHAPTER ITEM
 *  Examine case-3 in "main".  Notice what is different about this call to method "transit", compared 
 *  to earlier ones.  Now examine method "transit".  Notice the last line in the method, and the 
 *  declaration line as well.  What is different?
 *  CREATE 1:  REVIEW
 *  Method "friction" is not complete.  It only does a calculation if the Rover is on flat ground, i.e.
 *  the angle == 0.  There is an "else" block that is completed if the Rover is on the edge of a crater, or
 *  on a hill.  Complete that code.
 *  CREATE 2: REVIEW
 *  Method "orbiter" is not complete.  Finish the code following instructions (comments) in the method
 *  CREATE 3: REVIEW
 *  Add a decimal formatter to method "life support".  Choose your definition (number of decimal places)
 */

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.*;

public class Mars 
{
	// *******************************************************************************
	// Method orbiter prompts for an orbit parameter, and calculates two others
	// ******************************************************************************* 
	public static void orbiter()
	{
	final double MARSMASS = 6.4174e23;
	final double MARSRADIUS = 3.389e6;
	final double G = 6.67e-11;
	double height, totalheight;
	double orbiterV;
	double periodsec, periodminutes;
	Scanner mars = new Scanner(System.in);
	DecimalFormat fmt = new DecimalFormat("###.###E0");
	
	// Add two lines of code; one is a prompt for an orbital height, second
	// receives the value into variable height via a mars.nextDouble statement
	System.out.println("What is the height of the orbital?");
	height = mars.nextDouble();
	
	// total height is height above Mars, plus radius of Mars
	// write a statement that calculates total height, and assigns it to variable
	totalheight = height + MARSRADIUS;// total height
	
	// Following equation will determine necessary orbiter velocity.
	// v = square root of (G multilied by Mass of mars divided by total height)
	// Write a line of code that calculates velocity, and displays it.  Use the
	// Decimal Formatter defined at top of method to display velocity
	orbiterV = Math.sqrt(G * MARSMASS / totalheight);
	System.out.println("The orbiter velocity is " + fmt.format(orbiterV));
	
	// orbit period (seconds) is defined by equation period = 2 * PI * total height/velocity
	// write a line of code which will calculate period (seconds), assign it to variable
	periodsec = 2 * Math.PI * (totalheight / orbiterV);// period.  
	periodminutes = periodsec / 60;
	
	// write a line of code that displays orbit period in minutes, not seconds.  Use the
	// decimal formatter at the top of the method to display period
		System.out.println("The orbit period, in minutes, is " + fmt.format(periodminutes) );
	} // end of method "orbiter"
	
	// *******************************************************************************
	// Method friction prompts for angle and terrain type.  It uses these to calculate
	// amount of friction.
	// If the angle is not zero, then the rover is on a hill
	// NOTE: Friction coefficients: 0.3 tire to loose sand
	//                              0.06 tire to solid sand
	//                              0.6 tire to gravel
	//                              0.75 tire to rock
	// ******************************************************************************* 
    public static void friction()
    {
      final int ROVERMASS = 900;
      final double MARSG = 3.71;
      int angle, terraintype;
      double famount = 0;
      double fcoefficient = 0.06;
      Scanner ttype = new Scanner(System.in);
      DecimalFormat fmt = new DecimalFormat("####.##");
      
      System.out.println("\nRover Friction Calculator");
      System.out.println("You will enter slope angle and select terrain type.");
      System.out.println("Rover computer will determine if it can scale the slope.");
      System.out.print("Enter slope angle (degrees): ");
      angle = ttype.nextInt();
      System.out.println("\nSelect Terrain Type");
      System.out.println("Solid sand:       1");
      System.out.println("Loose sand:       2");
      System.out.println("Gravel:           3");
      System.out.println("Rock              4");
      System.out.print("Enter terrain type: ");
      terraintype = ttype.nextInt();
      if ((terraintype < 1) || (terraintype > 4))
      {
    	System.out.println("INVALID TERRAIN TYPE:  DEFAULTING TO SOLID SAND");
    	terraintype = 1;
      };  
      if (terraintype == 1)
  		fcoefficient = 0.06;
  	  if (terraintype == 2)
  		fcoefficient = 0.3;
  	  if (terraintype == 3)
  		fcoefficient = 0.6;
  	  if (terraintype == 4)
  		fcoefficient = 0.75;
      if (angle == 0)  // flat terrain
      {
    	famount = MARSG * ROVERMASS * fcoefficient;
    	System.out.println("Rover friction is " + fmt.format(famount) + " Newtons");
      }
      else      // sloped terrain
      {
 
     // Math cosine method is listed on page 88 of our textbook.  It is used with an
     // angle expressed in radians.
     // Write a line of code that multiplies ROVERMASS * MARSG * fcoefficient * cosine
     // of angle provided by the user.  Set this equal to famount, and print the results
     // as shown in the "angle == 0" code block above
    	  famount = ROVERMASS * MARSG * fcoefficient * Math.cos(Math.toRadians(angle));
    	  System.out.println("Rover friction is " + fmt.format(famount) + " Newtons");
 	  
      } // end of else block
    System.out.print("...Strike 0 to continue: ");
    while (ttype.nextInt() != 0);
    }  // end of method friction
   
	// *******************************************************************************
	// Method transit prompts for booster burn time, remaining distance, and initial
    // velocity.  It uses these to calculate remaining transit time
    // Newest ion drive provides 0.236 N thrust
    // assuming Hermes mass of 500,000 kg
	// ******************************************************************************* 
    public static double transit()
    {
      final double THRUST = 0.236;
      final double HERMESMASS = 500000;
      double boosttime, distance, vinit, ttime, acceleration, vfinal;
      double boostdistance, rdistance, constantflight;
    
    Scanner transinput = new Scanner(System.in);
    DecimalFormat fmt = new DecimalFormat("####.E0");
    
    System.out.println("\nFlight Adjustment Calculator");
    System.out.println("You will enter remaining distance in meters, in exponential");
    System.out.println("form, i.e. 5.55e10");
    System.out.print("Enter remaining distance to Mars in exponential form ");
    distance = transinput.nextDouble();
    if (distance > 4e11)
     distance = 4e11;
    
    System.out.print("\nEnter booster burn time (seconds): ");
     boosttime = transinput.nextDouble();
    
    System.out.print("\nEnter present velocity (m/s): ");
    vinit = transinput.nextDouble();
    
    // acceleration is thrust divided by mass of hermes.  
    acceleration = THRUST/HERMESMASS;
      
    // final velocity is initial velocity plus acceleration multiplied by burn time.
   
    vfinal = vinit + acceleration * boosttime;
     
    // distance during boosted flight is calculated using equation
    // distance = initial velocity x boost time + 0.5 x acceleration x time x time
    
    boostdistance = vinit * boosttime + 0.5 * acceleration * Math.pow(boosttime, 2);
    
    rdistance = distance - boostdistance;
    ttime = 0;
    if (rdistance < 0) System.out.println("Entering Mars Orbit");
    else 
    {
      constantflight = rdistance / vfinal;
      ttime = boosttime + constantflight;
      ttime = ttime / 3600.0;
      System.out.println("Expect Mars arrival in " + fmt.format(ttime) + " hours");
    }
    
    return ttime;
    }   // end of method transit
	// *******************************************************************************
	// Method lifesupport prompts for remaining transit time, calculates the amount of
    // food, water, oxygen that is needed
	// ******************************************************************************* 
    public static void lifesupport(double flighthours)
    {
      double days;
      DecimalFormat fmt = new DecimalFormat("####.##");
      
      days = flighthours/24;
      System.out.println("\nLife support systems calculator");
      System.out.println("Assumes flight crew of six");
      System.out.print("For remaining flight, crew life support requirements are ");
      System.out.println(fmt.format((days * 6 * 67.32)) + " pounds of food, water, oxygen." );
    }  // end of method lifesupport
    
    // *******************************************************************************
	// Method menu is called repeatedly.  It returns an integer which indicates
	// to a switch-case statement which option the user chose
	// ******************************************************************************* 
	
	public static int menu()
	{
	  int selectvalue;
	  Scanner menuval = new Scanner(System.in);
	  
	  System.out.println("\nMars Menu");
	  System.out.println("***********************");
	  System.out.println("  Function            Option");
	  System.out.println("Orbiter Calculations    1");
	  System.out.println("Crater friction         2");
	  System.out.println("Transit time            3");
	  System.out.println("Life Support Rqmts      4");
	  System.out.println("Quit                    0");
	  System.out.print("Enter Option:            ");
	  selectvalue = menuval.nextInt();

	  return selectvalue;
	}  // end of method "menu"

	public static void main(String[] args) 
	{
	boolean done = false;
	int select;
	double flighttime = 1000;
// while iterative statement is AP testable, see page 136 of textbook
// switch-case is not, however several labs use it, and it is extremely useful
// not described in textbook, however we will learn about it
	while (!done)
	{
	   select = menu();	
	   switch (select)
	   {
	  case 0:
		   done = true;
		   break; 
	   case 1:
		   orbiter();
		   break;
	   case 2:
		   friction();
		   break;
	   case 3:
		   flighttime = transit();
		   break;
	   case 4:
		   lifesupport(flighttime);
		   break;
		default:
			System.out.println("\n INPUT ERROR, option must be between 0 and 4");
			break;
	   } // end of switch
	} // end of while

	} // end of main

}  // end of class Mars
