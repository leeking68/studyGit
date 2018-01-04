package NewProblem;
/**
 * 
 * 9095번 1,2,3조합하기 
 * 
 */
import java.util.Scanner;

public class boj9095dp2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] dp = new int[11];
		int T = in.nextInt();

		dp[0] = 1;

		for (int i = 1; i <= 10; i++) {

			for (int j = 1; j <= 3; j++) {
				if(i - j >= 0) {
					dp[i] += dp[i-j];
				}
			}

		}
		
		for(int test_case = 0; test_case < T; test_case++) {
			
			int n = in.nextInt();
			
			System.out.println(dp[n]);
			
		}

	}

}
