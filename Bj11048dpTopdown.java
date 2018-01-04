package NewProblem;
/**
 * 
 * 백준 11048 탑다
 *
 */
import java.util.Scanner;
public class Bj11048dpTopdown {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] arr = new int[n+1][m+1];
		int[][] dp = new int[n+1][m+1];
		
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=m; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		System.out.println(solve(arr,dp,n,m));
		
	}
	
	public static int solve(int[][] arr,int[][] dp, int n, int m) {
		if(n==1&&m==1) {
			return arr[1][1];
		}
		if(n<1||m<1) {
			return 0;
		}
		if(dp[n][m]>0) {
			return dp[n][m];
		}
		
		dp[n][m] = solve(arr,dp,n-1,m) + arr[n][m];
		int temp = solve(arr,dp,n,m-1) + arr[n][m];
		
		if(dp[n][m] < temp) {
			dp[n][m] = temp;
		}
		
		return dp[n][m];
		
	}

}
