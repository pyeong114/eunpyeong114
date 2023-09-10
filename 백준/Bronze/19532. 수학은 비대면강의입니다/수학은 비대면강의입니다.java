import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int cnt;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		double a = sc.nextInt();
		double b = sc.nextInt();
		double c = sc.nextInt();
		double d = sc.nextInt();
		double e = sc.nextInt();
		double f = sc.nextInt();
		int x = 0;
		int y = 0;
		out: for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				if ((a * i + b * j == c) && (d * i + e * j == f)) {
					x = i;
					y = j;
					break out;
				}
			}
		}

		System.out.println(x + " " + y);
	}
}
