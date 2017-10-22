package gcd;

//Accept two numbers and display the GCD of the numbers

import java.util.Scanner;
public class GCD {
 public static void main(String[] args) {
     // take numbers from user
     Scanner s = new Scanner(System.in);
     System.out.println("This program will find the greatest common denominator of two numbers");
     System.out.println("Input your first number:");
     int first = s.nextInt();
     System.out.println("Input your second number:");
     int second = s.nextInt();
     
     int smallerNumber;
     if(first<second)
     {
    	 smallerNumber=first;
     } else {
    	 smallerNumber=second;
     }
     
     
     for (int i=smallerNumber;  i > 0 ; i --) {
       if ( first % i == 0 &&  second % i == 0) {
            System.out.println("The greatest common denominator of " + first + " and " + second + " is " + i);
            break;
       }
     }
 }
}
