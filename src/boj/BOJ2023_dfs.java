package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2023_dfs {
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dfs("2", 1);
		dfs("3", 1);
		dfs("5", 1);
		dfs("7", 1);

		System.out.print(sb.toString());
	}

	public static void dfs(String str, int idx) {
		if (idx == N) {
			sb.append(str);
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= 9; i++) {
			String current = str + "" + i;
			if (flag(Integer.parseInt(current)))
				dfs(current, idx + 1);
		}
	}

	public static boolean flag(int num) {
		if (num == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}