import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static List<int[]>[] adjList;
	public static int[] totalTime;
	public static int N;
	public static int X;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 마을 번호 / 학생 번호(정점)
		N = sc.nextInt();
		// 간선 갯수
		int M = sc.nextInt();
		// 파티하기로 한 정점
		X = sc.nextInt();
		// 왕복 걸리는 시간
		totalTime = new int[N + 1];
		// 인접리스트
		adjList = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int T = sc.nextInt();

			adjList[A].add(new int[] { B, T });
		}

		for (int i = 1; i < N + 1; i++) {
			dijkstra(i);
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int n : totalTime) {
			if(max<n) {
				max = n;
			}
		}
		System.out.println(max);
	}

	public static void dijkstra(int start) {

		boolean[] visited = new boolean[N + 1];

		int[] dist = new int[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;

		for (int i = 1; i < N + 1; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for (int j = 1; j < N + 1; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}

			if (idx == -1) {
				return;
			}

			visited[idx] = true;

			for (int j = 0; j < adjList[idx].size(); j++) {
				// 연결 정점
				int v = adjList[idx].get(j)[0];
				// 거리
				int w = adjList[idx].get(j)[1];

				if (!visited[v] && dist[v] > dist[idx] + w) {
					dist[v] = dist[idx] + w;
				}
			}
		}

		if (start == X) {
			for (int i = 1; i <= N; i++) {
				totalTime[i] += dist[i];
			}
		} else {
			totalTime[start] += dist[X];
		}

	}
}