/*
Contributor: Mrunal Jambenal(mrunal736)
Problem-Statement_51
Write a program taking three inputs from the user and checking (1) all are equal (2) any of two are equal
*/
//Solution:
#include <iostream>
using namespace std;
int main()
{
    
    int a,b,c;
    cout<<"Enter three inputs: \n";
    cin>>a>>b>>c;//Taking three inputs
    if(a==b && b==c){//comparing all inputs
        cout<<"All inputs are equal..\n";
    }
    else if(a==b || b==c || a==c){//comparing any of two inputs
        cout<<"Any of two are equal..\n";
    }

    return 0;
}
/*
Output:

Case1:

Enter three inputs:
32 32 32
All inputs are equal..

Case2:

Enter three inputs:
12 32 12
Any of two are equal..

*/
