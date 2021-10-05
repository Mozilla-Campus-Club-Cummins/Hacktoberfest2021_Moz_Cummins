//Date: 3/10/2021 to 5/10/2021
//Given two strings 'str' and a wildcard pattern 'pattern' of length N and M respectively.
// You have to print '1' if the wildcard pattern is matched with str else print '0'
import java.util.Scanner;
public class Program_Statment_16
{
    Scanner sc = new Scanner(System.in);
    public static boolean String_match(String str1, String str2)
    {
        boolean dp[][] = new boolean[str2.length() + 1][str1.length() + 1];  //memory 1 greater than the length of the str1 and str2

        for (int i = dp.length - 1; i >= 0; i--)
        {
            for (int j = dp[0].length - 1; j >= 0; j--)
            {
                if (i == dp.length - 1 && j == dp[0].length - 1)   //For last row and last cell
                {
                    dp[i][j] = true;
                }
                else if (i == dp.length - 1)   //For last row
                {
                    dp[i][j] = false;
                }
                else if (j == dp[0].length - 1)   //For last column
                {
                    if (str2.charAt(i) == '"')
                    {
                        dp[i][j] = dp[i + 1][j];   //To check the element below it
                    }
                    else
                    {
                        dp[i][j] = false;
                    }
                }
                else
                {
                    if (str2.charAt(i) == '?')   //If char of str2 == ? then it will check the diagonal element
                    {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                    else if (str2.charAt(i) == '"')   //If char of str2 == " then it will take OR of adjacent and lower element
                    {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    }
                    else if (str2.charAt(i) == str1.charAt(j))  //If char of str2==str1 then it will check the diagonal element
                    {
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                    else
                    {
                        dp[i][j] = false;
                    }

                }
            }
        }
        return dp[0][0];
    }
}

public class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Program_Statment_16 obj = new Program_Statment_16();
        System.out.println("Enter the string value: ");  //Enter the string value
        String s1 = sc.nextLine();
        System.out.println("Enter the wildcard pattern value: ");   //Enter the value of wildcard value
        String s2 = sc.nextLine();
        if (obj.String_match(s1, s2))    //To print 1 or 0 and not true or false
        {
            System.out.println("1");
        }
        else
            System.out.println("0");
    }
}

