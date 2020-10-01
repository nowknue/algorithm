package boj;

import java.util.*;

public class BOJ1012_dfs {   
   static int[][] map;
   static boolean[][] check;
   static int[] movex = {-1, 0, 1, 0};
   static int[] movey = {0, 1, 0, -1};
   static int M, N, K;
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      int[] answer = new int[T];
      
      for (int i = 0; i < T; i++) {
         M = sc.nextInt();
         N = sc.nextInt();
         K = sc.nextInt();
         int count = 0;
         
         map = new int[M][N];
         check = new boolean[M][N];
         
         for (int j = 0; j < K; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = 1;
         }
         
         for (int j = 0; j < M; j++) {
            for (int k = 0; k < N; k++) {
               if (check[j][k] == false && map[j][k] == 1) {
                  dfs(j, k);
                  count++;
               }
            }
         }
         
         answer[i] = count;
      }
      for (int a : answer) {
         System.out.println(a);
      }
   }   
   
   static void dfs(int x, int y) {
      check[x][y] = true;
      int a = 0;
      int b = 0;
      for (int i = 0; i < 4; i++) {
         a = x + movex[i];
         b = y + movey[i];
         if (a >= 0 && a < M && b >= 0 && b < N) {
            if (check[a][b] == false && map[a][b] == 1) {
               dfs(a, b);
            }
         }
         
      }
   }      
}