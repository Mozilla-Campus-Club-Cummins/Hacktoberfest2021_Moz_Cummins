package Hacktoberfest_Moz_Cummins.Solutions;

import java.util.Scanner;
// Problem Statement: Remove Stones to Minimize the Total

//                     You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, 
//                     and an integer k. You should apply the following operation exactly k times:

//                     Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
//                     Notice that you can apply the operation on the same pile more than once.

//                     Return the minimum possible total number of stones remaining after applying the k operations.

//                     floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).

// My interpretation : To minimize the total number of stones left after 'k' no. of operations we will consider
//                     ceil(division of the max value in the array by 2) and not floor() since in the example 
//                     cases the operations like 9/2 = 4.5 was rounded-off to 5.
//                     Thereafter we achieve the greatest differnece. We continue applying this operation 
//                     on the pile 'k' no. of times.


public class Problem_Statement_54_Solution {
    public static Integer stoneCrusher(Integer[] arr, Integer k, Integer lengthOfArray){
        Integer maxIndex = 0, sum = 0;
        for(Integer i = 0; i < k ; i++){
            for(int j = 0; j<lengthOfArray;j++ ){
                if(arr[j]>arr[maxIndex]){
                    maxIndex = j;
                }
            }
            arr[maxIndex] =  (arr[maxIndex]+2-1)/2; //ceil division with integers only
        }
        for(Integer m = 0; m<lengthOfArray ; m++){
            System.out.print(arr[m] + " ");
            sum = sum + arr[m] ;
        }
        return sum;
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of piles: ");
        Integer lengthOfArray=sc.nextInt();
        Integer[] arr=new Integer[lengthOfArray];
        System.out.println("Enter the number of stones in each pile: ");
        for(Integer i=0;i<lengthOfArray;i++)
            arr[i]=sc.nextInt();
        System.out.println("Enter the number of times the operation has to be applied: ");
        Integer k = sc.nextInt();
        sc.close();
        System.out.println("\n");
        System.out.println("\nRemaining Stones = " + stoneCrusher(arr, k, lengthOfArray));    
    }
}


/*
================OUTPUT=================
Enter the number of piles: 
3 
Enter the number of stones in each pile: 
5 4 9
Enter the number of times the operation has to be applied: 
2

5 4 3 
Remaining Stones = 12

*/