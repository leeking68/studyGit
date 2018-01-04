package NewProblem;

/**
 * 
 * @author gilho
 *
 */
import java.util.Scanner;

public class Bj1563dp {

	// 0 출석 1 결석 2 지각
	public static int mod = 1000000;

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[][][][][] d = new int[n + 1][3][3][3][2];

		for (int now = 0; now < 3; now++) {
			for (int prev = 0; prev < 3; prev++) {
				for (int prev2 = 0; prev2 < 3; prev2++) {

					// 결석 3번 ㄴ
					if (now == prev && prev == prev2 && prev2 == 1) {
						continue;
					}

					// 지각 2번 ㄴ
					if ((now == 2 && prev == 2) || (now == 2 && prev == 2) || (prev == 2 && prev2 == 2)) {
						continue;
					}

					if (now == 2 || prev == 2 || prev2 == 2) {
						d[3][now][prev][prev2][1] = 1;
					} else {
						d[3][now][prev][prev2][0] = 1;

					}

				}
			}
		}

		for (int i = 4; i <= n; i++) {
			for (int prev = 0; prev < 3; prev++) {
				for (int prev2 = 0; prev2 < 3; prev2++) {
					for (int prev3 = 0; prev3 < 3; prev3++) {

						// 출석
						d[i][0][prev][prev2][0] += d[i - 1][prev][prev2][prev3][0];
						d[i][0][prev][prev2][0] %= mod;
						d[i][0][prev][prev2][1] += d[i - 1][prev][prev2][prev3][1];
						d[i][0][prev][prev2][1] %= mod;

						// 결석
						if (prev == 1 && prev2 == 1) {

						} else {
							d[i][1][prev][prev2][0] += d[i - 1][prev][prev2][prev3][0];
							d[i][1][prev][prev2][0] %= mod;
							d[i][1][prev][prev2][1] += d[i - 1][prev][prev2][prev3][1];
							d[i][1][prev][prev2][1] %= mod;
						}

						// 지각
						d[i][2][prev][prev2][1] += d[i - 1][prev][prev2][prev3][0];
						d[i][2][prev][prev2][1] %= mod;

					}
				}
			}
		}

		int ans = 0;
		for (int now = 0; now < 3; now++) {
			for (int prev = 0; prev < 3; prev++) {
				for (int prev2 = 0; prev2 < 3; prev2++) {
					for(int late = 0; late < 2; late++) {
						ans += d[n][now][prev][prev2][late];
					}
				}
			}
		}
		
		ans%=mod;
		
		System.out.println(ans);
	}

}
