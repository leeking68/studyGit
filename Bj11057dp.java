package NewProblem;

import java.util.Scanner;

public class Bj11057dp {

	public static int mod = 10007;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[][] dp = new int[n+1][10];

		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
			dp[1][i] %= mod;
		}

		for (int i = 2; i < n+1; i++) {
			for (int k = 0; k < 10; k++) {
				for(int l = 0; l <= k; l++) {
					dp[i][k] += dp[i-1][l];
					dp[i][k] %= mod;
				}
			}
		}
		
		int ans = 0;
		
		for(int i = 0; i < 10; i++) {
			ans += dp[n][i];
		}
		
		System.out.println(ans%mod);
	}
}
