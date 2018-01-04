package NewProblem;

/**
 * 
 * 
 * 백준 2579 계단오르기
 * 
 *  동적계획
 * 
 *
 */
import java.util.Scanner;

public class Bj2579do {

	public static int n;
	public static int[] A;
	public static int[][] dp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		A = new int[n + 1];
		dp = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			A[i] = in.nextInt();
		}
		dp[0][1] = 0;
		dp[0][2] = 0;
		dp[1][1] = A[1];
		
		for(int i = 2; i <=n; i++) {
			dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + A[i];
			dp[i][2] = dp[i-1][1] + A[i];
		}
		
		System.out.println(Math.max(dp[n][1], dp[n][2]));
		
	}

}
