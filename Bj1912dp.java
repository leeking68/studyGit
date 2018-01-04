package NewProblem;
/**
 * 
 * 백준 1912 연속합 
 * 
 * 동적계획
 *
 *
 */
import java.util.Scanner;
public class Bj1912dp {

	public static int max = 0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = in.nextInt();
		}
		
		int[] dp = new int[n+1];
		
		for(int i = 1; i <=n; i++) {
			
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
				
		}
		
		max = dp[1];
		//전체가 음수라면 답이 0밖에 나올수가 없는 경우를 방지하는 것이다. 
		
		//이러한 경우가 대부분 맞더라 ~ 
		for(int i = 1; i <=n; i++) {
			
			if(dp[i] > max) {
				max = dp[i];
			}
			
		}
		
		System.out.println(max);
	}

}


