
/******************************************************************************
Problem Statement :
Write a program taking three inputs from the user and checking
(1) all are equal
(2) any of two are equal
*******************************************************************************/

//Solution :

#include <iostream>
#include <string.h>
using namespace std;
int main()
{
    int ch;
    double a,b,c;
    char str1[100],str2[100],str3[100];
    
    cout<<"\n1.Strings \n2.Numbers \nSelect Input type :";     //For both string and Number input type 
    cin>>ch;
    switch(ch)
    {
        case 1 : { 
                   cout<<"Enter 3 Strings :";                 //If inputs are strings 
                   cin>>str1>>str2>>str3;
                   
                   if (strcmp(str1,str2)==0 && strcmp(str2,str3)==0 )
                      cout<<"All inputs -> "<<str1<<","<<str2<<" & "<<str3<<" are equal.";
                      
                   else if(strcmp(str1,str2)==0 || strcmp(str2,str3)==0 || strcmp(str1,str3)==0)
                      cout<<"Any of two are equal.";
                   else 
                      cout<<"None of them are equal.";
                   break; 
                 } 
        case 2 : { 
                   cout<<"Enter 3 Numbers :";                //If inputs are numbers
                   cin>>a>>b>>c;
                   
                   if (a==b && c==b)
                      cout<<"All inputs -> "<<a<<","<<b<<" & "<<c<<" are equal.";
                      
                   else if (a==b || b==c || a==c)
                      cout<<"Any of two are equal.";
                   else 
                      cout<<"None of them are equal.";
                   break;
                 }
    }
    return 0;
}



