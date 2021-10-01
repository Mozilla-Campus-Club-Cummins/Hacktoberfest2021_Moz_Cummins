import java.util.Scanner;
public class Problem_Statement_5_Solution {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n1,n2;
    n1=sc.nextInt();//First Number
    n2=sc.nextInt();//Second Number
    int sum=0,sum1=0;//Sum is sum of n1's factors ,sum1 is sum of n2's factors
        for(int i=1;i<n1;i++){
        if(n1%i==0){
            sum=sum+i;
        }
    }
        for(int i=1;i<n1;i++){
        if(n2%i==0){
            sum1=sum1+i;
        }
    }
        if(sum==n2 && sum1==n1){//if sum of all factors of n1 is equal to number n2 and if sum of all factors of n2 is equal to number n1
        System.out.println(n1 +" & "+n2 +" are amicable Numbers");
    }
        else{
        System.out.println(n1 +" & "+n2 +" are not amicable Numbers");
    }
  }
}
