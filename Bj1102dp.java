package NewProblem;

import java.util.*;

public class Bj1102dp {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		sc.nextLine();
		String str = sc.nextLine();
		int start = 0;
		// 켜져 있는 발전소 체크 
		for (int i = n - 1; i >= 0; i--) {
			start *= 2;
			if (str.charAt(i) == 'Y') {
				start += 1;
			}
		}
		int p = sc.nextInt();
		int[] d = new int[1 << n]; // n의 개수만큼 비트마스킹을 이용할 크기  
		Arrays.fill(d, -1);
		d[start] = 0;
		for (int i = 0; i < (1 << n); i++) {
			if (d[i] == -1)
				continue;
			for (int j = 0; j < n; j++) {
				// 켜져있는 발전소를 선택 
				if ((i & (1 << j)) != 0) {
					System.out.println("1. (=index)현재 켜져있는 발전소의 상태  : " + i);
					System.out.println("2. 현재 켜져있는 발전소 중 : " + j + "포함 유무 구문 :" + (i & (1 << j)));
					System.out.println(' ');
					
					for (int k = 0; k < n; k++) {
						// 꺼져있는 발전소를 선택 
						if ((i & (1 << k)) == 0) { 
							System.out.println("3. (=index)현재 켜져있는 발전소의 상태  : " + i);
							System.out.println("4. 현재 꺼져있는 발전소 중 : " + k + "포함 유무 구문 :" + (i & (1 << k)));
							System.out.println(' ');

							if (d[i | (1 << k)] == -1 || d[i | (1 << k)] > d[i] + a[j][k]) {
								System.out.println("5. (=index)현재 켜져있는 발전소의 상태  : " + i);
								System.out.println("6. 추가되는 발전소 : " + k + "체크  :" + (i | (1 << k)));
								System.out.println(' ');

								d[i | (1 << k)] = d[i] + a[j][k];
							}
						}
					}
				}
			}
		}
		int ans = -1;
		for (int i = 0; i < (1 << n); i++) {
			if (d[i] == -1) {
				continue;
			}
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					cnt += 1;
				}
			}
			if (cnt >= p) {
				if (ans == -1 || ans > d[i]) {
					ans = d[i];
				}
			}
		}
		System.out.println(ans);
	}
}