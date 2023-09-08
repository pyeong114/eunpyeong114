import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		int[] queue = new int[N];
		int st = 0;
		int ed = -1;
		for (int i = 0; i < N; i++) {
			String str[] = br.readLine().split(" ");
			if (str[0].equals("push")) {
				int num = Integer.parseInt(str[1]);
				queue[++ed] = num;
			} else if (str[0].equals("pop")) {
				if (ed - st >= 0) {
					bw.write(Integer.toString(queue[st++]));
					bw.newLine();
				} else {
					bw.write("-1");
					bw.newLine();
				}
			} else if (str[0].equals("size")) {
				bw.write(Integer.toString(ed - st + 1));
				bw.newLine();
			} else if (str[0].equals("empty")) {
				if (ed - st == -1) {
					bw.write("1");
					bw.newLine();
				} else {
					bw.write(Integer.toString(0));
					bw.newLine();
				}
			} else if (str[0].equals("front")) {
				if (ed - st >= 0) {
					bw.write(Integer.toString(queue[st]));
					bw.newLine();
				} else {
					bw.write("-1");
					bw.newLine();
				}
			} else {
				if (ed - st >= 0) {
					bw.write(Integer.toString(queue[ed]));
					bw.newLine();
				} else {
					bw.write("-1");
					bw.newLine();
				}
			}
		}
		bw.flush();
	}
}