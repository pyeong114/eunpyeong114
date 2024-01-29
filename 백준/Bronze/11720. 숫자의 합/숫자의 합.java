
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String[] Num =sc.next().split("");
		int ans = 0;

		for (int i = 0; i < N; i++) {
			ans += Integer.parseInt(Num[i]);
		}
		System.out.println(ans);
	}

}