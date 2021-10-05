package Problem_Statement_26;
/*
 * Cheapest helicopters within k stops:
There are n countries connected by some number of helicopters. You are given an array helicopters where helicopters[i] = [sourcei, destinationi, costi] indicates that there is a helicopter from country sourcei to country destinationi with cost costi.

You are also given three integers src, dst, and k, return the cheapest cost from src to dst with at most k stops. If there is no such route, return -1.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//edge class to create edges between two nodes
class edge
{
	node destination;
	int distance;
	edge(node dest,int dist)
	{
		this.destination = dest;
		this.distance = dist;
	}
}
//node denotes countries
//they have node number
//and list of neighbours connected to it

class node
{
	int number;
	List<edge> neighbours;
	node(int number)
	{
		this.number = number;
		neighbours = new ArrayList<edge>();
	}
	
	void addEdge(node dest, int distance) {
		this.neighbours.add(new edge(dest,distance));
	}
}
public class Problem_Statement_26_Solution {
	
	static int n;
	static List<node> map;
	
	public static void main(String[] args) {
		//input 
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		//check constraint
		isValidn(n);
		
		//create list of n nodes
		createNodes(n);
		sc.nextLine();
		
		//input data
		String input = sc.nextLine();
		String[] data = input.substring(2,input.length()-2).split("\\]\\,\\[");
		String[] link;
		
		for(int i = 0; i<data.length;i++)
		{
			link = data[i].split(",");
			map.get(Integer.parseInt(link[0])).addEdge(map.get(Integer.parseInt(link[1])), Integer.parseInt(link[2]));
			
		}
		
		link  = sc.nextLine().split(" ");
		int src = Integer.parseInt(link[0]);
		int dest = Integer.parseInt(link[1]);
		int stops = Integer.parseInt(link[2]);
		
		//calculate minimum distance
		int result = calculateLeastCost(map.get(src),map.get(dest),stops);
		System.out.println(result<0?-1:result);
		
		
	}
	
	private static void isValidn(int n2) {
		if(n2<1 && n2>100)
		{
			System.out.println("Invalid input\n please try again with n values between 1 to 100");
		}
		
	}
	
	private static int calculateLeastCost(node src, node dest, int stops) {
		int result = Integer.MAX_VALUE;//holds the result to be returned
		
		int[] visited = new int[n];//keeps track of visited nodes
		
			if(visited[src.number]!=1)
			{
				visited[src.number] = 1;
				result = Math.min(result,DfsUtil(src,dest,stops,visited));
				visited[src.number] = 0;
			}
		
		return result==Integer.MAX_VALUE?-1:result;
	}
	
	//helper function that implements DFS
	private static int DfsUtil(node src, node dest, int stops, int[] visited) {
		int result = Integer.MAX_VALUE;
		
		if(stops<0)return result;
		
		if(src.number==dest.number && stops>=0)return -1;//if src == dest or if number of stops are more 
		//than nodes present in between src and dest then return and stop processing further
		
		if(stops==0)//if stops required are 0 then check only immediate neighbours
		{
			for(int i = 0 ;i< src.neighbours.size();i++)
			{
				if(src.neighbours.get(i).destination == dest && visited[src.neighbours.get(i).destination.number]!=1)
				{
					result = src.neighbours.get(i).distance;
					break;
					}
			}
			return result==Integer.MAX_VALUE?-1:result;
		}
		else// check all the paths
		{
			for(int i = 0 ;i< src.neighbours.size();i++)
			{
				if(visited[src.neighbours.get(i).destination.number]!=1)
				{
					visited[src.neighbours.get(i).destination.number] = 1;
					int x = DfsUtil(src.neighbours.get(i).destination,dest,stops-1,visited);
					if(x==-1)
					{
						visited[src.neighbours.get(i).destination.number] = 0;
						continue;
					}
					else
					{
						result = Math.min(result,x+src.neighbours.get(i).distance);
						visited[src.neighbours.get(i).destination.number] = 0;
					}
					
				}
			}

			return result==Integer.MAX_VALUE?-1:result;
		}
		
	}
	
	private static void createNodes(int n2) {
		map = new ArrayList<node>();
		for(int i=0;i<n;i++)
		{
			map.add(new node(i));
		}
	}
	

}
/*
solution:
3
[[0,1,100],[1,2,100],[0,2,500]]
0 2 0
500

3
[[0,1,100],[1,2,100],[0,2,500]]
0 2 1
200
*/