import java.util.Arrays;
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
    static int highestFreq(int arr[]){
        //sorting the array
        Arrays.sort(arr);
        int n=arr.length;
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
        int arr[]={5,1,4,4,5,3};
        System.out.println(highestFreq(arr));
    }
}
/*
I/P: arr[]={5,1,4,4,5,3};
O/P: 4
*/
