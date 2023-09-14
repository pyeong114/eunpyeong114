import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		loof: for (int tc = 0; tc < N; tc++) {
			int[] ascii = new int[27];
			String input = br.readLine();
			for (int i = 0; i < input.length(); i++) {
				if (ascii[input.charAt(i) - 97] == 1) {
					continue loof;
				} else {
					ascii[input.charAt(i) - 97] = 1;
					if(i+1<input.length()) {
						while (input.charAt(i) == input.charAt(i + 1)) {
							i++;
							if (i >= input.length()-1) {
								break;
							}
						}
					}

				}

			}
			ans++;
		}
		bw.write(Integer.toString(ans));
		bw.flush();
	}
}
