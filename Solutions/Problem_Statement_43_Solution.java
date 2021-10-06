//package hacktober;
import java.util.Arrays;
import java.util.Scanner;
public class Problem_Statement_43_Solution 
{
	public static void main(String args[])
	{	
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter number of array elements: ");
		int n = sc.nextInt();
		int[] citations = new int[n];
		//System.out.println("Enter Array: ");
		for(int i = 0; i < n; i++)
		{
			citations[i] = sc.nextInt();
		}
		System.out.println(hindex(citations));
	}
	public static int hindex(int[] arr)
	{
		if((arr.length == 0)||(arr == null))
            return 0;
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length; i++)
        {
              if(arr[i] >= (arr.length - i))
              {
                  return (arr.length-i);
              }
        }
        return 0;
	}
	
}
