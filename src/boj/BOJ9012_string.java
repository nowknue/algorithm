package boj;

import java.util.Scanner;

public class BOJ9012_string {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		String[] ans = new String[T];
		String[] p = new String[T];

		for (int i = 0; i < T; i++) {
			p[i] = sc.nextLine();
			ans[i] = "YES";
		}

		for (int i = 0; i < T; i++) {
			String[] arr = p[i].split("");
			if (arr[0].equals(")")) {
				ans[i] = "NO";
			} else {
				int open = 0;
				int close = 0;
				for (int j = 0; j < arr.length; j++) {
					if (arr[j].equals("(")) {
						open++;
					} else {
						close++;
					}
					if (open < close) {
						ans[i] = "NO";
					}
				}
				if (open != close) {
					ans[i] = "NO";
				}
			}
		}

		for (int i = 0; i < T; i++) {
			System.out.println(ans[i]);
		}
	}
}