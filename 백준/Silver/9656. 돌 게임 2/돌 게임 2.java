import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				dp[i] = 0;
			} else if (i == 2) {
				dp[i] = 1;
			} else if (i == 3) {
				dp[i] = 0;
			} else {
				if (dp[i - 1] == 0 | dp[i - 3] == 0) {
					dp[i] = 1;
				} else if (dp[i - 1] == 1 && dp[i - 3] == 1) {
					dp[i] = 0;
				}
			}
		}
		if (dp[N] == 1) {
			System.out.println("SK");
		} else {
			System.out.println("CY");
		}
	}
}