package boj;

import java.util.Scanner;

public class BOJ14501_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] coun = new int[N + 1][2];
		int[] dp = new int[N + 2];

		for (int i = 1; i < N + 1; i++) {
			coun[i][0] = sc.nextInt();
			coun[i][1] = sc.nextInt();
		}

		for (int date = N; date >= 1; date--) {
			if (date + coun[date][0] - 1 <= N) {
				dp[date] = Math.max(coun[date][1] + dp[date + coun[date][0]], dp[date + 1]);
			} else {
				dp[date] = dp[date + 1];
			}
		}

		System.out.println(dp[1]);
	}

}