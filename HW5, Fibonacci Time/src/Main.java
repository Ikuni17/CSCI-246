/* 
 * Bradley White
 * HW #5, CSCI 246
 * October 20 2015
 */

import javax.swing.JOptionPane;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
        int input = Integer.parseInt(JOptionPane.showInputDialog("Enter the Fibonacci number to be calculated: "));
        long output = 0;
        
        long startTime = System.nanoTime();
        //long startTime = System.currentTimeMillis();
        //output = recursive(input);
        //output = inductive(input);
        output = formula(input);
        //long endTime = System.currentTimeMillis();
        long endTime = System.nanoTime();
        
        JOptionPane.showMessageDialog(null,
                                "The time taken to compute this Fibonacci number was " 
                                + ((float)(endTime - startTime)/1000000) + " milliseconds and the result is: " + output);
        
    }
    
    public static long recursive(int input){
        if (input == 0){
            return 0;
        }
        else if (input == 1){
            return 1;
        }
        else{
            return (recursive(input - 1) + recursive(input - 2));
        }       
    }
    
    public static long inductive(int input){
        long[] a = new long[input + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= input; i++){
            a[i] = a[i - 1] + a[i - 2];
        }
        
        return a[input];
    }
    
    public static long formula(int input){
        return (long) ((1/sqrt(5)) * pow(((1 + sqrt(5))/2), input) - (1/sqrt(5)) * pow(((1 - sqrt(5))/2), input));
    }

    
}
