package NewProblem;

/**
 * 
 * @author gilho
 * 
 * 백준 1495 기타리스트
 * 
 * 동적계획
 *
 */
import java.util.Scanner;

public class Bj1495dp {

	public static int n, m;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		int s = in.nextInt();
		m = in.nextInt();

		int[] v = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			v[i] = in.nextInt();
		}

		int[][] d = new int[n + 1][m + 1];

		if (s - v[1] >= 0) {
			d[1][s - v[1]] = 1;
		}

		if (s + v[1] <= m) {
			d[1][s + v[1]] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (d[i - 1][j] == 1) {
					if (j - v[i] >= 0) {
						d[i][j - v[i]] = 1;
					}

					if (j + v[i] <= m) {
						d[i][j + v[i]] = 1;
					}
				}
			}
		}
		int ans = 0;

		for (int i = 0; i <= m; i++) {
			if (d[n][i] == 1) {
				if (ans < i) {
					ans = i;
				}
			}
		}

		System.out.println(ans);
	}

}
