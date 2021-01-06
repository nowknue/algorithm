package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14890_st {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {// 가로로 두는 경사로
			int a = arr[i][0]; // 현재 높이
			boolean[] v = new boolean[N]; // 가로 검사용
			int j = 1;
			jloop: for (; j < N; j++) {
				if (arr[i][j] == a)
					continue;
				if (j >= L && arr[i][j] == a + 1) {// 만약 높으면?
					int l = 1;
					for (; l <= L; l++) {
						if (v[j - l])
							break jloop;
					}
					if (l > L) {
						v[j - 1] = true;
						a += 1; // 현재 높이
					}
				} else if (arr[i][j] == a - 1) {// 만약 한칸 낮으면
					int l = 1;
					for (; l < L && j + L <= N; l++) {
						if (arr[i][j + l] != a - 1)
							break jloop;
					}
					if (l == L) {
						v[j + l - 1] = true;
						j += (L - 1);
						a -= 1;
					} else
						break jloop;
				} else
					break jloop;
			}
			if (j == N)
				ans++;
		}
		for (int j = 0; j < N; j++) {// 세로로 두는 경사로
			int a = arr[0][j]; // 현재 높이
			boolean[] v = new boolean[N]; // 세로 검사용
			int i = 1;
			iloop: for (; i < N; i++) {
				if (arr[i][j] == a)
					continue;
				if (i >= L && arr[i][j] == a + 1) {// 만약 높으면?
					int l = 1;
					for (; l <= L; l++) {
						if (v[i - l])
							break iloop;
					}
					if (l > L) {
						v[i - 1] = true;
						a += 1; // 현재 높이
					}
				} else if (arr[i][j] == a - 1) {// 만약 한칸 낮으면
					int l = 1;
					for (; l < L && i + L - 1 < N; l++) {
						if (arr[i + l][j] != a - 1)
							break iloop;
					}
					if (l == L) {
						v[i + l - 1] = true;
						i += (L - 1);
						a -= 1;
					} else
						break iloop;
				} else
					break iloop;
			}
			if (i == N)
				ans++;
		}
		System.out.println(ans);
	}
}