
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			long[][] bridge = new long[N + 1][M + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = i; j <= M; j++) {
					if(i==j) {
						bridge[i][j] = 1;
					} else if(i==1) {
						bridge[i][j] = j;
					} else{
						bridge[i][j]= bridge[i-1][j-1] + bridge[i][j-1];
					}
				}
			}
			
			System.out.println(bridge[N][M]);
		}
	}
}