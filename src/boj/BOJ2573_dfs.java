package boj;

import java.util.Scanner;

public class BOJ2573_dfs {

	static int[][] map, tmp;
	static boolean[][] visitedMelt, visitedCount;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N, M, year;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		tmp = new int[N][M];
		year = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		while (true) {
			int count = 0;
			visitedCount = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visitedCount[i][j] && map[i][j] != 0) {
						dfsCount(i, j);
						count++;
					}
				}
			}

			if (count == 1) {
				visitedMelt = new boolean[N][M];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (!visitedMelt[i][j] && map[i][j] != 0) {
							dfsMelt(i, j);
						}
					}
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						map[i][j] = map[i][j] - tmp[i][j];
						if (map[i][j] < 0) {
							map[i][j] = 0;
						}
					}
				}

				year++;
			} else if (count == 0) {
				System.out.println(0);
				break;
			} else {
				System.out.println(year);
				break;
			}

		}

	}

	public static void dfsMelt(int a, int b) {
		visitedMelt[a][b] = true;
		int newx;
		int newy;
		for (int i = 0; i < 4; i++) {
			newx = a + dx[i];
			newy = b + dy[i];
			if (map[newx][newy] == 0) {
				tmp[a][b]++;
			}
		}

		for (int i = 0; i < 4; i++) {
			newx = a + dx[i];
			newy = b + dy[i];
			if (!visitedMelt[newx][newy] && map[newx][newy] != 0) {
				dfsMelt(newx, newy);
			}
		}
	}

	public static void dfsCount(int a, int b) {
		visitedCount[a][b] = true;
		for (int i = 0; i < 4; i++) {
			int newx = a + dx[i];
			int newy = b + dy[i];
			if (newx >= 0 && newx < N && newy >= 0 && newy < M) {
				if (!visitedCount[newx][newy] && map[newx][newy] != 0) {
					dfsCount(newx, newy);
				}
			}
		}
	}
}