package boj;

import java.util.Scanner;

public class BOJ1316_string {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());

		String[] words = new String[N];
		boolean[] ans = new boolean[N];
		int answer = 0;

		for (int i = 0; i < N; i++) {
			words[i] = sc.nextLine();
		}

		for (int i = 0; i < N; i++) {
			String[] alpha = words[i].split("");
			int count = 1;
			for (int j = 0; j < alpha.length - 1; j++) {
				if (alpha[j].equals(alpha[j + 1])) {
					count++;
				} else {
					String removed = words[i].replace(alpha[j], "");
					if (words[i].length() - count != removed.length()) {
						ans[i] = true;
						break;
					}
					count = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			if (!ans[i]) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}