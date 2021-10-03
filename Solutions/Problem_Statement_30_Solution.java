package Practice;
import java.util.Scanner;
import java.lang.Math;
import java.math.BigInteger;

public class Problem_Statement_30_Solution {
	public static BigInteger fact(int n) { 
		BigInteger fact = BigInteger.ONE; 
		for (int i = n; i > 0; i--) { 
			fact = fact.multiply(BigInteger.valueOf(i)); 
			} 
		return fact; 
		}
	
	static BigInteger nCr(int n, int r)   
    {   
		  BigInteger mult;
		  mult=fact(r).multiply(fact(n-r));
          return fact(n).divide(mult);   
    }  
	
	public static void main(String[] args) {
		String s=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int no=sc.nextInt();
		int n=Math.abs(no);
		sc.nextLine();
		if(n==0)
			System.out.println(1);
		else {
			int i=n;
			for(int j=0;j<=n;j++) {	
				if(i==1 && j==1 && nCr(n,j).intValue()==1)
					s=s+"ab+";
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
				else if(j==0)
					s=s+"a^"+i+"+";
				else if(i==0)
					s=s+"b^"+j+"+";
				else if(nCr(n,j).intValue()==1)
					s=s+"a^"+i+"b^"+j+"+";
				else
					s=s+nCr(n,j)+"a^"+i+"b^"+j+"+";
				i--;
			}
			if(no>0)
				System.out.println(""+s.substring(4,(s.length()-1)));
			else
				System.out.println("1/("+s.substring(4,(s.length()-1))+")");
		}
	}
}
