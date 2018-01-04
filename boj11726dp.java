package NewProblem;

/**
 * 
 * 백준 11726  2*n 타일링
 *  
 * 동적계획
 *
 */
import java.util.Scanner;

public class boj11726dp {

	public static int n;
	public static int dp[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		dp = new int[n + 1];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i = 4; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		System.out.println(dp[n]);
	}

}
