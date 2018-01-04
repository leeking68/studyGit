package NewProblem;
/**
 * 
 * 
 * 백준 11053 가장긴증가하는 수
 * 
 * LIS
 * 
 */

import java.util.Scanner;

public class Bj11053Lis {

	public static int max = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] A = new int[n + 1];
		int[] dp = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			A[i] = in.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (A[j] < A[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
				
				if(max <dp[i]) {
					max = dp[i];
				}
			}
		}
		
		System.out.println(max);

	}

}
