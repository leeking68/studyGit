package NewProblem;

/**
 * 
 * 백준 11048 이동하기
 * 
 * 동적계획
 *
 * 
 */
import java.util.Scanner;

public class Bj11048dp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] = in.nextInt();
			}
		}


		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
			// 두가지 풀이 
				dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i][j - 1]))+arr[i][j];
//				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + arr[i][j];
			}
		}
		
		System.out.println(dp[n][m]);
	}

}
