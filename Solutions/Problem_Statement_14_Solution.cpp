//Problem:

/*Given a linked list of N nodes. The task is to check if the linked list has a loop. A linked list can contain a self-loop.

Example 1:

Input:
N = 3
value[] = {1,3,4}
x = 2
Output: True
Explanation: In above test case N = 3.
The linked list with nodes N = 3 is
given. Then value of x=2 is given which
means last node is connected with xth
node of linked list. Therefore, there
exists a loop.*/

//SOLUTION function:

//Making use of Floyd's algorithm(Tortoise and hare method) that uses two pointers fast and slow.
/*
1. Two pointers: fast and slow
2.Slow moves 1 step while fast moves 2 steps at a time
3.If they meet( are equal) there is a cycle
*/


#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    Node* next;

    Node(int val)
    {
        data = val;
        next = NULL;
    }
};

void loop(Node* head, Node* tail, int x)
{
    if(x==0||x<0) return;

    Node* walk = head;
    for(int i=1; i<x; i++)
        walk = walk->next;
    tail->next = walk;
}

class Solution {
public:
    bool isloop(Node *head) {
        Node* slow= head;
        Node* fast= head;
        while(fast!=NULL && fast->next!=NULL){
            slow=slow->next;
            fast=fast->next->next;
            if(fast==slow){
               return true;
            }
        }
        return false;
    }
};

int main()
{
        int n, first_ele,num;
        cout<<"Enter the length of linked list";
        cin>>n;

        Node *head, *tail;
        cout<<"Enter the first data element";
        cin>> first_ele;
        head = tail = new Node(first_ele);

        for(int i=0 ; i<n-1 ; i++)
        {   cout<< "Enter next element"<<endl;
            cin>> num;
            tail->next = new Node(num);
            tail = tail->next;
        }

        int x;
        cout<<"Enter x value"<<endl;
        cin>> x;
        loop(head,tail,x);

        Solution ob;
        if(ob.isloop(head) )
            cout<< "True\n";
        else
            cout<< "False\n";

	return 0;


}



