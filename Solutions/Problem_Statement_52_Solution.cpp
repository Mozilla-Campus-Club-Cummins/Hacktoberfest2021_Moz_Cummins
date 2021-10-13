/*Write a program asking for 10 integral inputs from the user to make a list. 
Now store only even values taken from the user and print the list.*/

#include <iostream>

using namespace std;

int main()
{
    int num, a[10];
    int k = 0;
    cout<<" Enter 10 Numbers :";  
    for (int i=0;i<10;i++)
    {
      cin>>num;
      if (num%2==0)
      {
        a[k++] = num; 
      }
    }
    
    for(int i =0; i < k; i++){
        cout<<a[i]<<" ";
    }
    return 0;
}


