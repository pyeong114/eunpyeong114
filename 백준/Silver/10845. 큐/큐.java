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

		List<String> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int st = -1;
		int ed = -1;
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			if (input[0].equals("push")) {
				list.add(input[1]);
				ed++;
			} else if(input[0].equals("pop")) {
				if(st<ed) {
					st++;
					bw.write(list.get(st));
					bw.newLine();
				}  else {
					bw.write("-1");
					bw.newLine();
				}
			} else if(input[0].equals("size")) {
				bw.write(Integer.toString(ed-st));
				bw.newLine();
			} else if(input[0].equals("empty")) {
				if(ed-st==0) {
					bw.write("1");
					bw.newLine();
				} else {
					bw.write("0");
					bw.newLine();
				}
			} else if(input[0].equals("front")) {
				if(ed>st) {
					bw.write(list.get(st+1));
					bw.newLine();
				} else {
					bw.write("-1");
					bw.newLine();
				}
			} else if(input[0].equals("back")) {
				if(ed>st) {
					bw.write(list.get(ed));
					bw.newLine();
				} else {
					bw.write("-1");
					bw.newLine();
				}
			}
			bw.flush();
		}
	}
}