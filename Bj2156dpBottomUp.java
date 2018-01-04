package NewProblem;
/**
 * 
 * 백준 2156 포주 마시기
 *
 * dp 
 * 
 */

import java.util.Scanner;

public class Bj2156dpBottomUp {

	public static int n;
	public static int[] a;
	public static int[][] d;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		d = new int[n + 1][3];
		a = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			a[i] = in.nextInt();
		}
		
		d[1][0] = 0;
		d[1][1] = a[1];
		d[1][2] = a[1];
		d[2][0] = a[1];
		d[2][1] = a[2];
		d[2][2] = a[1] + a[2];
		
		
		for (int i = 3; i <= n; i++) {
			
			d[i][0] += Math.max(d[i-1][0],Math.max(d[i-1][1], d[i-1][2]));
			d[i][1] += Math.max(d[i-2][0],Math.max(d[i-2][1], d[i-2][2])) + a[i];
			d[i][2] += Math.max(d[i-3][0], Math.max(d[i-3][1], d[i-3][2])) + a[i] + a[i-1];
			
		}
		
		System.out.println(Math.max(d[n][0], Math.max(d[n][1], d[n][2])));
	}

}
