
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 1;
		int N = sc.nextInt();
		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			queue.add(sc.nextInt());
		}
		int idx = 0;
		while (queue.size() != 0) {
			// 스택에 값이 있는 경우
			if (!stack.isEmpty()) {
				// 번호표 순서와 비교 후 같다면
				if (stack.peek() == count) {
					// 제거 후
					stack.pop();
					// count 세기
					count++;
					continue;
					// 번호표 순서와 스택값과 다르다면
				} else {
					// input값과 일치하는 경우
					if (queue.peek() == count) {
						queue.poll();
						count++;
						continue;
						// 일치하지 않는 경우 스택에 추가
					} else {
						stack.add(queue.poll());
					}
				}
				// 스택에 값이 없는 경우
			} else {
				// 들어온 값과 번호표 순서가 일치하지 않는 경우
				if (queue.peek()!= count) {
					// 스택에 넣기
					stack.add(queue.poll());
					// 일치하는 경우
				} else {
					queue.poll();
					count++;
					continue;
				}
			}
			
		}
		
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			if (stack.pop() == count) {
				count++;
				continue;
			} else {
				System.out.println("Sad");
				return;
			}
		}

		if (stack.size() == 0) {
			System.out.println("Nice");
		} else {

			System.out.println("Sad");
		}
	}
}