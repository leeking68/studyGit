package NewProblem;

/**
 * 
 * 백준 10844 쉬운계단 
 * 
 * dp 
 * 
 */
import java.util.Scanner;

public class Bj10844dp {

	public static int mod = 1000000000;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[][] dp = new int[101][101];

		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
			dp[1][i] %= mod;

		}

		for (int i = 2; i < n + 1; i++) {
			for (int k = 0; k < 10; k++) {
				if (k == 0) {
					dp[i][k] += dp[i - 1][k + 1];
				} else if (k == 9) {
					dp[i][k] += dp[i - 1][k - 1];

				} else {
					dp[i][k] += dp[i - 1][k - 1] + dp[i - 1][k + 1];

				}

				dp[i][k] %= mod;

			}
		}
		//
		// for(int i = 2; i < N+1; i++) {
		// for(int j = 0; j < 10; j++) {
		//
		// dp[i][j] = 0;
		//
		// if(j+1<=9) dp[i][j] += dp[i-1][j+1];
		//
		// if(j-1>=0) dp[i][j] += dp[i-1][j-1];
		//
		// dp[i][j]%=mod;
		//
		// }
		int ans = 0;

		for (int i = 0; i < 10; i++) {
			ans += dp[n][i];
		}

		System.out.println(ans % mod);

	}

}
