
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N + 1];

		int[] dp = new int[N + 1];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < dp.length; i++) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				if (arr[i] > arr[j]) {
					if (max < dp[j] + 1) {
						max = dp[j] + 1;
					}
				}
			}
			dp[i] = max;
		}
		int ans = 0;
		for (int n : dp) {
			if (ans < n) {
				ans = n;
			}
		}
		System.out.println(ans + 1);
	}
}