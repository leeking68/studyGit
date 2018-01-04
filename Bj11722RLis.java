package NewProblem;
/**
 * 가장 긴 감소하는 부분 수열 
 * 
 * 백준 11722 lis
 * 
 * 
 */
import java.util.Scanner;
public class Bj11722RLis {

	public static int n,max=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		
		int dp[] = new int[n+1];
		int A[] = new int[n+1];
		
		for(int i = 1; i <=n; i++) {
			A[i] = in.nextInt();
		}
		
		for(int i = n; i >0; i--) {
			dp[i] = 1;
			for(int j = n; j >i; j--) {
				if(A[i] > A[j]&&dp[i] < dp[j]+1) {
					dp[i] = dp[j]+1;
				}
				if(max < dp[i]) {
					max = dp[i];
				}
			}
		}
		
		System.out.println(max);
		
	
	}

}
