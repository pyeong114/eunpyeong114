import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if(j==0){
                    dp[i][j] = Math.min(dp[i-1][j+1]+cost[i][j],dp[i-1][j+2]+cost[i][j]);
                } else if(j==1){
                    dp[i][j] = Math.min(dp[i-1][j-1]+cost[i][j],dp[i-1][j+1]+cost[i][j]);
                } else{
                    dp[i][j] = Math.min(dp[i-1][j-2]+cost[i][j],dp[i-1][j-1]+cost[i][j]);
                }
            }
        }

        System.out.println(Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2])));
    }
}