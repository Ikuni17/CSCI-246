/* 
 * Bradley White
 * HW #4, CSCI 246
 * September 28, 2015
 */

//This is the starter file (code template) for the HW programing problem
//Contact GTA if you have any questions
// If using NetBeans: To add the argument that is read into args[0], go to Run > Set Project Configuration. 
// In the Arguments box, add the full path to your input file. It doesn't matter what you 
// name this file or where it is, as long as it's the format the program requires,
// in this case, a .txt file. 
// That is the joy of passing in arguments: anyone can pass anything they want!

import java.util.*;
import java.io.*;

public class Main {
	//Please DO NOT change the main method. You are required to implment ONLY the other method(s) below.
	public static void main(String[] args) throws FileNotFoundException{ 
		if (args.length==0){//if no argument provided
			System.out.println("Please run as: java HW4 <input_filename>"); 
			System.exit(-1);//exit abruptly
		}      		
		String fname = args[0]; //take in first argument as the name of the input file
		Scanner sc = new Scanner(new File(fname)); //scanner for reading the file
		String input = sc.nextLine(); //read the first line of the file

		int A = Integer.parseInt(input.split(" ")[0]); //first number
                int B = Integer.parseInt(input.split(" ")[1]); //second number		
	        int output = gcd(A,B);//get GCD of A and B
		System.out.println(""+output); //print output
		
	}

	//You are required to complete the functionality of this method uisng the Euclidian algorithm (section 4.8 in text). You can have any number of other helper methods. 
	//Arguments: A, B [integers with A > B >= 0]
	//Returns: gcd [a positive integer]
	public static int gcd(int A, int B){
		int r;
                
                while(B != 0){
                    r = (A%B);
                    A = B;
                    B = r;
                }
                
		return A;
	}
}
