import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static String[][] arr;
	public static int length;
	public static int N;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		length = N * 4 - 3;
		arr = new String[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				arr[i][j] = " ";
			}
		}
		star(0, length);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

	public static void star(int M, int length) {
		if (length <= M) {
			return;
		}

		for (int i = M; i < length; i++) {
			arr[M][i] = "*";
			arr[length - 1][i] = "*";
			arr[i][M] = "*";
			arr[i][length - 1] = "*";
		}

		star(M + 2, length - 2);
	}
}