import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		String[] dataStr = br.readLine().split(" ");

		String[] queueStack = br.readLine().split(" ");

		int M = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		List<String> ans = new ArrayList<>();
		for (int i = N - 1; i >= 0; i--) {
			if (dataStr[i].equals("0")) {
				ans.add(queueStack[i]);
			}
			if (ans.size() == M) {
				break;
			}
		}
		int size = ans.size();
		for (int i = 0; i < M - size; i++) {
			ans.add(input[i]);
		}
		for (int i = 0; i < M; i++) {
			bw.write(ans.get(i) + " ");
		}
		bw.flush();
	}
}

