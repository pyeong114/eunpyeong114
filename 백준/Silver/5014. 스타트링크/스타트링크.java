
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 건물 총 높이
		int F = sc.nextInt();
		// 내 위치
		int S = sc.nextInt();
		// 목표 층 높이
		int G = sc.nextInt();
		// 위로 몇층 이동
		int U = sc.nextInt();
		// 아래로 몇층 이동
		int D = sc.nextInt();

		boolean[] visited = new boolean[F + 1];
		int[] count = new int[F + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(S);
		visited[S] = true;
		int ans = 0;
		while (!queue.isEmpty()) {
			int poll = queue.poll();
			int up = poll + U;
			int down = poll - D;
			if (up >= 1 && up <= F && !visited[up]) {
				queue.add(up);
				visited[up] = true;
				count[up] = count[poll] + 1;
			}
			if (down >= 1 && down <= F && !visited[down]) {
				queue.add(down);
				visited[down] = true;
				count[down] = count[poll] + 1;
			}

			if (up == G || down == G) {
				ans = count[G];
				break;
			}
		}

		if (S == G) {
			System.out.println(ans);
		} else if (ans == 0) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
	}
}
