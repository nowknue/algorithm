package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ12865_dp {
	static int N; // 물건 개수
	static int K; // 무게
	static int[][] dp;
	static ArrayList<Product> products = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N + 1][K + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			products.add(new Product(w, v));
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				int temp_v = products.get(i - 1).v;
				int temp_w = products.get(i - 1).w;

				dp[i][j] = dp[i - 1][j];

				if (j >= temp_w) {
					dp[i][j] = Math.max(dp[i - 1][j - temp_w] + temp_v, dp[i][j]);
				}
			}
		}

		System.out.println(dp[N][K]);
	}

	static class Product {
		int w;
		int v;

		public Product(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}