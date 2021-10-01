import java.util.*;
public class Shop {

	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
    int qty; //Quantity
    int cost=250; //cost for each unit
    int tot_cost; 
    double dis_price;
    System.out.println("Enter quantity:");
    qty=sc.nextInt();
    tot_cost =(qty*cost);
    if(tot_cost>2500) {           //Checking if discount is applicable or not
    	System.out.println("\nDiscount of 10% applicable!");
    	dis_price = tot_cost-(tot_cost * 0.1);
    	System.out.println("Discounted price: "+dis_price); //Calculating discounted price
    }
    else {
    	System.out.println("\nDiscount not applicable!");
    	System.out.println("Price:"+tot_cost);
    }
  
	}

}
