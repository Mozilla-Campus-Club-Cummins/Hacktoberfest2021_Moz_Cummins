// ---------------------------------------------------------------------------------------------------------------------------
// Consider a number. Take the cube of all its digits individually. Check whether the sum of the cubes is equal to the number
// ---------------------------------------------------------------------------------------------------------------------------

#include <iostream>
using namespace std;

bool isCube(int N)
{
    // If number is 0 or 1
    if (N == 0 || N == 1)
        return true;

    // Store given number to another variable
    int num = N;
    int sum = 0;

    // Take cubes of each digit in the number and add it to sum
    while (N)
    {
        int rem = N % 10;
        sum += rem * rem * rem;
        N /= 10;
    }

    // Check if the sum is equal to the given number or not
    if (sum == num)
        return true;

    return false;
}

int main()
{
    // Total test cases
    int T;
    cin >> T;
    cout << endl;

    while (T--)
    {
        // Take a number as an input
        int N;
        cin >> N;

        // If the sum of the cubes is equal to the number
        if (isCube(N))
            cout << "Yes\n";
        else
            cout << "No\n";

        cout << endl;
    }

    return 0;
}

/* ---------------------------------------------------------------------------------------------------------------------------
 
  output

    7

    0 
    Yes

    1 
    Yes

    370 
    Yes

    45 
    No

    100 
    No

    153 
    Yes

    1006 
    No


  --------------------------------------------------------------------------------------------------------------------------- */
