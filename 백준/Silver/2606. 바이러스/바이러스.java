
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	public static List<Integer>[] adjList;
	public static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 컴퓨터 수
		int N = sc.nextInt();
		// 연결 수
		int M = sc.nextInt();
		// 방문 체크 초기화
		visited = new boolean[N + 1];
		// 인접리스트
		adjList = new ArrayList[N + 1];
		// 인접리스트 값 초기화
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}
		// 인접리스트 값 할당
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adjList[A].add(B);
			adjList[B].add(A);
		}
		// 1번 컴퓨터가 바이러스에 감염된 경우
		dfs(1);
		System.out.println(ans);
	}

	public static void dfs(int i) {
		if(visited[i])
			return;
		
		visited[i] = true;
		for(int a: adjList[i] ) {
			if(!visited[a]) {
				ans++;
				dfs(a);
			}
		}
	}
}
