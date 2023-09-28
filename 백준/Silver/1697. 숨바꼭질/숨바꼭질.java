
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수빈 위치
		int N = sc.nextInt();
		// 동생 위치
		int K = sc.nextInt();

		int ans = 0;

		int[] count = new int[100001];
		boolean[] visited = new boolean[100001];
		// 동생 위치가 더 작을 때
		if (N > K) {
			ans = N - K;
			// 동생 위치가 더 클 때
		} else if (N < K) {
			Queue<Integer> queue = new LinkedList<>();
			queue.add(N);
			visited[N] = true;
			while (!queue.isEmpty()) {
				int poll = queue.poll();
				int a = poll - 1;
				int b = poll + 1;
				int c = 2 * poll;
				if (a >= 0 && a <= 100000 && !visited[a]) {
					queue.add(a);
					count[a] = count[poll] + 1;
					visited[a] = true;
				}
				if (b >= 0 && b <= 100000 && !visited[b]) {
					queue.add(b);
					count[b] = count[poll] + 1;
					visited[b] = true;
				}
				if (c >= 0 && c <= 100000 && !visited[c]) {
					queue.add(c);
					count[c] = count[poll] + 1;
					visited[c] = true;
				}
				if (a == K || b == K || c == K) {
					break;
				}
			}
			ans = count[K];
		}
		System.out.println(ans);
	}
}
