
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int K;
	public static int[] S;
	public static int[] lotto;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while(true) {
			K = sc.nextInt();
			if (K == 0) {
				break;
			}
			S = new int[K];
			lotto = new int[6];
			for (int i = 0; i < K; i++) {
				S[i] = sc.nextInt();
			}
			
			combination(0,0);
			System.out.println();
		}
	}

	public static void combination(int idx, int sidx) {
		if (sidx == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}
		if (idx == K) {
			return;
		}
		
		lotto[sidx] = S[idx];
		combination(idx+1,sidx+1);
		combination(idx+1,sidx);
	}
}
