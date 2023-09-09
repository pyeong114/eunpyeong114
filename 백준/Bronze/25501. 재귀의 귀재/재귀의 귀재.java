import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int cnt;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String input = sc.next();
			cnt = 0;
			int result = isPalindrome(input, 0, input.length() - 1);
			System.out.println(result + " " + cnt);
		}
	}

	public static int isPalindrome(String str, int st, int ed) {
		if (st >= ed) {
			cnt++;
			return 1;
		}
		if (str.charAt(st) == str.charAt(ed)) {
			cnt++;
			return isPalindrome(str, st + 1, ed - 1);
		} else {
			cnt++;
			return 0;
		}
	}

}
