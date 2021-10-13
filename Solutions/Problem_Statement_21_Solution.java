//Problem Statement:Given a string, find out the occurrence of each character in the string. For example, String = "apple", then in
//output it should print : a = 1, p = 2, l = 1 , e=1.
package Hacktoberfest_Moz_Cummins_Solutions;

import java.util.Scanner;//importing scanner class from util package

public class Problem_Statement_21_Solution
{
   //Start of class
	public static void main(String[] args)
	{
		//Start of main fuction
		String str;//Initialisation of variable str
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string:");
		str=sc.nextLine();//taking a string as an input from the user
		
		char ch[]=new char[str.length()];//Created an array named ch with size as length of the entered string
		
		int counter[]=new int[256];//Created an array named counter of size 256
		str=str.toLowerCase();//converting the entered string into lower case
		
		//Initialize counter array index
		for(int i=0;i<str.length();i++)
		{
		    counter[str.charAt(i)] = counter[str.charAt(i)]+1;
		    
		}
		
		for(int j=0;j<str.length();j++)
		{
		    ch[j]=str.charAt(j);
		  //storing the element of string str at (j)th position in the array ch at index position j
		    int flag=0;//intialized variable flag with 0
		    
		    for(int k=0;k<=j;k++)
		    {
		        if(str.charAt(k)==ch[j])
		        {
		        	//if the element at k(th) position of string str is same as element at (j)th
		        	//position of array ch then
		        	//increment the value of flag by 1
		            flag++;      
		        }
		    }
		    if(flag==1)
		    {
		    	//if value of flag is found to be 1 then print the 
		    	//occurence of element at (j)th position of string str
		    	
		         System.out.print(str.charAt(j)+"="+counter[str.charAt(j)]+" ");
		        
		     }
	    }
  }
}
//*****************************************************************************************
//Output:
//Enter a string:
//Apple
//a=1 p=2 l=1 e=1

//*****************************************************************************************
//Output:
//Enter a string:
//Mississipi
//m=1 i=4 s=4 p=1

//******************************************************************************************