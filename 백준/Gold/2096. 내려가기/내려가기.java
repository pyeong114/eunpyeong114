import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] maxDp = new int[N][3];
		int[][] minDp = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				int input = sc.nextInt();
				if (i == 0) {
					maxDp[i][j] = input;
					minDp[i][j] = input;
				} else if (j == 0) {
					maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1])+input;
					minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j + 1])+input;
				} else if (j == 1) {
					maxDp[i][j] = Math.max(maxDp[i - 1][j - 1], Math.max(maxDp[i - 1][j], maxDp[i - 1][j + 1]))+input;
					minDp[i][j] = Math.min(minDp[i - 1][j - 1], Math.min(minDp[i - 1][j], minDp[i - 1][j + 1]))+input;
				} else if (j == 2) {
					maxDp[i][j] = Math.max(maxDp[i - 1][j], maxDp[i - 1][j - 1])+input;
					minDp[i][j] = Math.min(minDp[i - 1][j], minDp[i - 1][j - 1])+input;
				}
			}
		}
		System.out.printf("%d %d", Math.max(Math.max(maxDp[N - 1][0], maxDp[N - 1][1]), maxDp[N - 1][2]),
				Math.min(Math.min(minDp[N - 1][0], minDp[N - 1][1]), minDp[N - 1][2]));
	}
}