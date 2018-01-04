package NewProblem;

/**
 * 백준 11049 행렬곱셈
 * 
 * 동적계획
 * 
 */
import java.util.Scanner;

public class Bj11049dp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		int[][] d = new int[n][n];

		System.out.println(solve(arr, d, 0, n - 1));
	}

	public static int solve(int[][] arr, int[][] d, int i, int j) {
		if(d[i][j] > 0 ) {
			return d[i][j];
		}
		if(i==j) {
			return 0;
		}
		if(i+1 == j ) {
			arr[i][0]*arr[i][1]*arr[j][1];
		}
		d[i][j] = -1;
		
		for(int k = i; k<j; k++) {
			int t1 = solve(arr,d,i,k);
			int t2 = solve(arr,d,k+1,j);
			int t3 = arr[i][0]*arr[k][1]*arr[j][1];
			if(d[i][j] != -1 || d[i][j] > t1+t2+t3) {
				d[i][j] = t1+t2+t3;
			}
		}
		
		return d[i][j];
		
		
	}

}
