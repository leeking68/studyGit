package NewProblem;
/**
 * 
 * 
 * 백준 9095 1,2,3 더하기
 * 
 * 동적계획
 * 
 * 
 */
import java.util.Scanner;
public class Boj9095dp {

	public static int[] dp = new int[12];
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int t = in.nextInt();
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i < t; i++) {
			
			int n = in.nextInt();
			
			sb.append(String.valueOf(makeNum(n)));
			sb.append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	
	public static int makeNum(int num) {
		
		if(dp[num] > 0) {
			return dp[num];
		}
		
		
		dp[num] = makeNum(num-1) + makeNum(num-2) + makeNum(num-3);
		
		return dp[num];
		
	}

}
