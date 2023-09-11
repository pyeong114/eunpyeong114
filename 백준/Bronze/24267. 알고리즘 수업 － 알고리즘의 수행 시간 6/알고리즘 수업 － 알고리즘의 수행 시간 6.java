import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long ans = N * (N - 2)*(N-1)/6;
		System.out.println(ans);
		System.out.println(3);
	}
}
