import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[] dp = new long[N + 1];

		for (int i = 0; i < dp.length; i++) {
			if (i <= 1) {
				dp[i] = 1;
			} else {
				for (int j = 0; j < i; j++) {
					dp[i] += dp[j] * dp[i - 1 - j];
				}
			}
		}
		System.out.println(dp[N]);
	}
}
