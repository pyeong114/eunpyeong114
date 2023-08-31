
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] triangle = new int[N + 1][N + 1];

		for (int i = 1; i < triangle.length; i++) {
			for (int j = 1; j <= i; j++) {
				triangle[i][j] = sc.nextInt();
			}
		}
		int[][] dp = new int[N + 1][N + 1];

		for (int i = triangle.length - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				if (i == triangle.length - 1) {
					dp[i][j] = triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
				}
			}
		}
		System.out.println(dp[1][1]);
	}
}