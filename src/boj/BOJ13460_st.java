package boj;

import java.util.*;
import java.io.*;

public class BOJ13460_st {
	static int n;
	static int m;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int min = -1;
	static int tx;
	static int ty;
	
	public static boolean possible(int x, int y, int d, char[][] map) {
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx > 0 && ny > 0 && nx < n - 1 && ny < m - 1 && (map[nx][ny] == '.' || map[nx][ny] == 'O')) return true;
		else return false;
		
	}
	
	public static void dfs(int rx, int ry, int bx, int by, int d, char[][] map, int cnt) {
		if(cnt > 10) return;
		char[][] n_map = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				n_map[i][j] = map[i][j];
			}
		}
		
		int nrx = rx, nry = ry;
		int nbx = bx, nby = by;
		int[] flag = new int[2];
		if(rx == tx && ry == ty) flag[0] = 1;
		if(bx == tx && by == ty) flag[1] = 1;
		while((flag[0] == 0 && possible(rx, ry, d, n_map)) || possible(bx, by, d, n_map)) {
			if(flag[0] == 0 && possible(rx, ry, d, n_map)) {
				nrx = rx + dx[d];
				nry = ry + dy[d];
				
				n_map[rx][ry] = '.';
				n_map[nrx][nry] = 'R';
				
				rx = nrx;
				ry = nry;
				if(rx == tx && ry == ty) {
					flag[0] = 1;
					n_map[rx][ry] = 'O';
				}
			}
			if(possible(bx, by, d, n_map)) {
				nbx = bx + dx[d];
				nby = by + dy[d];
				
				n_map[bx][by] = '.';
				n_map[nbx][nby] = 'B';
				
				bx = nbx;
				by = nby;
				if(bx == tx && by == ty) {
					flag[1] = 1;
					return;
				}
			}
		}
		if(flag[0] == 1) {
			if(min == -1) min = cnt;
			else min = Math.min(cnt, min);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(d == 0 && i == 2) continue;
			if(d == 1 && i == 3) continue;
			if(d == 2 && i == 4) continue;
			if(d == 3 && i == 1) continue;
			if(possible(nrx, nry, i, n_map) || possible(nbx, nby, i, n_map)) {
				dfs(nrx, nry, nbx, nby, i, n_map, cnt + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(tk.nextToken());
		m = Integer.parseInt(tk.nextToken());
		char[][] map = new char[n][m];
		
		int rx = 0, ry = 0;
		int bx = 0, by = 0;
		
		for(int i = 0; i < n; i++) {
			tk = new StringTokenizer(br.readLine());
			String s = tk.nextToken();
			for(int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == 'R') {
					rx = i;
					ry = j;
				}
				
				if(map[i][j] == 'B') {
					bx = i;
					by = j;
				}
				
				if(map[i][j] == 'O') {
					tx = i;
					ty = j;
				}
			}
		}
		
		for(int i = 0; i < 4; i++) {
			if(possible(rx, ry, i, map) || possible(bx, by, i, map)) {
				dfs(rx, ry, bx, by, i, map, 1);
			}
		}
		
		System.out.println(min);
	}
}