import java.util.*;

public class Problem_Statement_25 {
    
    public static int histogram(int arr[]){

        int n=arr.length;
        Stack<Integer> st=new Stack<Integer>();
        
        // nearest smaller to left array filling
        int ind=0;
        int nsl[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){   // check if stack top is greater than current value 
                st.pop();       // if yes then pop it
            }
            if(st.isEmpty()){
                nsl[ind++]=-1;     // if stack is empty that means there is no element greater to the left  than this
            }
            else{
                nsl[ind++]=st.peek();
            }
            st.push(i);
        }
        st.clear();   // clear the stack 

        // nearest smaller to right array filling
         ind=n-1;
        int nsr[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){ // check if stack top is greater than current value 
                st.pop();
            }
            if(st.isEmpty()){
                nsr[ind--]=n;  // if stack is empty that means there is no element greater to the right  than this
            }
            else{
                nsr[ind--]=st.peek();
            }
            st.push(i);
        }

        // right - left -1;
        int ans[]=new int[n];
        int max=0;

        // measure the maximum area that can be formed
        for(int i=0;i<n;i++){
            ans[i]=(nsr[i]-nsl[i]-1)*arr[i];
            max=Math.max(max,ans[i]);
        }
        return max;  // return the max area
    } 

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();  // no of test cases
        int ans[]=new int[t];
        while(t-->0){
            int n=sc.nextInt();  // size of array
            int arr[]=new int[n];  
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();  // store values in array
            }
            ans[t]=histogram(arr);  // call for calculating max area 
        }
        for(int i=ans.length-1;i>=0;i--)
        System.out.println(ans[i]);  // printing the maximum area
    }
}

/*output:
2
6
2 1 5 6 2 3
5
2 4 6 3 5  
10
12
*/