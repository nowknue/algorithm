package boj;

import java.io.*;

public class BOJ14500_st2 {
	static int MAX = Integer.MIN_VALUE;
	static int[] moveX = { 0, 0, -1, 1 };
	static int[] moveY = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] split = br.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int[][] arr = new int[n][m];
		int[][] visit = new int[n][m];
		for (int i = 0; i < arr.length; i++) {
			String[] split1 = br.readLine().split(" ");
			for (int j = 0; j < split1.length; j++) {
				arr[i][j] = Integer.parseInt(split1[j]);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i, j, 1, 0, arr, visit);
			}
		}

		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 1; j++) {
				check1(i, j, arr);
			}
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 2; j++) {
				check2(i, j, arr);
			}
		}

		System.out.println(MAX);
	}

	private static void check1(int n, int m, int[][] arr) {
		int sum1 = arr[n][m] + arr[n + 1][m] + arr[n + 2][m] + arr[n + 1][m + 1];
		if (sum1 > MAX) {
			MAX = sum1;
		}
		int sum2 = arr[n][m + 1] + arr[n + 1][m] + arr[n + 1][m + 1] + arr[n + 2][m + 1];
		if (sum2 > MAX) {
			MAX = sum2;
		}
	}

	private static void check2(int n, int m, int[][] arr) {
		int sum1 = arr[n][m] + arr[n][m + 1] + arr[n][m + 2] + arr[n + 1][m + 1];
		if (sum1 > MAX) {
			MAX = sum1;
		}
		int sum2 = arr[n][m + 1] + arr[n + 1][m] + arr[n + 1][m + 1] + arr[n + 1][m + 2];
		if (sum2 > MAX) {
			MAX = sum2;
		}
	}

	private static void dfs(int n, int m, int depth, int value, int[][] arr, int[][] visit) {
		if (n < 0 || n >= arr.length || m < 0 || m >= arr[0].length) {
			return;
		}
		if (visit[n][m] == 1) {
			return;
		}
		if (depth == 4) {
			if (value + arr[n][m] > MAX) {
				MAX = value + arr[n][m];
			}
			return;
		}

		visit[n][m] = 1;
		for (int i = 0; i < 4; i++) {
			dfs(n + moveX[i], m + moveY[i], depth + 1, value + arr[n][m], arr, visit);
		}
		visit[n][m] = 0;
	}

}