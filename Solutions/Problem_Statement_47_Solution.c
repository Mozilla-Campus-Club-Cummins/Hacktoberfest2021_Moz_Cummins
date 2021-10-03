//Write a program to alphabetically sort a set of names entered by the user .


#include<stdio.h>
#include<string.h>
int main()
{
   int i,j;
   int num;
   char str[50][50];
   printf("Enter number of names : \n");
   scanf("%d",&num);
   printf("\nEnter %d names : \n", num);

   for(i=0;i<num;i++)
      scanf("%s",str[i]);
   for(i=0;i<num;i++)
   {
      for(j=i+1;j<num;j++)
      {
         if(strcmp(str[i],str[j])>0)
         {
            char name[50];
            strcpy(name,str[i]);
            strcpy(str[i],str[j]);
            strcpy(str[j],name);
         }
      }
   }

   printf("\nNames after sorting are:\n");
   for(i=0;i<num;i++)
      printf("%s\n",str[i]);

return 0;
}


/*output:

Enter number of names :
4

Enter 4 names:
Theo
Mira
Zion
Derek

Names after sorting are:
Derek
Mira
Theo
Zion
*/
