package mozilla;

import java.util.ArrayList;

public class Problem_28 {

	public static void main(String[] args) {
		int n =10;
		int m=20;
       //Calling the function- excludedNumbers which returns an array of excluded numbers [a,b] for any input n
		System.out.println(excludedNumbers(n));
		System.out.println(excludedNumbers(m));

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

[[6, 7], [7, 6]]
[]


*/