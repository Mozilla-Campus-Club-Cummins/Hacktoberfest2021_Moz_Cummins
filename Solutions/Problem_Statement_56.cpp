// A company manufactures different types of software products. They deliver their products to their N clients. 
// Whenever the company fulfills the complete order of a client, the orderID generated is the concatenation of 
// the number of products delivered for every committed product type. The head of the sales team wishes to find 
// the clientwise data for the total number of products of any type delivered to every client.
// Write an algorithm for the head of the sales team to calculate the total number of products of any type 
// delivered to the respective clients.

#include<iostream>
using namespace std;
void id(int num){
    int sum=0;
    while(num!=0){
        sum+=(num%10);
        num/=10;
    }
    cout<<sum<<" ";
}
int main(){
    int t;
    cin>>t;
    int prod[t];
    for(int i=0;i<t;i++){
        cin>>prod[i];
    }
    for(int i=0;i<t;i++){
        id(prod[i]);
    }
    return 0;
}