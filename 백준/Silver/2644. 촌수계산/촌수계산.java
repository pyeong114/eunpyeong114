import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	public static List<Integer>[] adjList;
	public static int ans = 0;
	public static int B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 사람의 수
		int N = sc.nextInt();

		// 사람
		int A = sc.nextInt();
		B = sc.nextInt();

		// 관계
		int M = sc.nextInt();

		visited = new boolean[N + 1];
		adjList = new ArrayList[N + 1];

		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 인접리스트 값 할당
		for (int i = 1; i <= M; i++) {
			// 부모
			int p = sc.nextInt();
			// 자식
			int c = sc.nextInt();
			// 연결
			adjList[p].add(c);
			adjList[c].add(p);
		}

		dfs(A, 0);
		if (ans == 0) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	public static void dfs(int i, int dep) {
		if (visited[i])
			return;
		if (i == B) {
			ans = dep;
			return;
		}

		visited[i] = true;
		for (int a : adjList[i]) {
			if (!visited[a]) {
				dfs(a, dep + 1);
				visited[a] = false;
			}
		}
	}
}