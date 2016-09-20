/* 
 * Bradley White
 * Bonus Problem: RSA Cryptography, CSCI 246
 * December 8, 2015
 */

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class RSA {

    public static void main(String[] args) {

        try {
            // if no argument provided, exit abruptly
            if (args.length == 0) {
                System.out.println("Please run as: input.txt");
                System.exit(-1);
            }

            // take in first argument as the name of the input file
            String fname = args[0];

            // scanner for reading input file
            Scanner sc = new Scanner(new File(fname));

            // parse the input file
            String line1 = sc.nextLine();
            String line2 = sc.nextLine();

            // arrays to hold plaintext or ciphertext
            char[] charArray = new char[line1.length()];
            int[] integerArray = new int[line1.length()];

            // decompose the second line into the flag and variables
            String[] split2 = line2.split(" ");
            String flag = split2[0];
            int p = Integer.parseInt(split2[1]);
            int q = Integer.parseInt(split2[2]);
            int e = Integer.parseInt(split2[3]);
            
            // call helper method to compute positive inverse of modulo
            int d = egcd(((p - 1) * (q - 1)), e);
            int n = (p * q);

            // decryption operations depending on flag
            if (flag.equals("DEC")) {
                String[] split1 = line1.split(" ");

                // populate the ciphertext array for input string
                for (int i = 0; i < 2; i++) {
                    integerArray[i] = Integer.parseInt(split1[i]);
                }

                // decrypt the ciphertext array with helper method
                for (int i = 0; i < integerArray.length; i++) {
                    charArray[i] = decrypt(integerArray[i], d, n);
                }

                // print the results to the console
                for (int i = 0; i < 2; i++) {
                    System.out.print(charArray[i]);
                }
            } 
            
            // encryption operations
            else {
                // convert input string to characters in plaintext array
                charArray = line1.toCharArray();
                
                // encrypt the plaintext with helper method
                for (int i = 0; i < charArray.length; i++) {
                    integerArray[i] = encrypt(charArray[i], e, n);
                }
                
                // print the results to the console
                for (int i = 0; i < 2; i++) {
                    System.out.print(integerArray[i]);
                    if (i < 1) {
                        System.out.print(" ");
                    }
                }
            }
        } 
        
        // catch for input not found
        catch (FileNotFoundException exception) {
            System.out.print("input.txt file not found");
        }
    }

    // encryption helper method
    public static int encrypt(char plaintext, int e, int modulus) {
        int cipher;

        // algorithm to compute ciphertext
        cipher = (int) pow((plaintext - 'A' + 1), e) % modulus;

        return cipher;
    }

    // decryption helper method
    public static char decrypt(int base, int d, int modulus) {
        int plaintext;
        int x;

        // algorithm to compute plaintext, call helper method for large powers
        x = modularExp(base, d, modulus);
        plaintext = (x % modulus);

        // convert plaintext from integer to character
        return (char) (plaintext + 'A' - 1);
    }

    // helper method to compute positive inverse of modulo
    public static int egcd(int A, int B) {
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

            if (t < 0) {
                t = A + t;
            }
        }
        return t;
    }

    // algorithm to use properties of modulus and keep integers small
    public static int modularExp(int base, int exponent, int modulus) {
        int c = 1;

        if (modulus == 1) {
            return 0;
        } else {
            for (int i = 1; i < (exponent + 1); i++) {
                c = (c * base) % modulus;
            }
            return c;
        }
    }
}