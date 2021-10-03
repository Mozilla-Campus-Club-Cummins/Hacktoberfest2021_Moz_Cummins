#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main()
{
    int gifts;
    cin >> gifts;
    int candies[100];
    int oranges[100];
    int minCandies = INT_MAX, minOranges = INT_MAX, c=0, o=0;

    for(int i=1; i<=gifts; i++)
    {
      cin >> c;
      candies[i]=c;
      minCandies = min(minCandies, candies[i]);
    }	

    for(int i=1; i<=gifts; i++)
    {
      cin >> o;
      oranges[i]=o;
      minOranges = min(minOranges, oranges[i]);
    }

    long long minMoves = 0;
    for(int i=1; i<=gifts; i++)
    {
      minMoves += 1ll * max(candies[i] - minCandies, oranges[i] - minOranges);
    }

    cout << minMoves;

    return 0;
}
/*
Sample Input:
5
1 2 3 4 5
5 4 3 2 1
Sample Output:
16
*/
