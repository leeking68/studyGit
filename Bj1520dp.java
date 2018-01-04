package NewProblem;

/**
 * 
 * 백준 1520 내리막길 
 * 
 * 동적계획
 *
 */
import java.util.Scanner;

public class Bj1520dp {

	public static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };
	public static int n,m;
	public static int[][] d, map;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();

		map = new int[n][m];
		d = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = in.nextInt();
			}
		}

		System.out.println(solve(0, 0));


	}

	public static int solve(int x, int y) {

		if (x == n - 1 && y == m - 1) {
			return 1;
		}

		if (d[x][y] > 0) {
			return d[x][y];
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isRange(nx, ny))
				if (map[x][y] > map[nx][ny]) {
					d[x][y] += solve(nx, ny);
				}
		}

		return d[x][y];

	}

	public static boolean isRange(int x, int y) {
		return x < n && x >= 0 && y < m && y >= 0;
	}

}
