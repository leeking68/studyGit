package NewProblem;

/**
 * 
 * 백준 2293 동전 1 
 * 
 * 동전계획
 * 
 */
import java.util.Scanner;

public class Bj2293dp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		int[] d = new int[k + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		d[0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				if (j - arr[i] >= 0) {
					d[j] += d[j - arr[i]];
				}
			}
		}

		System.out.println(d[k]);
	}

}
