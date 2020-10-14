package boj;

import java.util.Scanner;


public class BOJ11052_dp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] card = new int[N+1];
		int[] dp = new int[N+2];
		
		
		for (int i = 1; i < N + 1; i++) {
			card[i] = sc.nextInt();
		}
		
		dp[1] = card[1];
		
		for (int i = 2; i < N + 1; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 1; j < i; j++) {
				if (max < dp[i-j] + dp[j]) {
					max = dp[i-j] + dp[j];
				}
			}
			dp[i] = Math.max(card[i], max);
		}
		
		System.out.println(dp[N]);
	}

}