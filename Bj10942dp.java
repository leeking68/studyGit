package NewProblem;

/**
 *
 * 백준 10942 펠린드롬 ? 
 * 
 * 동적계획
 * 
 *
 */
import java.util.Scanner;

public class Bj10942dp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		int[][] d = new int[n][n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				d[i][j] = -1;
			}
		}

		int T = in.nextInt();
		StringBuilder sb = new StringBuilder("");
		for (int test_case = 0; test_case < T; test_case++) {
			int a = in.nextInt();
			int b = in.nextInt();
			sb.append(solve(arr,d,a-1,b-1));
			sb.append("\n");
		}
		System.out.println(sb);

	}

	public static int solve(int[] arr, int[][] d, int i, int j) {
		if(i == j) {
			return 1;
		} else if(i+1 == j) {
			if(arr[i+1] == arr[j]) {
				return 1; 
			} else {
				return 0;
			} 
		}
		
		if(d[i][j]!=-1) {
			return d[i][j];
		}
		
		if(arr[i]!=arr[j]) {
			return 0;
		} else {
			return d[i][j] = solve(arr,d,i+1,j-1);
		}
		
		
	}
}
