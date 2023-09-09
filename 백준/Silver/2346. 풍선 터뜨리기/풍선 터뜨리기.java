import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Deque<int[]> deque = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			int[] arr = {i,sc.nextInt()};
			deque.addLast(arr);
		}
		int n = deque.peekFirst()[1];
		int newSt = 0;
		
		System.out.print(deque.pollFirst()[0] + " ");

		while (deque.size() != 0) {
			if (n > 0) {
				for (int i = 0; i < n; i++) {
					if (i != n - 1) {
						deque.addLast(deque.pollFirst());
					} else {
						int ans = deque.peekFirst()[0];
						newSt = deque.pollFirst()[1];
						System.out.print(ans+" ");
					}
				}
			} else {
				for (int i = 0; i < Math.abs(n); i++) {
					if (i != Math.abs(n) - 1) {
						deque.addFirst(deque.pollLast());
					} else {
						int ans = deque.peekLast()[0];
						newSt = deque.pollLast()[1];
						System.out.print(ans+" ");
					}
				}
			}
			n = newSt;
		}
	}
}
