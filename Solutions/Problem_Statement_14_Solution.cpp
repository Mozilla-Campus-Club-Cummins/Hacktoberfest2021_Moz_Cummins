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
