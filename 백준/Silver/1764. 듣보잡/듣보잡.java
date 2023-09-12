import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		Map<String, Integer> Map = new HashMap<>();

		for (int i = 0; i < N + M; i++) {
			String name = sc.next();
			if (Map.get(name) == null) {
				Map.put(name, 1);
			} else {
				Map.put(name, Map.get(name) + 1);
			}
		}

		List<String> duplicated = new ArrayList<>();
		for (String key : Map.keySet()) {
			if (Map.get(key) != 1) {
				duplicated.add(key);
			}
		}
		
		Collections.sort(duplicated);
		System.out.println(duplicated.size());
		for(String s : duplicated) {
			System.out.println(s);
		}
	}
}