/*
Author : Divya Ganesh
01 October 2021
Hacktoberfest Mozilla Campus Club 
Cummins College of Engineering for Women Pune
*/

import java.util.*;
import java.io.*;
public class Problem_Statement_22
{
	public static void main (String args[]) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//length of array is entered by user
		int l = Integer.parseInt(reader.readLine());
		
		//the following line is to input an integer array when 
		//the input string is split along the spaces ("\\s" = regex for space)
		//and each element is parsed as integer type
		int[] ar = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
		
		//this stores the number of triplets that add up to 0
		int count = 0;
		
		//sort the array in ascending order 
		Arrays.sort(ar);

		for (int i=0 ; i<l-1; i++)
		{
			//find "first" and "last" so that they satisfy "sum" == 0
			//both of these are indices not values stored in th
			int first = i+1;
			int last = l-1;

			int sum;

			//finds pairs across the array that satisfy condition sum = 0
			//breaks out of loop when sum = 0
			while (first<last)
			{
				sum = ar[first] + ar[last] + ar[i];
				if (sum==0)
				{
					count++;
					//System.out.println(ar[first] +" "+ ar[last] +" "+ ar[i]);
					////^uncomment above to print the sub arrays that sum to 0 
					break;
				}

				if (sum>0) last -= 1;
				else first += 1;
			}
		}
		//print the total number of triplets that add up to zero
		System.out.println(count);
	}
}
