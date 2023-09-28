
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 수
		int t = sc.nextInt();
		loof: for (int tc = 1; tc <= t; tc++) {
			// 편의점 수
			int n = sc.nextInt();

			// 상근이네 집
			int geunX = sc.nextInt();
			int geunY = sc.nextInt();

			// 편의점
			int[][] con = new int[n][2];

			for (int i = 0; i < n; i++) {
				con[i][0] = sc.nextInt();
				con[i][1] = sc.nextInt();
			}

			// 락 페스티벌 좌표
			int fesX = sc.nextInt();
			int fesY = sc.nextInt();
			// 편의점이 없을 때
			if (n == 0) {
				int sum = Math.abs(fesX - geunX) + Math.abs(fesY - geunY);
				if (sum <= 20 * 50) {
					System.out.println("happy");
				} else {
					System.out.println("sad");
				}
				continue loof;
			}
			boolean[] visited = new boolean[n];
			// 편의점이 존재하는 경우
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { geunX, geunY });
			while (!queue.isEmpty()) {
				int[] poll = queue.poll();
				int x = poll[0];
				int y = poll[1];
				if (Math.abs(x - fesX) + Math.abs(y - fesY) <= 1000) {
					System.out.println("happy");
					continue loof;
				}

				for (int i = 0; i < n; i++) {
					if (!visited[i]) {
						int cx = con[i][0];
						int cy = con[i][1];
						int dist = Math.abs(x - cx) + Math.abs(y - cy);
						if (dist <= 1000) {
							queue.add(new int[] { cx, cy });
							visited[i] = true;
						}
					}
				}
			}
			System.out.println("sad");
		}
	}
}