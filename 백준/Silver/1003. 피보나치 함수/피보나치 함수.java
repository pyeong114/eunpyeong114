import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] dp = new int[N+1][2];
			
			for(int i = 0; i<=N; i++) {
				if(i==0) {
					dp[i][0] = 1;
				} else if(i==1) {
					dp[i][1] = 1;
				} else {
					dp[i][0] = dp[i-1][0]+dp[i-2][0];
					dp[i][1] = dp[i-1][1] + dp[i-2][1];
				}
			}
			System.out.printf("%d %d\n",dp[N][0],dp[N][1]);
		}
    }
}