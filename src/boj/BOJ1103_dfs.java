package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1103_dfs {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dp;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new char[N][M];
        visited = new boolean[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<M; j++)
                map[i][j] = str.charAt(j);
        }

        dfs(0, 0, 0);

        if(max!=-1) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++)
                    max = Math.max(max, dp[i][j]);
            }
            max++;
        }
        System.out.println(max);
    }

    public static void dfs(int x, int y, int t) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + (map[x][y]-'0')*dx[i];
            int ny = y + (map[x][y]-'0')*dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny]=='H' || dp[nx][ny]>t+1) continue;
            if(visited[nx][ny]) {
                max = -1;
                return;
            }
            dp[x][y] = Math.max(dp[nx][ny], t+1);
            dfs(nx, ny, t+1);
        }

        visited[x][y] = false;
    }
}