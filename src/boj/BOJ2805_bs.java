package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805_bs {
	private static int n, m;
	private static long[] trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		trees = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(trees);

		long left = 1;
		long right = trees[trees.length - 1];

		while (left <= right) {
			long mid = (left + right) / 2;

			long sum = 0;
			for (long tree : trees) {
				if (tree > mid) {
					sum += tree - mid;
				}
			}

			if (sum >= m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(right);
	}
}