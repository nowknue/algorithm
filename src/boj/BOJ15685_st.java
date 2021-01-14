package boj;

import java.util.*;

public class BOJ15685_st {
	static int[][] map;
	static int cnt;
	
	public static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static Node go(int x, int y) {
		Node next;
		if(x == 1 && y == 0) next = new Node(0, -1);
		else if(x == -1 && y == 0) next = new Node(0, 1);
		else if(x == 0 && y == -1) next = new Node(-1, 0);
		else next = new Node(1, 0);
		return next;
	}
			
	public static void dragon(int x, int y, int[] d, int period) {
		ArrayList<Node> a = new ArrayList<>();
		ArrayList<Node> dp = new ArrayList<>();
		
		a.add(new Node(x, y));
		x = x + d[0];
		y = y + d[1];
		a.add(new Node(x, y));
		dp.add(new Node(a.get(1).x - a.get(0).x, a.get(1).y - a.get(0).y));
		
		for(int i = 0; i < period; i++) {
			int dp_size = dp.size();
			for(int j = 0; j < dp_size; j++) {
				int tmpx = dp.get(dp_size - 1 - j).x;
				int tmpy = dp.get(dp_size - 1 - j).y;
				Node node = go(tmpx, tmpy);
				int nx = a.get(a.size()-1).x + node.x;
				int ny = a.get(a.size()-1).y + node.y;
				a.add(new Node(nx, ny));
				dp.add(new Node(node.x, node.y));
			}
		}
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).x >= 0 && a.get(i).y >= 0 && a.get(i).x <= 100 && a.get(i).y <= 100){
				map[a.get(i).x][a.get(i).y] = 1;
			}
			
		}
	}
	
	public static void count() {
		for(int i = 0; i <= 100; i++) {
			for(int j = 0; j <= 100; j++) {
				if(map[i][j] == 1) {
					if(i+1 <= 100 && j+1 <= 100) {
						if(map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1) cnt++;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] direct = {{1,0}, {0, -1}, {-1, 0}, {0, 1}};
		map = new int[101][101];
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();
			int p = sc.nextInt();
			
			dragon(x, y, direct[d], p);
		}
		count();
		System.out.println(cnt);
	}
}