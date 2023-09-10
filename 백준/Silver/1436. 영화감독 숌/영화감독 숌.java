import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int cnt;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int ans = 0;
		int num = 666;
		while (cnt < N) {
			if (Integer.toString(num++).contains("666")) {
				cnt++;
				ans = num;
			}
		}
		System.out.println(num-1);
	}
}
