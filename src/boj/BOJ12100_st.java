package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12100_st {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		o_map = new int[N][N];
		map = new int[N][N];
		used = new boolean[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				o_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(ans);
	}

	static int N;
	static int[][] o_map, map;

	static int[] moveDir = new int[5];
	static boolean[][] used;
	static int ans = 2;

	static void dfs(int mi) {

		if (mi == 5) {
			// 오리지널 맵을 맵으로 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = o_map[i][j];
				}
			}

			// 정해진대로 이동 시작
			int ny, nx, val;
			for (int m = 0; m < 5; m++) {
				// 매 이동마다 used[y][x] 초기화.
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						used[i][j] = false;
					}
				}
				int dir = moveDir[m];
				if (dir == 0) { // 위로 이동
					for (int x = 0; x < N; x++) {
						for (int y = 1; y < N; y++) {
							if (map[y][x] == 0)
								continue;
							// next y
							ny = y - 1;
							// 현재 이동할 값을 val로 빼주고 map에는 0으로 표시
							val = map[y][x];
							map[y][x] = 0;
							// 범위가 밖이 되거나, 값이 0이 아닐때까지 이동
							while (ny >= 0 && map[ny][x] == 0) {
								ny += delta[dir][0];
							}
							if (ny < 0) {
								// 범위 밖
								map[0][x] = val;
							} else if (val == map[ny][x] && !used[ny][x]) {
								// 같은 값이며 사용안됨. => 합치기
								used[ny][x] = true;
								map[ny][x] = 2 * val;
							} else {
								// 합치기 불가. 가장 위(최근)에 0으로 이동
								int rev = dir == 0 || dir == 2 ? 2 - dir : 4 - dir;
								ny += delta[rev][0];
								map[ny][x] = val;
							}
						}
					}
				} else if (dir == 2) { // down
					for (int x = 0; x < N; x++) {
						for (int y = N - 2; y >= 0; y--) {
							if (map[y][x] == 0)
								continue;
							ny = y + 1;
							val = map[y][x];
							map[y][x] = 0;
							while (ny < N && map[ny][x] == 0) {
								ny += delta[dir][0];
							}
							if (ny == N) {
								// 범위 밖
								map[N - 1][x] = val;
							} else if (val == map[ny][x] && !used[ny][x]) {
								// 같은 값이며 사용안됨. => 합치기
								used[ny][x] = true;
								map[ny][x] = 2 * val;
							} else {
								// 합치기 불가. 마지막 0으로 이동
								int rev = dir == 0 || dir == 2 ? 2 - dir : 4 - dir;
								ny += delta[rev][0];
								map[ny][x] = val;
							}
						}
					}
				} else if (dir == 1) { // 오른쪽
					for (int y = 0; y < N; y++) {
						for (int x = N - 2; x >= 0; x--) {
							if (map[y][x] == 0)
								continue;
							nx = x + 1;
							val = map[y][x];
							map[y][x] = 0;
							while (nx < N && map[y][nx] == 0) {
								nx += delta[dir][1];
							}
							if (nx == N) {
								// 범위 밖
								map[y][N - 1] = val;
							} else if (val == map[y][nx] && !used[y][nx]) {
								// 같은 값이며 사용안됨. => 합치기
								used[y][nx] = true;
								map[y][nx] = 2 * val;
							} else {
								// 합치기 불가. 마지막 0으로 이동
								int rev = dir == 0 || dir == 2 ? 2 - dir : 4 - dir;
								nx += delta[rev][1];
								map[y][nx] = val;
							}
						}
					}
				} else { // 왼쪽
					for (int y = 0; y < N; y++) {
						for (int x = 1; x < N; x++) {
							if (map[y][x] == 0)
								continue;
							nx = x - 1;
							val = map[y][x];
							map[y][x] = 0;
							while (nx >= 0 && map[y][nx] == 0) {
								nx += delta[dir][1];
							}
							if (nx == -1) {
								// 범위 밖
								map[y][0] = val;
							} else if (val == map[y][nx] && !used[y][nx]) {
								// 같은 값이며 사용안됨. => 합치기
								used[y][nx] = true;
								map[y][nx] = 2 * val;
							} else {
								// 합치기 불가. 마지막 0으로 이동
								int rev = dir == 0 || dir == 2 ? 2 - dir : 4 - dir;
								nx += delta[rev][1];
								map[y][nx] = val;
							}
						}
					}
				}
			}

			// 가장 큰 ans 값 찾기
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if (map[y][x] == 0)
						continue;
					if (ans < map[y][x])
						ans = map[y][x];
				}
			}
			return;
		}

		// mi번째에 4방향으로 하나씩 시도해본다.
		for (int m = 0; m < 4; m++) {
			moveDir[mi] = m;
			dfs(mi + 1);
		}
	}

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
}