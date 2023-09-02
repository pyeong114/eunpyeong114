
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] input = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			input[i] = sc.nextInt();
			if (i == 1) {
				dp[i] = input[i];
			} else if (i == 2) {
				dp[i] = dp[i - 1] + input[i];
			} else if (i == 3) {
				dp[i] = Math.max(input[i - 1] + input[i], Math.max(dp[i - 1], dp[i - 2] + input[i]));
			} else {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + input[i - 1] + input[i], dp[i - 2] + input[i]));
			}
		}
		System.out.println(dp[N]);
	}
}