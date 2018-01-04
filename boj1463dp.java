package NewProblem;

/**
 * 
 *  
 *   백준 1463 1로만들
 *
 */
import java.util.Scanner;

public class boj1463dp {

	public static int dp[];

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		dp = new int[n + 1];
		
		cal(n);
		
		System.out.println(dp[n]);
	}

	public static int cal(int n) {
		if (n == 1)
			return 0;
		if (dp[n] > 0)
			return dp[n];

		dp[n] = cal(n - 1) + 1;

		if (n % 2 == 0) {

			int temp = cal(n / 2) + 1;

			if (dp[n] > temp) {
				dp[n] = temp;
			}

		}

		if (n % 3 == 0) {

			int temp = cal(n / 3) + 1;

			if (dp[n] > temp) {
				dp[n] = temp;
			}

		}

		return dp[n];

	}

}
