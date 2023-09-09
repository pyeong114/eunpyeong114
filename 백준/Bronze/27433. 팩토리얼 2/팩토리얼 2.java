import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long ans = 1;
		for (int i = 2; i <= N; i++) {
			ans *= i;
		}
		System.out.println(ans);
	}
}
