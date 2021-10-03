
import java.util.ArrayList;
import java.util.Scanner;

public class Problem_Statement_2_Solution {

	public static boolean CanJump(ArrayList<Integer> leaves) {
		ArrayList <Integer> distance=new ArrayList();
		for (int i = 1; i < leaves.size(); i++) {
			distance.add(i-1,leaves.get(i)-leaves.get(i-1));
		}
		for(int i=0;i<distance.size()-3;i++)
		{
			if(distance.get(i)+1 >=distance.get(i+1)+distance.get(i+2) &&distance.get(i+3)>distance.get(i+2)+1)
			{
				int temp=distance.get(i+1)+distance.get(i+2);
				distance.remove(i+2);
				distance.remove(i+1);
				distance.add(i+1,temp);
			}
		}
		for(int i=1;i<distance.size();i++)
		{
			if(distance.get(i-1)+1>=distance.get(i) &&distance.get(i-1)-1<=distance.get(i))
			{
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> leaves = new ArrayList();
		System.out.println("Enter the size of array");
		int n = sc.nextInt();
		System.out.println("Enter  the array elements");
		for (int i = 0; i < n; i++) {
			leaves.add(sc.nextInt());
		}
		System.out.println(CanJump(leaves));

	}

}
