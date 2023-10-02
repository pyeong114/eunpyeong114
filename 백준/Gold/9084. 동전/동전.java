import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 동전의 가짓수
			int n = sc.nextInt();
			// 동전 담을 배열
			int[] coin = new int[n + 1];

			for (int i = 1; i < coin.length; i++) {
				coin[i] = sc.nextInt();
			}

			// 바꿀 금액
			int m = sc.nextInt();

			int[][] dp = new int[n + 1][m + 1];

			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < m + 1; j++) {
					// 동전 금액과 바꿀 금액이 동일한 경우
					if (coin[i] == j) {
						// 이전의 dp값에 +1 추가
						dp[i][j] = dp[i - 1][j] + 1;
						// 동전 금액 이상인 경우
					} else if (coin[i] < j) {
						dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i]];
						// 동전 금액 이하인 경우
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
			System.out.println(dp[n][m]);
		}
	}
}