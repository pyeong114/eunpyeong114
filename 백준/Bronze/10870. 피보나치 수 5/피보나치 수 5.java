import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(fib(N));
	}

	public static int fib(int i) {
		if (i == 0) {
			return 0;
		} else if (i <= 2) {
			return 1;
		} else {
			return fib(i - 1) + fib(i - 2);
		}
	}
}
