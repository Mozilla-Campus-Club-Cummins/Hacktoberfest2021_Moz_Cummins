package Problem_Statement_82_Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Given an array of strings queries and a string pattern, return a boolean array answer where 
answer[i] is true if queries[i] matches pattern, and false otherwise.

A query word queries[i] matches pattern if you can insert lower case English letters pattern so 
that it equals the query. You may insert each character at any position and you may not insert any 
characters.
 */
public class Problem_Statement_82_Solution {
	//list to store queries
	static List<String> queries;
	//list to store answers
	static ArrayList<Boolean> answer;
	
	public static void main(String[] args) {
		//input
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String[] data = input.substring(1,input.length()-1).split(",");
		
		queries = new ArrayList<String>();
		for(String s : data)
		{
			queries.add((String) s.subSequence(1,s.length()-1));
		}
		
		//input pattern
		String pattern = sc.next();
		
		answer = new ArrayList<Boolean>();
		
		//function to check if queries match pattern
		checkPattern(pattern);
		
		//function to print answer
		printOutput();
		
		
	}
	
	private static void printOutput() {
		System.out.println(answer);	
	}
	
	private static void checkPattern(String pattern) {
		int i=0,j=0;
		//i keeps track of pattern and j keeps track of queries
		for(String s: queries)
		{
			i=0;
			j=0;
			int flag = 0 ;
			while(j!=s.length())
			{
				if(i<pattern.length() && pattern.charAt(i) == s.charAt(j))
				{
					i++;
					j++;
				}
				else
				{
					if(s.codePointAt(j)>=65 && s.codePointAt(j)<=90)
					{
						answer.add(false);
						flag = 1;
						break;
					}
					else
					{
						j++;
					}
				}
			}
			if (flag!=1 && i==pattern.length())
			{
				answer.add(true);
			}
			else if (flag!=1 && i<pattern.length())
			{
				answer.add(false);
			}
		}
	}

}

/*test cases:

["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
FB
[true, false, true, true, false]

["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
FoBa
[true, false, true, false, false]

["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
FoBaT
[false, true, false, false, false]

 */












