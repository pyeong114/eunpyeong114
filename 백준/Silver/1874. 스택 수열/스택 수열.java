import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int num = 1;

		Stack<Integer> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int thisNum = sc.nextInt();
			for (; num <= thisNum; num++) {
				stack.add(num);
				sb.append("+").append("\n");
			}
			if (stack.peek() != thisNum) {
				System.out.println("NO");
				return;
			} else {
				stack.pop();
				sb.append("-").append("\n");
			}
		}
		System.out.println(sb);
	}
}