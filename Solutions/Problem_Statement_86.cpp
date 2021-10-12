/*Given an integral number(Taken from user) of watermelons w (1≤w≤100; 1 ≤w in Haskell), 
check whether Jaya and Rekha can divide the melons so that each of them gets an even amount.*/

#include <stdio.h>

int main () 
{
    int n,x,y;
    
    printf("Enter the number of watermelons: ");
    scanf("%d" , &n) ;
    for(y=1 ; y<=n ; y++)
    {
     x=n-y;
      if(x%2==0) 
      {
        for(x ; x>=y ; x=n-y)
        {
            y=y+2 ;
            printf("Divide(%d) == False // %d = %d", n,n,x);
            printf(" + %d\n", y-2);    
        }
      }   
      else 
      {
        for(x ; x>=y ; x=n-y)
        {
            y=y+2 ;
            printf("Divide(%d) == True // %d = %d", n,n,x);
            printf(" + %d\n", y-2);    
        }
      }
    }
    return 0;
}  