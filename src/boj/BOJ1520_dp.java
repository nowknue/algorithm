package boj;

import java.util.*;

class BOJ1520_dp {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N, M, min, count;
	static int[][] dp;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();

		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++)
				dp[i][j] = -1;
		}

		int ans = dfs(0, 0);
		System.out.println(ans);
	}

	public static int dfs(int x, int y) {
		if (dp[x][y] != -1)
			return dp[x][y];

		if (x == M - 1 && y == N - 1)
			return 1;

		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isInside(nx, ny) || map[nx][ny] >= map[x][y])
				continue;

			dp[x][y] += dfs(nx, ny);
		}

		return dp[x][y];
	}

	static boolean isInside(int a, int b) {
		return a >= 0 && a < M && b >= 0 && b < N;
	}
}