import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static class Node {
		int r;
		int c;
		int dep;

		public Node(int r, int c, int dep) {
			this.r = r;
			this.c = c;
			this.dep = dep;
		}

	}

	public static String[][] maze;
	public static boolean[][] visited;
	public static int N;
	public static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 방의 수
		N = sc.nextInt();
		maze = new String[N][N];

		for (int i = 0; i < N; i++) {
			maze[i] = sc.next().split("");
		}

		Node node = new Node(0, 0, 0);
		bfs(node);

		System.out.println(min);
	}

	public static void bfs(Node node) {
		visited = new boolean[N][N];

		Deque<Node> deque = new LinkedList<>();
		deque.add(node);
		int r = node.r;
		int c = node.c;
		int dep = node.dep;
		visited[r][c] = true;

		while (!deque.isEmpty()) {
			Node poll = deque.poll();
			int pr = poll.r;
			int pc = poll.c;
			int pdep = poll.dep;

			if (pr == N - 1 && pc == N - 1) {
				min = Math.min(min, pdep);
			}

			int[] dr = { 0, 1, 0, -1 };
			int[] dc = { 1, 0, -1, 0 };

			for (int i = 0; i < 4; i++) {
				int nr = pr + dr[i];
				int nc = pc + dc[i];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;

				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					if (maze[nr][nc].equals("1")) {
						deque.addFirst(new Node(nr, nc, pdep));
					} else {
						deque.addLast(new Node(nr, nc, pdep + 1));
					}
				}
			}
		}
	}
}