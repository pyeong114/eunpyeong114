import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}
		bw.write("<");
		while (deque.size() != 0) {
			if (deque.size() == 1) {
				bw.write(Integer.toString(deque.peek()) + ">");
				break;
			}
			for (int i = 1; i <= K; i++) {
				if (i != K) {
					deque.addLast(deque.pollFirst());
				} else {
					bw.write(deque.pollFirst() + ", ");
				}
			}
		}

		bw.flush();
	}
}