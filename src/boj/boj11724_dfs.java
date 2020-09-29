package boj;

import java.util.Scanner;

public class boj11724_dfs {   
   static int[][] map;
   static boolean[] check;
   static int N, M;
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      M = sc.nextInt();
      int count = 0;
      map = new int[N][N];
      check = new boolean[N];
      
      for (int i = 0; i < M; i++) {
         int a = sc.nextInt();
         int b = sc.nextInt();
         
         map[a - 1][b - 1] = 1;
         map[b - 1][a - 1] = 1;
      }
      
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < N; j++) {
            if (!check[j] && map[i][j] == 1) {
               dfs(j);
               count++;
            }
         }
      }
      
      //노드에 연결된 간선이 하나도 없을 경우
      for(int i = 0; i < N; i++) {
         int sum = 0;
         for(int j = 0; j < N; j++) {
            sum += map[i][j];
         }
         if(sum == 0)
            count++;
      }
            
      System.out.println(count);
   }
   
   public static void dfs(int num) {
      check[num] = true;
      
      for (int i = 0; i < N; i++) {
         if (!check[i] && map[num][i] == 1) {
            dfs(i);
         }
      }
   }
}