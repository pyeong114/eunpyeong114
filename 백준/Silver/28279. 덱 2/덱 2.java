import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Deque<String> deque = new ArrayDeque<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			if (input.length == 2) {
				if(input[0].equals("1")) {
					deque.addFirst(input[1]);					
				} else {
					deque.addLast(input[1]);
				}
			} else {
				if(input[0].equals("3")) {
					if(!deque.isEmpty()) {
						bw.write(deque.pollFirst());
						bw.newLine();
					} else {
						bw.write("-1");
						bw.newLine();
					}
				 } else if(input[0].equals("4")) {
					 if(!deque.isEmpty()) {
						 bw.write(deque.pollLast());
						 bw.newLine();
					 } else {
						 bw.write("-1");
						 bw.newLine();
					 }
				 } else if(input[0].equals("5")) {
					 bw.write(Integer.toString(deque.size()));
					 bw.newLine();
				 } else if(input[0].equals("6")) {
					 if(!deque.isEmpty()) {
						 bw.write("0");
						 bw.newLine();
					 } else {
						 bw.write("1");
						 bw.newLine();
					 }
				 } else if(input[0].equals("7")) {
					 if(!deque.isEmpty()) {
						 bw.write(deque.peekFirst());
						 bw.newLine();
					 } else {
						 bw.write("-1");
						 bw.newLine();
					 }
				 } else if(input[0].equals("8")) {
					 if(!deque.isEmpty()) {
						 bw.write(deque.peekLast());
						 bw.newLine();
					 } else {
						 bw.write("-1");
						 bw.newLine();
					 }
				 }
				
			}
		}
		bw.flush();
	}
}
