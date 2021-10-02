package hacktober;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem_Statement_7_Solution 
{
	public static void main(String args[])
	{
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		System.out.println("Enter elements for first list, 0 to end");
		for(int i  = 0; i < 50; i++)
		{	
			int n  =sc.nextInt();
			if(n==0)
				break;
			a1.add(n);
		}
		System.out.println("Enter elements for second list, 0 to end");
		for(int i  = 0; i < 50; i++)
		{
			int n  =sc.nextInt();
			if(n==0)
				break;
			a2.add(n);
		}
		System.out.println(merge(a1, a2));
		for(int i = 0; i < a2.size(); i++)
		{
			sum += a2.get(i);
		}
		System.out.println("sum: "+sum);
	}
		static ArrayList<Integer> merge(ArrayList<Integer> a1, ArrayList<Integer> a2)
		{	
			
			a2.addAll(a1);
			Collections.sort(a2);
			return a2;
		}
	
}
