import java.util.Scanner;

public class Problem_Statement_15 {
    public static void waveSort(int arr[]){
        for(int i=1;i<arr.length;){
            if(arr[i]<arr[i-1])  // if current value is smaller than previous then swap them
            swap(arr,i,i-1);  
            if(i<arr.length-1 && arr[i]<arr[i+1] )  // if current value is smaller than next element then swap them
            swap(arr,i,i+1);
            i+=2;          // increment by 2
        }

    }
    static void swap(int arr[],int a,int b){ // swap the values at index a and index b
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();   // size of array
        int arr[]=new int[n];  // array of size n
        for(int i=0;i<n;i++){  
            arr[i]=sc.nextInt();   // insert values in array
        }
        waveSort(arr);   // call for function
        
        for(int i=0;i<arr.length;i++){   // final array
            System.out.print(arr[i]+" ");
        }
    }
}


/*Output:
7
4 3 7 8 6 2 1
3 7 4 8 2 6 1 
*/