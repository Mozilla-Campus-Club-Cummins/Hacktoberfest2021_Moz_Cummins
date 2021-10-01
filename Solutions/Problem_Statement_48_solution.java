/*Write a program to find line of best fit for any 5 points entered by the user.
(take input of x and y coordinates of each point from user).*/
import java.util.Scanner;
public class Problem_Statement_48_solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = 5;//Only for 5 points given in problem
        int x[]=new int[n];//Array of elements of x coordinate
        int y[]=new int[n];//Array of y coordinate

        //Accepting the x coordinates
        for(int i=0;i<x.length;i++){
            x[i]=sc.nextInt();
        }
        //Accepting the y coordinates
        for(int i=0;i<y.length;i++){
            y[i]=sc.nextInt();
        }

        //finding summation of x and y , diff1=(xi-X') and diff2 =(yi-Y')

        float sumx=0,sumy=0,diff1=0,diff2=0,mul=1,mul2=1,SUMUp=0,SUMdown=0;
        for(int i=0;i<n;i++){
            sumx=sumx+x[i];
            sumy=sumy+y[i];
        }
        float X= sumx/n;
        float Y= sumy/n;

        for(int i=0;i<n;i++){
            diff1=(x[i]-X);
            diff2=(y[i]-Y);
            mul=diff1*diff2;
            SUMUp += mul;
            mul2=diff1*diff1;
            SUMdown += mul2;
        }
        System.out.println(SUMUp);
        System.out.println(SUMdown);
        float m=SUMUp/SUMdown;
        float c=Y-m*X;
        //Printing line of best fit
        System.out.println("Line of Best Fit is y="+m+"x+"+c);
    }
}
