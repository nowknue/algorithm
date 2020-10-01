package boj;

import java.util.Scanner;

// 계단오르기 연속세칸안됨
public class BOJ2579_dp {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] map = new int[N+1];
        int[][] d = new int[N+1][3];
        
        for (int i = 1; i < N+1; i++) {
           map[i] = sc.nextInt();
        }
        
        d[1][1] = map[1];
        
        for (int n = 2; n < N + 1; n++) {
           d[n][1] = Math.max(d[n-2][1],d[n-2][2]) + map[n];
           d[n][2] = d[n-1][1] + map[n];
       }
        
        System.out.println(Math.max(d[N][1], d[N][2]));
   }
}