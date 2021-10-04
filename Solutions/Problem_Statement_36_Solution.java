/* 
Problem statement 36: Write a program to obtain integers in multiple lines
                        and print all pairs where the sum of any two integers is present in obtained input */

import java.util.*;

public class Problem_Statement_36_Solution {

    static void sum_num(int arr[], int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum = arr[i];
        }

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] + arr[j] == sum) {

                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");

                }
            }

        }

    }

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of integers:");
        int n = sc.nextInt();

        int arr[] = new int[n];
        n = arr.length;

        System.out.println("Enter the integers:");

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }

        sum_num(arr, n);
    }
}

/*Output cases:

Enter the number of integers:
4
Enter the integers:
7
2
6
8
(2, 6)


Enter the number of integers:
4
Enter the integers:
1
-1
4
3
(-1, 4)


Enter the number of integers:
7
Enter the integers:
12
-5
13
10
5
3
15
(12, 3)
(10, 5)

 */
