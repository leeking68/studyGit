package NewProblem;

/**
 * 
 * 백준 5557 1학년
 *
 * 동적계획
 * 
 */
import java.util.Scanner;

public class Bj5557dp {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] A = new int[n];
		int[][] d = new int[n][21];

		for (int i = 0; i < n; i++) {
			A[i] = in.nextInt();
		}


		d[0][A[0]] = 1;

		for (int i = 1; i < n-1; i++) {
			for (int j = 0; j <= 20; j++) {

				if (j - A[i] >= 0&&j-A[i]<20) {
					d[i][j] += d[i - 1][j - A[i]];
				}
				if (j+A[i]>=0&&j + A[i] <= 20) {
					d[i][j] += d[i - 1][j + A[i]];
				}

			}

		}

		int ans = d[n - 2][A[n-1]];

		System.out.println("check dynamic  ");
		System.out.println(ans);

	}

}
