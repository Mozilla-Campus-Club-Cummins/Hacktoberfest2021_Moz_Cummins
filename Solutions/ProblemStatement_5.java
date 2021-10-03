import java.util.Scanner;
public class ProblemStatement_5
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int num1 = sc.nextInt();
        System.out.println("Enter the second number: ");
        int num2 = sc.nextInt();
        int sum1 = 0, sum2 = 0,i;
        for (i = 1; i < num1; i++)
        {
            if (num1 % i == 0)
                sum1+=i;
        }
        for (i = 1; i < num2; i++)
        {
            if (num2 % i == 0)
                sum2 +=i;
        }
        if ((sum1 == num2) && (sum2==num1))
            System.out.println("The pair of numbers is amicable.");
        else
            System.out.println("The pair of numbers is not amicable.");
    }
}