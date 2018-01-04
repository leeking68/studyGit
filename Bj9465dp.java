package NewProblem;

/**
 * 
 * 백준 9465 스티커 
 * 
 * 동적계획
 * 
 * 
 */
import java.util.Scanner;

public class Bj9465dp {

	public static int n;
	public static long[][] dp, a;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		n = in.nextInt();

		for (int test_case = 0; test_case < t; test_case++) {

			a = new long[2][n+1];
			dp = new long[n + 1][4];

			for (int i = 0; i <= 1; i++) {
				for (int j = 1; j <= n; j++) {
					a[i][j] = in.nextInt();
				}
			}
			
			for(int i = 1; i <=n; i++) {
				
			    dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
                dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2])+a[0][i];
                dp[i][2] = Math.max(dp[i-1][0],dp[i-1][1])+a[1][i];
				
			}
			
			long ans = Math.max(Math.max(dp[n][1], dp[n][2]), dp[n][0]);
		
			System.out.println(ans);

		}
	}

}
