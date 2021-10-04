/*
Problem-statement#77
The sum of the squares of the first ten natural numbers is:
1 * 1 + 2 * 2 + ... + 10 * 10 = 385
The square of the sum of the first ten natural numbers is:
(1 + 2 + ... + 10) * (1 + 2 + ... + 10) = 55 * 55 = 3025
The difference between the sum of the squares of the first ten natural numbers and the square of the sum is:
3025 − 385 = 2640
Find the difference between the sum of the squares of the first n natural numbers (n > 0) and the square of the sum, and then return the sum of the square of its digits.
e.g 2640 --> 2 * 2 + 6 * 6 + 4 * 4 + 0 * 0 = 56
*/  

#include<iostream> 
using namespace std;
int main(){
    int n;
    cout<<"Enter value for n: \n";//Here n is number of 'n' natural numbers.
    cin>>n;
    int sum1,sum2;

    sum1 = (n*(n + 1)) / 2;//Sum of first n natural numbers.

    sum2 =  (n * (n + 1) * (2 * n + 1)) / 6;//Sum of squares of first n natural numbers.

    //absolute difference between Square of Sum of n natural numbers and Sum of squares of n natural numbers.
    int diff = abs((sum1*sum1) - sum2);
    //Sum of squares of digits of the difference found above.
    int ans=0;
    while(diff>0){
        int x = diff%10;
        ans += x*x;
        diff = diff/10;
    }
    cout<<"The answer is: "<<ans<<endl;
}

/*
The final Output:
 Enter value for n: 
 10
 The answer is: 56
*/
