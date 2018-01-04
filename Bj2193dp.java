package NewProblem;
/**
 * 
 * 백준 2193 이친수 
 *
 * 동적계획
 *
 */
import java.util.Scanner;
public class Bj2193dp {

	public static long dp[][];
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		dp = new long[n+1][2];
		//dp = new long[n+1];
		
		dp[1][1] = 1;
		dp[1][0] = 0;
		//dp[1] = 1 , dp[0] = 0;
		
		for(int i = 2; i <= n; i++) {
			
			dp[i][1] += dp[i-2][0] + dp[i-2][1];
			dp[i][0] += dp[i-1][0] + dp[i-1][1];
			//dp[i] = dp[i-1] + dp[i-2];
			
		}
		
		long ans = dp[n][0] + dp[n][1];
		//없음 
		
		System.out.println(ans);
		
	}
	

}
