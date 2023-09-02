
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			long[] dp = new long[N + 1];
			for (int i = 1; i <= N; i++) {
				if (i <= 3) {
					dp[i] = 1;
				} else {
					dp[i] = dp[i - 2] + dp[i - 3];
				}
			}
			System.out.println(dp[N]);
		}
	}
}