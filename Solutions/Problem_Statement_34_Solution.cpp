/*
You have n gifts and you want to give all of them to children. Of course, you don't want to offend anyone, so all gifts should be equal between each other.
The i-th gift consists of ai candies and bi oranges.
During one move, you can choose some gift 1≤i≤n and do one of the following operations:
eat exactly one candy from this gift (decrease ai by one);
eat exactly one orange from this gift (decrease bi by one);
eat exactly one candy and exactly one orange from this gift (decrease both ai and bi by one).
*/

#include <bits/stdc++.h>
using namespace std;

//ai is the number of candies in the i-th gift
//bi is the number of oranges in the i-th gift
//here n is number of gifts

int main()
{
    int a[100], b[100], n;
	int t;
	cin >> t;
    	//input the number of testcases
	while(t--)
	{
		cin >> n;
		int minOfA = INT_MAX, minOfB = INT_MAX;
		long long minMoves = 0;
		for(int i = 1; i <= n; i++)
		{
			cin >> a[i];
			minOfA = min(minOfA, a[i]);
		}	
		for(int i = 1; i <= n; i++)
		{
			cin >> b[i];
			minOfB = min(minOfB, b[i]);
		}
		for(int i = 1; i <= n; i++)
		{
			minMoves += 1ll * max(a[i] - minOfA, b[i] - minOfB);
		}
		cout << minMoves << endl;
	}
	return 0;
}


/*

Sample Input:
5
3
3 5 6
3 2 3
5
1 2 3 4 5
5 4 3 2 1
3
1 1 1
2 2 2
6
1 1000000000 1000000000 1000000000 1000000000 1000000000
1 1 1 1 1 1
3
10 12 8
7 5 4

Sample Output:
6
16
0
4999999995
7

*/
