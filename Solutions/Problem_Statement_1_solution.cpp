/*....
Sneha is a student at Cummins College of engineering Pune. One day she has to distribute some chocolates
to her friends. She is biased towards her friends and plans to give them more than the others. One of the
professor hears of this and tells her to make sure everyone gets the same number. To make things difficult,
she must equalize the number of chocolates in a series of operations. For each operation, she can give 1,2 or 5
pieces to all but not one friend. Everyone who gets a piece in a round receives the same number of pieces.
Given a starting distribution, calculate the minimum number of operations needed so that every friend has
the same number of pieces.
Example:
arr=[1,1,5] arr represents the starting numbers of pieces for each colleague. She can give 2 pieces to the
first two and the distribution is then arr[3,3,5] . On the next round, she gives the same two 2 pieces each,
and everyone has the same number arr[5,5,5]. Return the number of rounds, 2
...*/



#include <iostream>
using namespace std;

int dp[100];//declaring an array
int main()
{
    int n;

	int m = 99;
	cout<<"enter the number of colleagues: ";
	cin >> n;
	int ar[n];
	cout<<"enter the starting numbers of pieces for each colleague: ";
	for(int  i = 0 ; i < n ;i ++)//traversing the whole array and taking input
	{
	    cin >> ar[i];
	    m = min(m, ar[i]);//storing minimum value in m variable
	}
	for(int i = 0; i < 100; i ++)
	    dp[i] = 1000;
	dp[0] = 0;
	for(int i = 1; i < 80; i ++)
	{
	    dp[i] = min(dp[i], dp[i-1] + 1);//checking for 1
	    if(i - 2 >= 0)
		dp[i] = min(dp[i], dp[i-2] + 1);//checking for 2
	    if(i - 5 >= 0)
		dp[i] = min(dp[i], dp[i-5] + 1);//checking for 5
	}
	int count = 1000;
	for(int s = 0; s <= m; s ++)
	{
	    int ans = 0;//initialising ans to 0;
	    for(int i = 0; i < n; i ++)//traversing to store minimum of steps and answer
		ans += dp[ar[i] - s];

	    count = min(steps, ans);
	}
	cout << count << endl;//printing count;

    return 0;
}
