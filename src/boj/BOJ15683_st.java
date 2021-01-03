package boj;

import java.util.*;

public class BOJ15683_st {
	static int[][] map;
	static ArrayList<Node> camera;
	static int n;
	static int m;
	static int min;
	
	public static class Node{
		int x;
		int y;
		int k;
		
		Node(int x, int y, int k){
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	public static void see(int x, int y, int dx, int dy, int[][] v) {
		int nx = x + dx;
		int ny = y + dy;
		
		while(nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != 6) {
			v[nx][ny] = 1;
			nx += dx;
			ny += dy;
		}
	}
	
	public static void dfs(Node node, int flag, int[][] v, int idx) {
		int[][] visit = new int[n][m];
		int x = node.x;
		int y = node.y;
		int k = node.k;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visit[i][j] = v[i][j];
			}
		}
		visit[x][y] = 1;
		
		if(k == 1) {
			if(flag == 0) {
				see(x, y, -1, 0, visit);
			}
			else if(flag == 1) {
				see(x, y, 0, 1, visit);
			}
			else if(flag == 2) {
				see(x, y, 1, 0, visit);
			}
			else {
				see(x, y, 0, -1, visit);
			}
		}
		else if(k == 2){
			if(flag == 0) {
				see(x, y, 0, -1, visit);
				see(x, y, 0, 1, visit);
			}
			else {
				see(x, y, -1, 0, visit);
				see(x, y, 1, 0, visit);
			}
		}
		else if(k == 3) {
			if(flag == 0) {
				see(x, y, -1, 0, visit);
				see(x, y, 0, 1, visit);
			}
			else if(flag == 1) {
				see(x, y, 0, 1, visit);
				see(x, y, 1, 0, visit);
			}
			else if(flag == 2) {
				see(x, y, 1, 0, visit);
				see(x, y, 0, -1, visit);
			}
			else {
				see(x, y, 0, -1, visit);
				see(x, y, -1, 0, visit);
			}
		}
		else if(k == 4) {
			if(flag == 0) {
				see(x, y, 0, -1, visit);
				see(x, y, -1, 0, visit);
				see(x, y, 0, 1, visit);
			}
			else if(flag == 1) {
				see(x, y, -1, 0, visit);
				see(x, y, 0, 1, visit);
				see(x, y, 1, 0, visit);
			}
			else if(flag == 2) {
				see(x, y, 0, 1, visit);
				see(x, y, 1, 0, visit);
				see(x, y, 0, -1, visit);
			}
			else {
				see(x, y, 1, 0, visit);
				see(x, y, 0, -1, visit);
				see(x, y, -1, 0, visit);
			}
		}
		else {
			see(x, y, -1, 0, visit);
			see(x, y, 0, 1, visit);
			see(x, y, 1, 0, visit);
			see(x, y, 0, -1, visit);
		}
		
		if(idx == camera.size()) {
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] != 6 && visit[i][j] == 0) {
						cnt++;
					}
				}
			}
			min = Math.min(cnt, min);
			return;
		}
		node = camera.get(idx);
		k = node.k;
		
		if(k == 1 || k == 3 || k == 4) {
			dfs(node, 0, visit, idx+1);
			dfs(node, 1, visit, idx+1);
			dfs(node, 2, visit, idx+1);
			dfs(node, 3, visit, idx+1);
		}
		else if(k == 2) {
			dfs(node, 0, visit, idx+1);
			dfs(node, 1, visit, idx+1);
		}
		else {
			dfs(node, 0, visit, idx+1);
		}
		
	}
	
	public static void init() {
		int[][] visit = new int[n][m];
		Node node = camera.get(0);
		int k = node.k;
		if(k == 1 || k == 3 || k == 4) {
			dfs(node, 0, visit, 1);
			dfs(node, 1, visit, 1);
			dfs(node, 2, visit, 1);
			dfs(node, 3, visit, 1);
		}
		else if(k == 2) {
			dfs(node, 0, visit, 1);
			dfs(node, 1, visit, 1);
		}
		else {
			dfs(node, 0, visit, 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		min = 0;
		camera = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] >= 1 && map[i][j] <= 5)
					camera.add(new Node(i, j, map[i][j]));
				if(map[i][j] == 0)
					min++;
			}
		}
		if(camera.size() > 0) init();
		
		System.out.println(min);
	}
}