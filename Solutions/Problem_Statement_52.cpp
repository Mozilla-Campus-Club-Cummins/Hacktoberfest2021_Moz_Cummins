/*
Problem Statement :
Write a program asking for 10 integral inputs from the user to make a list. 
Now store only even values taken from the user and print the list.
*/

//Solution :

#include <iostream>

using namespace std;

int main()
{
    int num;
    cout<<" Enter 10 Numbers :";  
    for (int i=0;i<10;i++)              //To take inputs from user
    {
      cin>>num;
      if (num%2==0)                    //To check and print Even Numbers list
        {
          cout<<num;
          cout<<endl;
        }
    }
    return 0;
}
