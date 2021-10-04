/*Problem-2:An insect is crossing a road. The road is divided into some number of units, and at each unit,
 * there may or may not exist a leaf.An insect can jump on a leaf, but it must not jump on road.
Given a list of leaf's positions (in units) in sorted ascending order, 
determine if an insect can cross the road by landing on the last leaf. 
Initially, an insect is on the first leaf and assumes the first jump must be 1 unit.
If insect's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. 
An insect can only jump in the forward direction.
eg: Input: leaves= [0,1,3,5,6,8,12,17]
Output: true
Explanation: An insect can jump to the last leaf by jumping 1 unit to the 2nd leaf, 
then 2 units to the 3rd leaf, then 2 units to the 4th leaf, then 3 units to the 6th leaf, 
4 units to the 7th leaf, and 5 units to the 8th leaf.
Input: leaves = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last leaf as the gap between the 5th and 6th leaf is too large.*/

import java.util.ArrayList;
import java.util.Scanner;

public class Problem_Statement_2_Solution {

	public static boolean CanJump(ArrayList<Integer> leaves) {
		ArrayList <Integer> distance=new ArrayList();	//to store the difference of distance between two elements
		for (int i = 1; i < leaves.size(); i++) {
			distance.add(i-1,leaves.get(i)-leaves.get(i-1)); //storing difference
		}
		for(int i=0;i<distance.size()-3;i++) //merging the two distance which are less than the k+1 and the next distance is greater than previous
		{
			if(distance.get(i)+1 >=distance.get(i+1)+distance.get(i+2) &&distance.get(i+3)>distance.get(i+2)+1)
			{
				int temp=distance.get(i+1)+distance.get(i+2);
				distance.remove(i+2);
				distance.remove(i+1);//removing the merged distance 
				distance.add(i+1,temp);//adding the sum of distance
			}
		}
		for(int i=1;i<distance.size();i++)
		{
			if(distance.get(i-1)+1>=distance.get(i) &&distance.get(i-1)-1<=distance.get(i))//checking whether next distance is between the prev+1 and prev-1 distance or not
			{
			}
			else //otherwise return false
			{
				return false;
			}
		}
		return true; //returning the true if all conditions are satisfied
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> leaves = new ArrayList();
		System.out.println("Enter the size of array");
		int n = sc.nextInt();						//Input from user size of the array
		System.out.println("Enter  the array elements");
		for (int i = 0; i < n; i++) {
			leaves.add(sc.nextInt());	//input array elements
		}
		System.out.println(CanJump(leaves));	//calling function and printing the return value

	}

}


/*
Output:

Enter the size of array
8
Enter  the array elements
0
1
3
5
6
8
12
17
true
***************
Enter the size of array
8
Enter  the array elements
0
1
2
3
4
8
9
11
false

*/