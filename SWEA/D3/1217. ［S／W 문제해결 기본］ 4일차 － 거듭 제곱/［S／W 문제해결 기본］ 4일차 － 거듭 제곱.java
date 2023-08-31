
import java.util.Scanner;

public class Solution {
	public static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			num = new int[M + 1];
			pow(N, M, 1);
			System.out.printf("#%d %d\n", tc, num[M]);
		}
	}

	public static void pow(int N, int M, int idx) {
		if (idx == 1) {
			num[idx] = N;
		} else {
			num[idx] = N * num[idx - 1];
			if (idx == M) {
				return;
			}
		}
		pow(N, M, ++idx);
	}
}
