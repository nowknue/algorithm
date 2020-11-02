package boj;

import java.util.Scanner;

public class BOJ1912_dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] d = new int[N];
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		d[0] = arr[0];
		for (int i = 1; i < N; i++) {
			d[i] = Math.max(d[i-1] + arr[i], arr[i]);
			if (max < d[i]) {
				max = d[i];
			}
		}
		
		System.out.println(Math.max(d[0], max));
	}

}