#include <stdio.h>
#include<string.h>

static int permutation(char *s, int a, int n);
int main()
{
    char str[100];
    int n;
    printf("Enter the string: ");
    scanf("%s",str);
    n=strlen(str);
    permutation(str,0,n-1);  //function call

    return 0;
}

static int swap(char *c1, char *c2);
int permutation(char *s, int a, int n)  
    //function for generating permutations
    //int a = initial index i.e., 0
    //int n = index of last variable i.e., 2
{
    int j;
    if (a==n)
        printf("%s\n",s);
    else
    {
        for(j=a; j<=n; j++)
        {
            swap((s+a),(s+j));
            permutation(s,a+1,n);
            swap((s+a),(s+j));  //back-tracking
        }
    }
    return 0;
}

int swap(char *c1, char *c2)  
    //function for swapping 2 integers (at a time)
    // Let initially c1=x and c2=y
{
    char temp;
    temp=*c1;   //temp=x
    *c1=*c2;    //c1=y
    *c2=temp;   //c2=x

    return 0;
}