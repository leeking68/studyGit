package NewProblem;

/**
 * 
 * @author gilhio
 *
 * 백준 10451 순열 사이클 
 */
import java.util.Scanner;

public class Bj10451 {
	public static int cnt = 0;
	public static int start = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int test_case = 0; test_case < t; test_case++) {

			int n = in.nextInt();
			cnt = 0;
			int[] graph = new int[n + 1];
			boolean[] check = new boolean[n+1];
			
			for (int i = 1; i < n + 1; i++) {
				graph[i] = in.nextInt();
			}
			
			for(int i = 1; i < n+1; i++) {
				if(!check[i]) {
					check[i] = true;
					start = i;
					solve(graph[i],check,graph);
					cnt++;
				}
			}
			
			System.out.println(cnt);

		}
	}
	
	public static void solve(int i,boolean[] check,int[] graph) {
		
		if(i == start) {
			return;
		}
		
		if(!check[i]) {
			check[i] = true;
			solve(graph[i],check,graph);
		}
		
		return;
		
	}
	
	

}
