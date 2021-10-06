import java.util.Arrays;
import java.util.Scanner;
/*
Given an array of animal sightings where every element represents an animal type id, determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
Example
arr = [1,1,2,2,3]
There are two each of types 1 and 2, and one sighting of type 3. Pick the lower of the two types seen twice: type 1.

Sample Input 0
6
1 4 4 4 5 3
Sample Output 0
4
*/
public class Problem_Statement_63 {
    static int highestFreq(int arr[], int n){
        //sorting the array
        Arrays.sort(arr);
        int max=1;
        //letting the element with highest frequency be the first element
        int res=arr[0];
        int count=1;
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
                //as the array is sorted, the duplicate elements will be together
                count++;
            }
            else{
                if(count>max){
                    max=count;
                    res=arr[i];
                }
                count=1;
            }
        }
        //checking for last element
        if(count>max){
            max=count;
            res=arr[n-1];
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of animal sightings there have been: ");
        int n=sc.nextInt();
        int arr[]=new int[n];
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.print("Enter the type sighted at "+(i+1)+" sighting: ");
            arr[i]=sc.nextInt();
        }
        System.out.println("Type spotted maximum times: "+highestFreq(arr, n));
        
    }
}
/*
I/P: arr[]={5,1,4,4,5,3};
O/P: 
Enter the number of animal sightings there have been: 6
Enter the type sighted at 1 sighting: 5
Enter the type sighted at 2 sighting: 1
Enter the type sighted at 3 sighting: 4
Enter the type sighted at 4 sighting: 4
Enter the type sighted at 5 sighting: 5
Enter the type sighted at 6 sighting: 3
Type spotted maximum times: 4
*/
