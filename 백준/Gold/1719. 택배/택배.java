
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static List<int[]>[] adjList;
	public static int n;
	public static String[][] answer;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// 집하장의 갯수
		n = sc.nextInt();
		// 경로의 갯수
		int m = sc.nextInt();

		answer = new String[n][n];

		adjList = new ArrayList[n + 1];

		for (int i = 1; i < n + 1; i++) {
			adjList[i] = new ArrayList<>();
		}
		// 인접리스트
		for (int i = 0; i < m; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int W = sc.nextInt();
			adjList[A].add(new int[] { B, W });
			adjList[B].add(new int[] { A, W });
		}
		// 정점마다 다익스트라 적용
		for (int i = 1; i < n + 1; i++) {
			dijkstra(i);

		}
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n ; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void dijkstra(int start) {
		boolean[] visited = new boolean[n + 1];
		// 거리
		int[] dist = new int[n + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;
		// 경유 집하장
		int[] p = new int[n + 1];

		for (int i = 1; i < n + 1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;

			for (int j = 1; j < n + 1; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}

			if (idx == -1) {
				System.out.println(Arrays.toString(p));
				return;
			}

			visited[idx] = true;

			for (int j = 0; j < adjList[idx].size(); j++) {
				int v = adjList[idx].get(j)[0];
				int w = adjList[idx].get(j)[1];
				if (!visited[v] && dist[v] > dist[idx] + w) {
					dist[v] = dist[idx] + w;
					p[v] = idx;
				}
			}
		}
		for (int j = 0; j < n; j++) {
			answer[j][start - 1] = Integer.toString(p[j + 1]);
			if (answer[j][start-1].equals("0"))
				answer[j][start-1] = "-";
		}
	}
}