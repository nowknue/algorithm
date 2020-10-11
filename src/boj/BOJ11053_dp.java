package boj;

import java.util.Scanner;

public class BOJ11053_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] d = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		d[0] = 1;

		for (int i = 1; i < N; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && d[i] <= d[j]) {
					d[i] = d[j] + 1;
				}
			}
		}

		int max = 0;
		for (int i : d) {
			max = Math.max(max, i);
		}

		System.out.println(max);
	}
}