package NewProblem;
/**
 * 
 *  백준 2294 동전 2 
 *  
 *  동적계획법
 *
 */ 
import java.util.Scanner;
public class Bj2294dp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] arr = new int[n];
		int[] d = new int[k+1];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		
		for(int i = 0; i <= k; i++) {
			d[i] = -1;
		}
		d[0] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <= k; j++) {
				if(j-arr[i]>0&&d[j-arr[i]]!=-1) {
					if(d[j]!=-1 || d[i] > d[j-arr[i]]+1) {
						
					}
				}
			}
		}
	}

}
