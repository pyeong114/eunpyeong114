import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] N = sc.next().split("-");
		int ans = 0;
		for (int i = 0; i < N.length; i++) {
			if (i == 0) {
				if (N[i].contains("+")) {
					String[] splitArr = N[i].split("\\+");
					for (int j = 0; j < splitArr.length; j++) {
						ans += Integer.parseInt(splitArr[j]);
					}
				} else {
					ans+=Integer.parseInt(N[i]);
				}
			} else if (N[i].contains("+")) {
				String[] splitArr = N[i].split("\\+");
				for (int j = 0; j < splitArr.length; j++) {
					ans -= Integer.parseInt(splitArr[j]);
				}
			} else {
				ans -= Integer.parseInt(N[i]);
			}
		}
		System.out.println(ans);
	}
}