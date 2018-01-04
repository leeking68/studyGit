package NewProblem;

/**
 * 
 * 백준 2156 포도주 시식
 * 
 * dp TopDown
 * 
 *
 */
import java.util.Scanner;

public class Bj2156dpTopdown {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int test_case = 0; test_case < t; test_case++) {

			int n = in.nextInt();
			int[] dp = new int[n + 1];
			int[] wine = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				wine[i] = in.nextInt();
			}
			
			System.out.println(solve(wine,dp,n));

		}
	}

	public static int solve(int[] wine, int[] dp, int n) {
		if (n == 0) {

		} else if (n == 1) {

		} else if (n == 2) {

		}

		if (dp[n] > 0) {
			return dp[n];
		}

		dp[n] = Math.max(solve(wine, dp, n - 1), Math.max(solve(wine, dp, n - 3), solve(wine, dp, n - 2)));

		return dp[n];
	}

}
