package NewProblem;

/**
 * 
 *
 * 백준 1890점프
 * 
 * 동적계획
 *
 */
import java.util.Scanner;

public class Bj1890dp {

	public static int n;
	public static long[][] dp;
	public static int[][] map;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		dp = new long[n][n];
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
			}
		}
		solve();

		System.out.println(dp[n - 1][n - 1]);
	}

	public static boolean isRange(int nx) {
		return nx < n && nx >= 0;
	}

	public static void solve() {
		dp[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (map[i][j] == 0) {
					continue;
				}

				int jump = map[i][j];
				int down = i + map[i][j];
				int right = j + map[i][j];

				if (isRange(down)) {
					dp[down][j] += dp[i][j];
				}

				if (isRange(right)) {
					dp[i][right] += dp[i][j];
				}

			}
		}

	}
}
