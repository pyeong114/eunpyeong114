import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int N;
	public static int M;
	public static int[] num;
	public static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		for (int i = 0; i < num.length; i++) {
			num[i] = i + 1;
		}

		sel = new int[M];
		combination(0, 0);
	}

	public static void combination(int idx, int sidx) {
		if (sidx == M) {
			for(int i : sel) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}

		if (idx == N) {
			return;
		}

		sel[sidx] = num[idx];
		combination(idx + 1, sidx + 1);
		combination(idx + 1, sidx);

	}
}