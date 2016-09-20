/* 
 * Bradley White
 * HW #2, CSCI 246
 * September 17, 2015
 */

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String args[]) {

        try {
            // get input from command line argument
            FileReader fileInput = new FileReader(args[0]);
            Scanner inputRead = new Scanner(fileInput);
            
            // create array and store values from input file
            int [] array = new int[3];
            for (int i = 0; i < 3; i++){
                array[i] = inputRead.nextInt();
            }
            
            // check in the number is odd or zero in binary, else it's even and true
            if(array[2] == 1 || (array[0] == 0 && array[1] == 0 && array[2] == 0)){
                System.out.print("0");
            }
            else {
                System.out.print("1");
            }   
        }
        // catch for input not found
        catch (FileNotFoundException exception) {
            System.out.print("input1.txt file not found");
        }
    }
}
