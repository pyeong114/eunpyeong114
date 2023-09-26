import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		Scanner sc = new Scanner(System.in);
		// 포켓몬 개수
		int N = Integer.parseInt(arr[0]);
		// 맞춰야하는 문제 개수
		int M = Integer.parseInt(arr[1]);

		Map<Integer, String> map = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			String poketmon = br.readLine();
			map.put(i, poketmon);
			map2.put(poketmon, i);
		}

		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			int ascii = input.charAt(0) - 0;
			int key = 0;
			if (ascii >= 48 && ascii <= 57) {
				key = Integer.parseInt(input);
				bw.write(map.get(key));
				bw.newLine();
			} else {
				bw.write(Integer.toString(map2.get(input)));
				bw.newLine();
			}
		}
		bw.flush();
	}
}