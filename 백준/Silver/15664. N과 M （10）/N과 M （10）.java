import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static int N;
	public static int M;
	public static int[] nums;
	public static boolean[] visited;
	public static int[] result;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		nums = new int[N];
		result = new int[M];
		visited = new boolean[N];
		String[] input2 = br.readLine().split(" ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(input2[i]);
		}
		Arrays.sort(nums);
		perm(0);
		bw.flush();
	}

	public static void perm(int idx) throws IOException {
		if (idx == M) {
			for (int i : result) {

				bw.write(Integer.toString(i) + " ");
			}
			bw.newLine();
			return;
		}
		boolean used[] = new boolean[10001];
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;

			if(idx>=1&&result[idx-1]>nums[i])
				continue;
			
			if (!visited[i] && !used[nums[i]]) {
				used[nums[i]] = true;
				result[idx] = nums[i];
				visited[i] = true;
				perm(idx + 1);
				visited[i] = false;
				
			}
		}
	}
}