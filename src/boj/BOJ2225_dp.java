package boj;

import java.io.*;

public class BOJ2225_dp {
	public static long[][] D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		// D[n][k] = D[n][k - 1] + D[n - 1][k - 1] + ... D[1][k - 1] + D[0][k - 1]
		// n >= k 인 보장이 없다
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		D = new long[n + 1][k + 1];
		for (int i = 0; i <= k; i++) {
			D[0][i] = 1;
		}
		makeD(n, k);
		System.out.println(D[n][k]);

	}

	public static void makeD(int n, int k) {
		// 기저 사례 : k가 1이 아니면 배열을 아직 덜 채웠으므로 into
		if (k > 1) {
			makeD(n, k - 1);
			long sum = D[0][k - 1];
			for (int i = 1; i <= n; i++) {
				sum += D[i][k - 1];
				D[i][k] = sum % 1000000000;
			}
		} else {
			for (int i = 1; i <= n; i++) {
				D[i][1] = 1;
			}
		}
	}
}