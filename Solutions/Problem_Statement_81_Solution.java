/*
 QUESTION :
 
 Suppose there are n points along a straight trail, while a runner runs sprints of intervals between those points.
The training plan is an array a[], which implies the runner should run from point a[i] to point a[i+1]. For example, given n = 10, a = [2, 4, 1, 2]. The runner should run from point 2 to point 4, then turn back from point 4 to point 1 (turning back form one point will count in frequency), and then from point 1 to point 2. Find the point that visited the most by the runner after he finished training, i.e., in the above example, point 2 is the most visited. If more than one point is visited the most, find the point with minimum index.
constraints:

1 <= n <= 100,000
1 <= a[i] <=n
size of array a <=100,000

Input:
the input is of 2 lines,
the first line denotes points on the line (n) followed by number of elements in array,
and second-line represents the array elements.

output:
Single integer, which denotes the smallest point having a maximum frequency.

sample input 1
10 4
2 4 1 2

sample output 1
2

sample input 2
20 15
1 10 12 5 15 10 2 5 7 9 11 6 9 10 7

sample output 2
7

Expected Time Complexity O(n)
Expected Space Complexity O(n)

Explanation of sample input 1
so the point on line are 10,
number of elements in array is 4, and the array is = {2, 4, 1, 2}
 * 
 */

package mozilla;

import java.util.*;

public class Problem_Statement_81_Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Accepting input data from user
		System.out.println("Enter n : ");
		int m = sc.nextInt();    
		System.out.println("Enter array size : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		//Accepting array from user 
		System.out.println("Enter array elements ");
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		//Created a visited array to keep track of visited numbers 
		int visited[] = new int[m+1];
		
		//Creating array-list to avoid in-between numbers in a traversal
		ArrayList<Integer> a = new ArrayList<>();
		a.add(arr[0]);
		for(int i=1;i<n-1;i++) {
			
			 if(arr[i]>arr[i-1]&&arr[i]<arr[i+1]||arr[i]<arr[i-1]&&arr[i]>arr[i+1]) {
				 continue;
			 }
			 else {
				 a.add(arr[i]);
			 }
			 
		}
		
		a.add(arr[n-1]);
// a is the Array List in which each i+2 th number is in the reverse direction
		
		
		for(int i=0;i<a.size()-1;i++) {
			//Setting j to ith element
			int j=a.get(i);
			//if the next element is greater than ith element incrementing visited[j] and j until
			//we reach next element
			if(a.get(i+1)>a.get(i)) {
			while(j<=a.get(i+1)) {
				visited[j]++;
				j++;
			}
			
			
			}
			//if the next element is smaller than ith element incrementing visited[j] and decrementing j until
			//we reach next element
			else {
				while(j>=a.get(i+1)) {
					visited[j]++;
					j--;
				}

		}
		}
        //Finding max of visited array 
		int max=0;
		for(int i =0;i<=m;i++) {
			
			if(visited[i]>visited[max]) {
				max=i;
			}
		}
		//Printing the number with max- frequency
		System.out.println("The number with maximum frequency is : "+max);
		
		

	}

}

/*
 Output :
 Enter n : 
20
Enter array size : 
15
Enter array elements 
1
10
12
5
15
10
2
5
7
9
11
6
9
10
7
The number with maximum frequency is : 7
 
 */
