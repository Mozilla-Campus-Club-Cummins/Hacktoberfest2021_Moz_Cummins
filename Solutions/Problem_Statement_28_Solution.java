/*Problem_Statement_28 */
/*
 A friend of mine takes the sequence of all numbers from 1 to n (where n > 0).
Within that sequence, she chooses two numbers, a and b.
She says that the product of a and b should be equal to the sum of all numbers in the sequence, excluding a and b.
Given a number n, could you tell me the numbers she excluded from the sequence?
The function takes the parameter: n (n is always strictly greater than 0) and returns an array or a string
(depending on the language) of the form:

[(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or or [{a, b}, ...]
with all (a, b) which are the possible removed numbers in the sequence 1 to n.
[(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or ... will be sorted in increasing order of the ""a"".
It happens that there are several possible (a, b). The function returns an empty array 
(or an empty string) if no possible numbers are found which will prove that my friend has not told the truth!

 * */


package mozilla;

import java.util.*;

public class Problem_Statement_28_Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=-1;
		while(n<=0) {
		//Taking n from user 
		System.out.println("Please enter a integer n greater than 0 : ");
		n =sc.nextInt();
		}
       //Calling the function- excludedNumbers which returns an array of excluded numbers [a,b] for any input n
		System.out.println(excludedNumbers(n));
		

	}
	
	public static ArrayList<ArrayList<Integer>> excludedNumbers(int n) {
		//Calculationg the sum for given integer n :
		int sum = (n*(n+1))/2;
		
		//Declaring 2-dimensional array-list : 
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(); 
		
		//Initializing k to add a new list , when we find such numbers - a & b
		int k=0;
		for(int a =0;a<n;a++) {
			for(int b=0;b<n;b++) {
				//Checking for the condition and if true adding [a,b] to Arraylist arr:
				if(a*b==sum-a-b&&a!=b) {
					//creating space for row 1: 
					arr.add(new ArrayList<Integer>());
					//Adding a to Row k , Column 0
					arr.get(k).add(0,a);
					//Adding a to Row k , Column 1
					arr.get(k).add(1,b);
					k++;
				}
			}
		}
		//Will return an 2d array if a and b are found or empty array if a & b are not found
		return arr;
	}

}


/*/************************      OUTPUT             **************************//*

Please enter a integer n greater than 0 : 
-3
Please enter a integer n greater than 0 : 
10
[[6, 7], [7, 6]]



*/