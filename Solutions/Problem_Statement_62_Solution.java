import java.util.Scanner;
/*Cummins college of engineering has the following grading policy:
Every student receives a grade in the inclusive range from 0 to 100
Any grade less than 40 is a failing grade.
Harshad is a professor at the college and likes to round each student's grade according to these rules:
If the difference between the grade and the next multiple of 5 is less than 3, round grade up to the next multiple of 5.
If the value of the grade is less than 38, no rounding occurs as the result will still be a failing grade.
Examples:
grade=84 round to (85 - 84 is less than 3)
grade=29 do not round (result is less than 40)
grade= 57 do not round (60 - 57 is 3 or higher)
Given the initial value of grade for each of Harshad's students, write code to automate the rounding process.*/
public class Problem_Statement_62_Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Total number of students");
        int n=sc.nextInt();
        int[] sarr =new int[n];//grades of each student
        //Accepting the grades
        for(int i=0;i<sarr.length;i++){
            System.out.println("Enter the grade of Student No. "+(i+1));
            sarr[i]=sc.nextInt();
        }
        for(int i=0;i<sarr.length;i++){
            int temp=0;
            if(sarr[i]>=38){//condition if Grades are greater than 38 then only rounding
                temp=sarr[i];
                while(temp%5!=0){//the loop will run until and unless it is divisible by 5
                    temp++;
                }
                int d=temp-sarr[i];
                if(d<3){//difference should be less than 3 for rounding
                    sarr[i]=temp;
                }
            }
        }
        System.out.println("Rounded Results (Grade)");
        for(int i=0;i<sarr.length;i++){
            System.out.println(sarr[i]);
        }
    }
}
