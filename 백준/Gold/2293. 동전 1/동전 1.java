
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 동전의 종류
		int n = sc.nextInt();
		// 원하는 가치
		int k = sc.nextInt();
		// 동전 배열
		int[] coins = new int[n + 1];
		for (int i = 1; i < coins.length; i++) {
			coins[i] = sc.nextInt();
		}

		// dp
		long[][] dp = new long[n + 1][k + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < k + 1; j++) {
				if (j == coins[i]) {
					dp[i][j] = dp[i - 1][j] + 1;
				} else if (j < coins[i]) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}