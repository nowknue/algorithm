package boj;

import java.util.Scanner;

public class BOJ11049_dp {
	
	static int[][] matrix, dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		matrix = new int[N][2];
		dp = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j)
					dp[i][j] = 0;
				else
					dp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int d = 1; d < N; d++) {
			for (int i = 0; i + d < N; i++) {
				setMinMultipleCnt(i, i + d);
			}
		}
		System.out.println(dp[0][N - 1]);
	}

	private static void setMinMultipleCnt(int start, int end) {
		for (int i = start; i < end; i++) {
			int cnt = dp[start][i] + dp[i + 1][end] + matrix[start][0] * matrix[i][1] * matrix[end][1];
			dp[start][end] = Math.min(cnt, dp[start][end]);
		}
	}

}