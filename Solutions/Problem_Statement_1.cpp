// -------------------------------------------------------------------------------------------------------------------

// Sneha is a student at Cummins College of engineering Pune. One day she has to distribute some chocolates
// to her friends. She is biased towards her friends and plans to give them more than the others. One of the
// professor hears of this and tells her to make sure everyone gets the same number. To make things difficult,
// she must equalize the number of chocolates in a series of operations. For each operation, she can give
// pieces to all but not one friend. Everyone who gets a piece in a round receives the same number of pieces.
// Given a starting distribution, calculate the minimum number of operations needed so that every friend has
// the same number of pieces.
// Example:
// arr=[1,1,5] arr represents the starting numbers of pieces for each colleague. She can give pieces to the
// first two and the distribution is then arr[3,3,5] . On the next round, she gives the same two pieces each,
// and everyone has the same number arr[5,5,5]. Return the number of rounds.

// -------------------------------------------------------------------------------------------------------------------

#include <bits/stdc++.h>
using namespace std;

int minOperations(vector<int> chocolates)
{
    int minEle = *min_element(chocolates.begin(), chocolates.end());
    int res = numeric_limits<int>::max();

    for (int i = 0; i < 5; i++)
    {
        auto op = [minEle, i](int x, int y)
        {
            int temp = y - (minEle - i);
            return x + temp / 5 + temp % 5 / 2 + temp % 5 % 2;
        };

        res = min(res, accumulate(chocolates.begin(), chocolates.end(), 0, op));
    }

    return res;
}

int main()
{
    int n;
    cin >> n;

    vector<int> chocolates(n);

    for(int i = 0; i < n; i++)
        cin >> chocolates[i];

    cout << minOperations(chocolates) << endl;

    return 0;
}

// -------------------------------------------------------------------------------------------------------------------

/* 
Output

3
1 1 5
2

5
2 3 4 1 5
6
*/
