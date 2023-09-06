import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if (stack.isEmpty()) {
				stack.add(input);
			} else {
				if (stack.peek() > input) {
					stack.add(input);
					ans += stack.size() - 1;
				} else {
					while (!stack.isEmpty() && (stack.peek() <= input)) {
						stack.pop();
					}
					stack.add(input);
					ans += stack.size() - 1;
				}
			}
		}
		System.out.println(ans);
	}
}