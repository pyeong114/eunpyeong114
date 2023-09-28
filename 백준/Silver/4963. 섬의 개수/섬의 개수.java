import java.util.Scanner;

public class Main {
	public static int w, h;
	public static boolean[][] visited;
	public static int[][] map;
	public static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	public static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0) {
				break;
			}

			visited = new boolean[h][w];

			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (visited[i][j] || map[i][j] == 0)
						continue;
					dfs(i, j);
					cnt++;

				}
			}
			System.out.println(cnt);

		}
	}

	public static void dfs(int x, int y) {
		if (visited[x][y])
			return;

		visited[x][y] = true;
		for (int i = 0; i < 8; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			if (nr < 0 || nc < 0 || nr >= h || nc >= w)
				continue;
			if (!visited[nr][nc] && map[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}