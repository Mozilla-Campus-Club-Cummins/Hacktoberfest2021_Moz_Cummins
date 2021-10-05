import java.util.Scanner;
public class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Program_16 obj = new Program_16();
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

