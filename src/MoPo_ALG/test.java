package MoPo_ALG;

import java.util.Scanner;

public class test {
    public static void help(int x){
        if (x <= 0){
            return;
        }
        int i = x%10;
        x = x/10;
        //System.out.println(i);
        help(x);
        System.out.println(i);
    }
    public static void dongTai(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n + 1];
        int[][] dp = new int[n + 1][41];// dp[i][j]表示从前i种物品拿出体积j的方法数
        for (int i = 1; i <= n; i++) {
            a[i] = s.nextInt();
            dp[i][0] = 1;//如果让拿的物品总重量为0，则有一种方法，即什么也不拿
        }
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 40; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= a[i])
                    dp[i][j] += dp[i - 1][j - a[i]];
            }
        }
        System.out.println(dp[n][40]);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= 40; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        dongTai();
    }
}
