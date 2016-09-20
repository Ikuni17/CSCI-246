/* 
 * Bradley White
 * HW #6, CSCI 246
 * November 14 2015
 */

//This is the starter file (code template) for the HW programing problem
//Contact GTA if you have any questions
// If using NetBeans: To add the argument that is read into args[0], go to Run > Set Project Configuration. 
// In the Arguments box, add the full path to your input file. It doesn't matter what you 
// name this file or where it is, as long as it's the format the program requires,
// in this case, a .txt file. 
// That is the joy of passing in arguments: anyone can pass anything they want!
// Also, please make sure that the source file you submit (HWx.java) does not have a line with "package" keyword at the top.
import java.util.*;
import java.io.*;

public class HW6 {

    //Please DO NOT change the main method. You are required to implment ONLY the other method(s) below.

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {//if no argument provided
            System.out.println("Please run as: java HWx <input_filename>");
            System.exit(-1);//exit abruptly
        }
        String fname = args[0]; //take in first argument as the name of the input file
        Scanner sc = new Scanner(new File(fname)); //scanner for reading the file
        String input = sc.nextLine(); //read the first line of the file

        int A = Integer.parseInt(input.split(" ")[0]); //first number
        int B = Integer.parseInt(input.split(" ")[1]); //second number		
        ArrayList output = egcd(A, B);//get the results
        System.out.println("" + output.get(0) + " " + output.get(1) + " " + output.get(2)); //print output

    }

	//You are required to complete the functionality of the folwoing method uisng the Extended Euclidian algorithm (Example 8.4.6 in text). You can have any number of other helper methods.
	//Given integers A and B with A > B > 0, this algorithm computes gcd(A, B) and finds integers s and t such that s A + t B = gcd(A, B).]
    //Arguments: A, B [integers with A > B > 0]
    //Returns: gcd[a positive integer], s, t [integers] OR  -1,-1,-1 if inputs does not satisfy A > B > 0
    public static ArrayList egcd(int A, int B) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        int gcd;
        int s = 1;
        int t = 0;
        int r, q, a = A, b = B, u = 0, v = 1, newU, newV;
        
        // conditions for Extended Euclidean Algorithm
        if (A > B && B > 0) {
            // Extended Euclidean Algorithm to produce a linear combination
            while (b != 0) {
                r = (a % b);
                q = a / b;
                a = b;
                b = r;
                newU = s - (u * q);
                newV = t - (v * q);
                s = u;
                t = v;
                u = newU;
                v = newV;
            }

            gcd = a;
        } else {
            gcd = -1;
            s = -1;
            t = -1;
        }

        results.add(gcd);
        results.add(s);
        results.add(t);
        return results;
    }
}
