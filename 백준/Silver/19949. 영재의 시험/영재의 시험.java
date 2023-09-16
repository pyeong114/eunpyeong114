import java.util.Scanner;

public class Main {
	public static int[] answers = new int[10];
	public static int[] myInput = new int[10];
	public static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			answers[i] = sc.nextInt();
		}
		
		randomAnswer(0);
		System.out.println(ans);

	}

	public static void randomAnswer(int i) {
		if (i >= 10) {
			int cnt = 0;
			for (int j = 0; j < 10; j++) {
				if (myInput[j] == answers[j]) {
					cnt++;
					if (cnt >= 5) {
						ans++;
						return;
					}
				}
			}
			return;
		}

		for (int j = 1; j <= 5; j++) {
			myInput[i] = j;
			if (i >= 2 && myInput[i - 2] == myInput[i - 1] && myInput[i - 1] == myInput[i]) {
				continue;
			}
			randomAnswer(i + 1);
		}
	}
}