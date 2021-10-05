import java.util.Arrays;

//maximum frequency
public class Problem_Statement_63 {
    static int highestFreq(int arr[]){
        Arrays.sort(arr);
        int n=arr.length;
        int max=1;
        int res=arr[0];
        int count=1;
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
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
