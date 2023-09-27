import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean[][] visited;
	public static List<Integer>[] adjList;
	public static List<Integer> ans = new ArrayList<>();
	public static int B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 지도의 크기
		int N = sc.nextInt();

		// 지도
		String[][] map = new String[N][N];

		// 지도에 값 할당
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().split("");
		}

		visited = new boolean[N][N];

		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		// BFS
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				// 방문체크 이미 된 경우 넘어가기
				if (visited[i][j] || map[i][j].equals("0"))
					continue;

				int cnt = 0;

				Queue<int[]> queue = new LinkedList<>();
				queue.add(new int[] { i, j });

				cnt++;
				String num = map[i][j];
				visited[i][j] = true;

				while (!queue.isEmpty()) {
					int[] poll = queue.poll();
					int r = poll[0];
					int c = poll[1];
					for (int k = 0; k < 4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if (nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;

						if (!visited[nr][nc] && map[nr][nc].equals(num)) {
							cnt++;
							queue.add(new int[] { nr, nc });
							visited[nr][nc] = true;
						}
					}
				}
				ans.add(cnt);
			}
		}

		Collections.sort(ans);
		System.out.println(ans.size());
		for (int i : ans) {
			System.out.println(i);
		}

	}
}