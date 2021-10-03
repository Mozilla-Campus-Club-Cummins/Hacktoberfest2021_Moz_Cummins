/*
 * Problem_Statement_30 #16
 Create a function that takes a integer number n and returns the formula for (a+b)n(a+b)^n(a+b)
n
as a string.

formula(0) --> "1"
formula(1) --> "a+b"
formula(2) --> "a^2+2ab+b^2"
formula(-2) --> "1/(a^2+2ab+b^2)"
formula(3) --> "a^3+3a^2b+3ab^2+b^3"
formula(5) --> "a^5+5a^4b+10a^3b^2+10a^2b^3+5ab^4+b^5"
The formula for n=5 is like so :

a5+5a4b+10a3b2+10a2b3+5ab4+b5a^5 + 5a^4b+10a^3b^2+10a^2b^3+5ab^4+b^5a

So the answer would look like so : a^5+5a^4b+10a^3b^2+10a^2b^3+5ab^4+b^5

Important notes :
Your string may not have spaces so you can't do this : a^5 + 5a^4 b + 10a^3 b^2...
You will show raised to power of by ^ and not using **.
You need not put * between each multiplication
There is no need to show a^1 or b^1 since that is basically a and b
a^0 and/or b^0 also don't need be shown instead be a normal person and use 1 since that is what they equate to.
You will need to handle both positive and negative numbers + 0

You will not be tested for float (only negative integers and whole numbers)
input n goes from -200 to 200.
 */

package Practice;
import java.util.Scanner;
import java.lang.Math;
import java.math.BigInteger;

public class Problem_Statement_30_Solution {
	
	//Method to find the factorial of a number
	//Usage of BigInteger class since the numbers are bigger than the available primitive data types
	public static BigInteger fact(int n) { 
		BigInteger fact = BigInteger.ONE; 
		
		//Iterating from number n till 1
		for (int i = n; i > 0; i--) { 
			fact = fact.multiply(BigInteger.valueOf(i)); 
			} 
		return fact; 
		}
	
	//Finding the combination or nCr, to get the binomial coefficients
	static BigInteger nCr(int n, int r)   
    {   
		  BigInteger mult;
		  
		  //nCr=factorial(n)/[factorial(r)*factorial(n-r)]
		  mult=fact(r).multiply(fact(n-r));
          return fact(n).divide(mult);   
    }  
	
	public static void main(String[] args) {
		String s=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int no=sc.nextInt();
		
		//Finding the absolute value of the number entered to perform the desired operations
		int n=Math.abs(no);
		sc.nextLine();
		
		//If entered number is 0, the formula returns 1 as the answer
		if(n==0)
			System.out.println(1);
		
		//For non-zero numbers
		else {
			int i=n;
			for(int j=0;j<=n;j++) {	
				if(i==1 && j==1 && nCr(n,j).intValue()==1)		//Since any no. to the power 1 is the no. itself, so "^1" is not shown
					s=s+"ab+";													//Since any no. multiplied by 1 is the no. itself, so "1" is not shown
				else if(i==1 && j==1)
					s=s+nCr(n,j)+"ab+";
				else if(nCr(n,j).intValue()==1 && i==1)
					s=s+"ab^"+j+"+";
				else if(nCr(n,j).intValue()==1 && j==1)
					s=s+"a^"+i+"b+";			
				else if(i==1)
					s=s+nCr(n,j)+"ab^"+j+"+";
				else if(j==1)
					s=s+n+"a^"+i+"b+";			
				else if(j==0)												//Since any no. to the power 0 is 1, hence that no. is not shown
					s=s+"a^"+i+"+";
				else if(i==0)
					s=s+"b^"+j+"+";
				else if(nCr(n,j).intValue()==1)
					s=s+"a^"+i+"b^"+j+"+";
				else															   //The general formula
					s=s+nCr(n,j)+"a^"+i+"b^"+j+"+";
				i--;
			}
			if(no>0)					
				System.out.println(""+s.substring(4,(s.length()-1)));		//index from 4 to length of string -1 to exclude "null" at the start and "+" towards in the end
			else							//For negative integers, the formula is 1 divided by the general formula of it's absolute value
				System.out.println("1/("+s.substring(4,(s.length()-1))+")");
		}
	}
}
