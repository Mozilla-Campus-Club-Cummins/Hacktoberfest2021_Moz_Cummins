package Hacktoberfest_Moz_Cummins.Solutions;

public class Problem_Statement_54_Solution {
    public static Integer stoneCrusher(Integer[] arr, Integer k){
        Integer maxIndex = 0, sum = 0;
        for(Integer i = 0; i < k ; i++){
            for(int j = 1; j<arr.length;j++ ){
                if(arr[j]>arr[maxIndex]){
                    maxIndex = j;
                }
            }
            arr[maxIndex] =  (arr[maxIndex]+2-1)/2;
        }
        for(Integer m = 0; m<arr.length ; m++){
            System.out.println(arr[m]);
            sum = sum + arr[m] ;
        }
        return sum;
    }

    public static void main(String[] args){
        Integer[] arr = {5,4,9};
        Integer k = 2;
        System.out.println("Remaining Stones = " +stoneCrusher(arr, k));
        
    }
}


/*
================OUTPUT=================
5
4
3
Remaining Stones = 12

*/