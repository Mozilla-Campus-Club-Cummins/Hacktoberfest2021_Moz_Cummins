package Hacktoberfest_Moz_Cummins.Solutions;
import java.util.Scanner;

// Problem Statement:- Write a general purpose function to display any given number as a product of its 
    //                     prime factors (Eg. 24 = 2 + 2+ 2+ 3)

    // Please find the general purpose function to print out the prime factors of the passed INTEGER Number.
    // Please use the main program and pass the number you want to test it with.

public class Problem_Statement_20_Solution{
    public static void primeFactors(Integer number)
    {
        System.out.print(number + " = ");
        for(int i = 2; i< number; i++) {
            while(number%i == 0) {
               number = number/i;
               System.out.print(i);
               if(i<=number)
               System.out.print(" * ");
               
            }
         }
        if (number > 2){
            System.out.print(number);
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number to print its prime facotors ");
        int number = sc.nextInt();
        sc.close();
        primeFactors(number);
    }
}

/* 
=========== OUTPUT =============

Please enter the number to print its prime facotors 
24
24 = 2 * 2 * 2 * 3

*/


