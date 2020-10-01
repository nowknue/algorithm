package boj;

import java.util.Scanner;

public class BOJ1932_dp {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        int[][] d = new int[N][N];
        
        for (int i = 0; i < N; i++) {
           for (int j = 0; j <= i; j++) {
              map[i][j] = sc.nextInt();
           }
        }
        
        d[0][0] = map[0][0];
        d[1][0] = map[0][0] + map[1][0];
        d[1][1] = map[0][0] + map[1][1];
        for (int i = 2; i < N; i++) {
           for (int j = 0; j <= i; j++) {
              if (j == 0) {
                 d[i][j] = d[i-1][j] + map[i][j];
              } else {
                 d[i][j] = Math.max(d[i-1][j-1] + map[i][j], d[i-1][j] + map[i][j]);
              }
           }
        }
        int MAX = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
           if (MAX < d[N-1][i]) {
              MAX = d[N-1][i];
           }
        }
        
        System.out.println(MAX);
   }
}