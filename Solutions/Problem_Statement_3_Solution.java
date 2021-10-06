
import java.util.*;
import java.math.*;

/*You have a factory with M containers filled with an infinite number of chocolates. The containers are arranged in a single row, equally spaced to be 1 meter apart. You also have 2 bots that can pick up a piece of chocolate and transport it between any two containers.
The bots take instructions in the form of queries consisting of two integers, Ma and Mb, respectively. To execute a query, a bot travels to container Ma, picks up 1 chocolate, transports it to container Mb, and then stops at Mb until it receives another query.

Calculate the minimum total distance the bots must travel to execute N queries in order.

Note: You choose which bot executes each query.

Input format
The first line contains a single integer T (number of test cases); each of the T test cases is described over N+1 lines.
The first line of a test case has two space-separated integers, M (number of containers) and N(the number of queries).
The N subsequent lines each contain two spaced integers, Ma and Mb, respectively; each line Ni describes the ith query.

Output format
On a new line for each test case, print an integer denoting the minimum total distance that the robots must travel to execute the queries in order.

Sample input
3
5 4
1 5
3 2
4 1
2 4
4 2
1 2
4 3
10 3
2 4
5 4
9 8

Sample Output
11
2
5

Explanation
In this explanation, we refer to the two robots as R1 and R2, each container "i" as "Mi" , and the total distance traveled for each query "j" as.
Note: For the first query a robot executes, there is no travel distance. For each subsequent query that robot executes, it must travel from the location where it completed its last query.

Test case 0:

Robot: R1
m1->m5
D0 = | 1 - 5 | = 4 meters
Robot: R2
M3->M2
D1 = | 3 - 2 | = 1 meters
Robot: R1
M5->M4->M1
D2 = | 5 - 4 | + | 4 - 1 | = 1 + 3 = 4 Meters
Robot: R2
M2 -> M2 -> M4
D3 = | 2-2 | + | 2 - 4 | = 0+2 = 2 meters
Sum of the distances traveled (D0+D1+D2+D3) = 4+1+4+2 = 11 and print the result on a new line.*/


public class Problem_Statement_3_Solution {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the number of test cases");
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			minDistance();
		}
	}

	static void minDistance() {
		System.out.println("Enter the number of containers and queries");
		int m = sc.nextInt(); //number of containers
		int n = sc.nextInt();	//number of queries
		long[] dis = new long[m + 1]; 		//array to store the distance
		Arrays.fill(dis, Long.MAX_VALUE);	//initializing with the maximum value
		int pos = 0;// current position		//pointing to the current position of robot

		int ma, mb;
		long d = 0;
		dis[0] = 0; 
		System.out.println("Enter the source and destination of containers");
		for (int i = 0; i < n; i++) {
			ma = sc.nextInt();	//source container
			mb = sc.nextInt();	//destination container
			long[] temp = new long[m + 1];	//temp array to store the 
			Arrays.fill(temp, Long.MAX_VALUE);	//initializing the temp to max value everytime
			for (int j = 0; j <= m; j++) {  //teversing the containers
				if (dis[j] == Long.MAX_VALUE) //if dis[j] is max_value then continue
					continue;
				d = dis[j] + Math.abs(mb - ma); //calculating the distance between 2 containers
				if (j == 0)		//if j==0 then assign temp[pos] min value between temp[pos] and d
					temp[pos] = Math.min(d, temp[pos]);
				else	//if j!=0 then assign the min between d+ma-j and temp[pos]
					temp[pos] = Math.min(d + Math.abs(ma - j), temp[pos]);

				if (pos == 0) //if first query performing
					temp[j] = Math.min(d, temp[j]);  //assign min between d and temp[j]
				else  //else assign min between d+ma-pos and temp[j]
					temp[j] = Math.min(d + Math.abs(ma - pos), temp[j]);
			}
			
			pos = mb; //changing the current pos to destination container
			dis = temp;	//dis array is pointing to temp where changes have been taken place

		}
		long min = dis[0]; 
		for (int i = 0; i <= m; i++)
			min = Math.min(min, dis[i]); //finding out the min distance from dis array
		System.out.println("minimum total distance travelled: "+min); //printing min distance
	}
}
/*
 * output:
 Enter the number of test cases
3
Enter the number of containers and queries
5 4
Enter the source and destination of containers
1 5
3 2
4 1
2 4
minimum total distance travelled: 11
Enter the number of containers and queries
4 2
Enter the source and destination of containers
1 2
4 3
minimum total distance travelled: 2
Enter the number of containers and queries
10 3
Enter the source and destination of containers
2 4
5 4
9 8
minimum total distance travelled: 5
*/
