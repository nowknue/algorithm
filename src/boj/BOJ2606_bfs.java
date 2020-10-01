package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2606_bfs {
   
   static int N, connect, result;
    
    static int[][] map; // 그래프
    static boolean[] check; // 방문
 
    static void bfs(int start) {
       Queue<Integer> queue = new LinkedList<>();
       check = new boolean[N+1];
       
       check[start] = true;
       queue.offer(start);
       
       int virus = 0;
       
       while (!queue.isEmpty()) {
          int x = queue.poll();
          for (int i = 1; i < map.length; i++) {
             if (check[i] == false && map[x][i] == 1) {
                queue.offer(i);
                check[i] = true;
                virus++;
             }
             
          }
          
          
       }
       System.out.println(virus);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        connect = sc.nextInt();
        
        map = new int[N+1][N+1];
        
        for (int i = 0; i < connect; i++) {
           int a = sc.nextInt();
           int b = sc.nextInt();
           
           map[a][b] = 1;
           map[b][a] = 1;
        }
        
        bfs(1);
        
    }
}