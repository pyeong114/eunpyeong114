import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i == 1)
				dp[i] = -1;
			if (i == 2)
				dp[i] = 1;
			if (i == 3)
				dp[i] = -1;
			if (i == 4)
				dp[i] = 2;

			if (i >= 5) {
				if (dp[i - 5] == -1 && dp[i - 2] == -1) {
					dp[i] = -1;
				} else if (dp[i - 5] == -1) {
					dp[i] = dp[i - 2] + 1;
				} else if (dp[i - 2] == -1) {
					dp[i] = dp[i - 5] + 1;
				} else {
					dp[i] = Math.min(dp[i - 2] + 1, dp[i - 5] + 1);
				}
			}
		}
		System.out.println(dp[n]);
	}
}