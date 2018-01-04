package NewProblem;

import java.util.Scanner;

public class Bj11052dp {

	public static int[] fishBread;
	public static int[] dp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		fishBread = new int[n + 1];
		dp = new int[n + 1];
		dp[1] = 1;

		for (int i = 1; i < n + 1; i++) {
			fishBread[i] = in.nextInt();
		}

		
		//수정하게되면 안에 로직은
		// dp[i] = Math.max(dp[i],dp[i-j]+fishBread[j];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (i - j >= 0) {

					if (dp[i] <= dp[i - j] + fishBread[j]) {
						dp[i] = dp[i - j] + fishBread[j];
					}

				}
			}

		}

		System.out.println(dp[n]);

	}

}
