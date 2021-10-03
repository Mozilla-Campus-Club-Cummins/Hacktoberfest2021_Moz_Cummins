class Solution {
public:
    int consecutiveNumbersSum(int n) {
        int currSum = 0;
        int end = 1;
        int start = 1;
        int count = 0;
        while(end<n){
            if(currSum<n){
                currSum+=end;
                end++;
            }
            else if(currSum>n){
                currSum-=start;
                start++;
            }
            else{
                count++;
                currSum+=end;
                end++;
                currSum-=start;
                start++;
            }
            //cout<<currSum<<endl;
        }
        //cout<<count<<endl;
        if(currSum==n) count++;
        return 1+count;
    }
};
