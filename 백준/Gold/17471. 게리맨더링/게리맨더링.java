
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	public static boolean[] sel;
	public static int N;
	public static int[] population;
	public static int[][] citys;
	public static List<Integer> min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 구역수
		N = sc.nextInt();
		// 구역 인접행렬
		citys = new int[N + 1][N + 1];
		// 인구수
		population = new int[N + 1];
		// 인구수 값 할당
		for (int i = 1; i < population.length; i++) {
			population[i] = sc.nextInt();
		}
		// 인접행렬 연결
		for (int i = 1; i <= N; i++) {
			int connectedCnt = sc.nextInt();
			for (int j = 1; j <= connectedCnt; j++) {
				int connectedCity = sc.nextInt();
				citys[i][connectedCity] = 1;
				citys[connectedCity][i] = 1;
			}
		}

		sel = new boolean[N + 1];

		// 부분집합 구하기
		min = new ArrayList<>();
		powerset(1);

		Collections.sort(min);

		int answer;
		if (min.isEmpty()) {
			answer = -1;
		} else {
			answer = min.get(0);
		}

		System.out.println(answer);
	}

	public static void powerset(int idx) {

		if (idx == N) {
			visited = new boolean[N + 1];

			List<Integer> A = new ArrayList<>();
			List<Integer> B = new ArrayList<>();
			for (int i = 1; i < sel.length; i++) {
				if (sel[i]) {
					A.add(i);
				} else {
					B.add(i);
				}
			}
			// BFS 검증할 부분
			// 원소가 없는 경우(=지역구 구분안되는 경우) 리턴
			if (A.size() == 0 || B.size() == 0)
				return;

			Queue<Integer> queueA = new LinkedList<>();
			Queue<Integer> queueB = new LinkedList<>();
			int aSum = 0;
			int bSum = 0;
			int Ae = A.get(0);
			int Be = B.get(0);
			int Acnt = A.size();
			int Bcnt = B.size();

			queueA.add(Ae);
			visited[Ae] = true;
			aSum += population[Ae];
			Acnt--;

			while (!queueA.isEmpty()) {
				int poll = queueA.poll();
				for (int i = 1; i < citys.length; i++) {
					if (A.contains(i) && !visited[i] && citys[poll][i] == 1) {
						visited[i] = true;
						queueA.add(i);
						aSum += population[i];
						Acnt--;
					}
				}
			}

			queueB.add(Be);
			visited[Be] = true;
			bSum += population[Be];
			Bcnt--;
			
			while (!queueB.isEmpty()) {
				int poll = queueB.poll();
				for (int i = 1; i < citys.length; i++) {
					if (B.contains(i) && !visited[i] && citys[poll][i] == 1) {
						visited[i] = true;
						queueB.add(i);
						bSum += population[i];
						Bcnt--;
					}
				}
			}
			
			if (Acnt == 0 && Bcnt == 0) {
				int diff = Math.abs(bSum - aSum);
				min.add(diff);
			}
			return;
		}

		powerset(idx + 1);
		sel[idx] = true;
		powerset(idx + 1);
		sel[idx] = false;

	}
}
