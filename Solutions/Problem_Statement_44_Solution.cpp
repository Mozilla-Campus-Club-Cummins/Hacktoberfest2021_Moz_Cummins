/*We have an array of integers, nums, and an array of requests where requests[i] = [starti, endi]. The ith request asks for the sum of nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]. Both starti and endi are 0-indexed.

Return the maximum total sum of all requests among all permutations of nums.

Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:

Input: nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
Output: 19
Explanation: One permutation of nums is [2,1,3,4,5] with the following result:
requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
Total sum: 8 + 3 = 11.
A permutation with a higher total sum is [3,5,4,2,1] with the following result:
requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
requests[1] -> nums[0] + nums[1] = 3 + 5 = 8
Total sum: 11 + 8 = 19, which is the best that you can do.
Example 2:

Input: nums = [1,2,3,4,5,6], requests = [[0,1]]
Output: 11
Explanation: A permutation with the max total sum is [6,5,4,3,2,1] with request sums [11].
Example 3:

Input: nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
Output: 47
Explanation: A permutation with the max total sum is [4,10,5,3,2,1] with request sums [19,18,10].*/

#include<iostream>
#include<stdlib.h>
#include<algorithm>
#include<cmath>
using namespace std ;

int main(void)
{
	int n = 0 ;
	int i = 0 ;
	int j = 0 ;
	int r = 0 ;
	long int sum = 0 ;
	int startIndex = 0 ;
	int endIndex = 0 ;
	int *nums = NULL ;
	int *count = NULL ;
	int **requests = NULL ;
	int mod = 0 ;
	int result = 0 ;

	cin >> n ;

	nums = new int[n] ;

	//Take nums array as input
	for(i=0 ; i<n ; ++i)
	{
		cin >> nums[i];
	}

	cin >> r ;

	requests = new int*[r] ;


	for(i=0 ; i<r ; ++i)
	{
		requests[i] = new int[2] ;
	}

	//Take each request as input(2-d array of size nx2)
	for(i=0 ; i<r ; ++i)
	{
		for(j=0; j<2 ; ++j)
		{
			cin >> requests[i][j];
		}
	}

	//For each request, increment the value at startIndex & decrement the value at endIndex by 1 in count array
	count = new int[n] ;
	for(i=0 ; i<r ; ++i)
	{
		startIndex = requests[i][0] ;
		endIndex = requests[i][1] + 1 ;

		count[startIndex]++ ;
		if(endIndex < n)
		{
			count[endIndex]-- ;
		}
	}

	//Calculate the prefix sum for the count array to get occurrence of each element in all requests
	for(i=1 ; i<n ; ++i)
	{
		count[i] = count[i] + count[i-1] ;
	}

	//sort nums and count array in ascending order.
	sort(nums, nums+n) ;
	sort(count, count+n) ;

	//Maximum sum is addition of multiplication of each elements in nums and count array. As arrays are sorted, the
	//largest element is multiplied with the largest count(i.e occurance) value and so on, hence giving maximum sum.
	for(i=0 ; i<n ; ++i)
	{
		sum = sum + (nums[i] * count[i]) ;
	}

	//Final result is calculated by taking sum modulo 10^9+7 as stated in problem statement.
	mod = pow(10, 9) + 7 ;
	result = sum % mod ;

	cout << result ;

	delete[] nums ;
	delete[] count ;

	return 0 ;
}
