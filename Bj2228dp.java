package NewProblem;

/**
 *
 * 백준 2228 구간 나누기 
 * 
 * 동적계획
 *
 */
import java.util.Scanner;

public class Bj2228dp {
	
	public static int m;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		m = in.nextInt();

		int[] arr = new int[n+1];
		int[] sum = new int[n+1];
		for (int i = 1; i <=n; i++) {
			arr[i] = in.nextInt();
			sum[i] = sum[i-1] + arr[i];
		}

		int[][] d = new int[n+1][m+1];
		boolean[][] check = new boolean[n+1][m+1];
		
		
		System.out.println(sovle(arr, d,check, 0, n - 1, m));
	}

	public static int sovle(int[] arr,int[][] d,boolean[][] check, int i, int j,int k) {
		
		if(k == m) {
			return 0;
		}
		
		if(check[i][j]) {
			return d[i][j];
		}
		
		int ans = 0; 
		check[i][j] = true;
		for(int h = i; h <j-1; h++) {
			int temp = sovle(arr,d,i,h,k+1) + sovle(arr,d,h+1,j,k+1);
		}
	}

}
