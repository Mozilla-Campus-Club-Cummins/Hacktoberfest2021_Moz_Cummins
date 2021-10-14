/*
 * Given an array of integers citations where citations[i] is the number of citations, 
 * a researcher received for their ith paper, return compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.
 * If there are several possible values for h, the maximum one is taken as the h-index.
 */
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
/*
 * INPUT:
 * 5
 * 3 0 6 1 5
 * OUTPUT:
 * 3
 */
