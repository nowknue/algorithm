package boj;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class BOJ2178_bfs {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        
        sc.nextLine();
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for(int j = 0; j < M; j++) {
                map[i][j]=str.charAt(j)-'0';
            }
        }
        
        bfs(0, 0);
        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        
        queue.offer(new Pair(x, y));
        
        while(!queue.isEmpty()) {
           Pair p = queue.poll();
           
           for (int i = 0; i < 4; i++) {
              int a = p.x + dx[i];
              int b = p.y + dy[i];
              
              if (a >= 0 && a < N && b >= 0 && b < M && !visited[a][b] && map[a][b] == 1) {
                 visited[a][b] = true;
                 map[a][b] = map[p.x][p.y] + 1;
                 queue.offer(new Pair(a, b));
                 
              }
           }
           
        }
        
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}