//Date: 9/10/2021 to 10/10/2021
//Given an m x n matrix, return all elements of the matrix in spiral order and sorted order.
import java.util.Scanner;
import java.util.Arrays;
public class Problem_Statment_8
{
    int A[][]=new int[10][10];
    int rows, columns;
    Scanner sc=new Scanner(System.in);
    void matrix()
    {
        rows=0;
        columns=0;
    }
    void Matrix(int r, int c)
    {
        rows=r;
        columns=c;
        A=new int[rows][columns];
    }
    void create()
    {
        System.out.println("Enter no. of rows: ");
        rows=sc.nextInt();
        System.out.println("Enter no. of columns: ");
        columns=sc.nextInt();
        System.out.println("Enter the elements: ");
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                A[i][j]=sc.nextInt();
            }
            System.out.println("");
        }
    }
    void display()
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                System.out.print("" +A[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    void spiralMatrix()
    {
        System.out.println("****The matrix in spiral order is****");
        int top=0;
        int bottom = A.length-1;
        int left=0;
        int right = A[0].length-1;
        int dir=0;
        int ans1, ans2, ans3, ans4;
        while(top<=bottom && left<=right)
        {
            if(dir == 0)  //To print values from left to right
            {
                for(int i=left;i<=right;i++)
                {
                    ans1=(A[top][i]);
                    System.out.println(ans1);
                }
                top+=1;
            }
            else if(dir==1)   //To print values from top to bottom
            {
                for(int i=top;i<=bottom;i++)
                {
                    ans2=(A[i][right]);
                    System.out.println(ans2);
                }
                right-=1;
            }
            else if(dir==2)   //To print values from right to left
            {
                for(int i=right;i>=left;i--)
                {
                    ans3=(A[bottom][i]);
                    System.out.println(ans3);
                }
                bottom--;
            }
            else if(dir==3)    //To print values from bottom to top
            {
                for(int i=bottom;i>=top;i--)
                {
                    ans4=(A[i][left]);
                    System.out.println(ans4);
                }
                left++;
            }
            dir=(dir+1)%4;
        }
        System.out.println("");
    }
    void sort()
    {
        System.out.println("****The sorted matrix is****");
        for (int i = 0; i < A.length; i++)
        {
            Arrays.sort(A[i]);  //using the sort function
        }
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[i].length; j++)
            {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

}

public class Main
{
    public static void main(String args[])
    {
        Problem_Statment_8 obj = new Problem_Statment_8();
        obj.matrix();
        obj.Matrix(3, 3);
        obj.create();
        obj.display();
        obj.spiralMatrix();
        obj.sort();
    }
}
