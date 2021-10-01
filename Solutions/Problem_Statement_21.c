 
#include <stdio.h>
#include <string.h>

void count(char str[]);

int main()
{
    char text[80];
    printf("Enter a string : ");
    gets(text);
    count(text);
    return 0;
}

void count(char str[])
{
    int i, j, count;
    for (i = 0; str[i] != '\0'; i++)
    {
        count = 0;
        for (j = 0; str[j] != '\0'; j++)
        {
            if (str[j] == str[i])
            {
                count++;
            }
        }
        printf("%c : %d\n", str[i], count);
    }
}