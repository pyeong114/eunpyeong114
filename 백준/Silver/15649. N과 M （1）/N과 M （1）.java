import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static int[] arr;
	public static int N;
	public static int M;
	public static int[] result;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		String[] input = s.split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		result = new int[M];
		perm(0, 0);
		bw.flush();

	}

	public static void perm(int idx, int visited) throws IOException {
		if (idx == M) {
			for (int n : result) {
				bw.write(Integer.toString(n)+" ");
			}
			bw.newLine();
			
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((visited & (1 << i)) > 0) {
				continue;
			}
			result[idx] = arr[i];
			perm(idx + 1, visited | (1 << i));
		}
	}
}