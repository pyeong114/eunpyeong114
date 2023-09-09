
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}

		while (deque.size() != 1) {
			if (deque.size() == 2) {
				deque.pollFirst();				
			} else {
				deque.pollFirst();
				int add = deque.pollFirst();
				deque.addLast(add);			
			}
		}
		System.out.println(deque.peekFirst());
	}
}
