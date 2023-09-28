import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean[][] visited;
	public static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N][M];
		int max = Integer.MIN_VALUE;
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					flag = true;
				}
			}
		}
		if (!flag) {
			System.out.println(0);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					continue;

				boolean[][] visited = new boolean[N][M];
				int[][] cnt = new int[N][M];
				Queue<int[]> queue = new LinkedList<>();
				queue.add(new int[] { i, j });
				visited[i][j] = true;
				loof: while (!queue.isEmpty()) {
					int[] poll = queue.poll();
					int r = poll[0];
					int c = poll[1];
					for (int k = 0; k < 8; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc])
							continue;


						visited[nr][nc] = true;
						cnt[nr][nc] = cnt[r][c] + 1;
						queue.add(new int[] { nr, nc });
						max = Math.max(max, cnt[nr][nc]);
						
						if (map[nr][nc] == 1) {
							break loof;
						}
					}
				}
			}

		}
		if (max == Integer.MIN_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(max);
		}
	}
}