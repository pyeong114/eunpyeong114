import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        int num = 2;
        while (num <= n) {
            if(num%2==0){
                dp[num] = Math.min(dp[num],dp[num/2]+1);
            }

            if(num %3==0){
                dp[num] = Math.min(dp[num],dp[num/3]+1);
            }

            dp[num] = Math.min(dp[num-1]+1,dp[num]);

            num++;
        }
        System.out.println(dp[n]);
    }
}