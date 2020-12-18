package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ3190_st {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		// 뱀 표시
		map[1][1] = 2;

		aCnt = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int y, x;
		for (int i = 0; i < aCnt; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			map[y][x] = 1;
		}

		rCnt = Integer.parseInt(br.readLine());
		int time;
		String dir;
		for (int i = 0; i < rCnt; i++) {
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			dir = st.nextToken();
			times.add(new rotate(time, dir));
		}

		simulation();
	}

	static int N, aCnt, rCnt;
	// 0 빈칸, 1 사과, 2 뱀
	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static LinkedList<rotate> times = new LinkedList<rotate>();

	static class rotate {
		int time;
		String dirString;

		public rotate(int time, String dirString) {
			this.time = time;
			this.dirString = dirString;
		}
	}

	static void simulation() {

		// 0초는 위치 (1,1) 이므로 1초부터 시작
		int time = 1;
		LinkedList<Trace> trace = new LinkedList<Trace>();
		trace.add(new Trace(1, 1, 1));

		rotate rotateTime = times.removeFirst();

		int ny = 1, nx = 1, dir = 1;
		while (true) {
			// 매 초마다 아래와 같이 이동.
			// time초에 이동
			ny += delta[dir][0];
			nx += delta[dir][1];

			if (!(ny >= 1 && ny <= N && nx >= 1 && nx <= N) || map[ny][nx] == 2) {
				// 범위 밖이거나, 뱀
				break;
			} else if (map[ny][nx] == 1) {
				// 사과
				trace.add(new Trace(ny, nx, dir));
				map[ny][nx] = 2;
			} else {
				// 이동가능하며 아무것도 없다. 꼬리 제거
				trace.add(new Trace(ny, nx, dir));
				map[ny][nx] = 2;
				Trace tail = trace.removeFirst();
				map[tail.y][tail.x] = 0;
			}

			// time초 이동 완료
			// 게임 시작으로 부터 x초가 끝난 뒤 방향을 바꾼다.
			if (rotateTime.time == time) {
				if (rotateTime.dirString.equals("D")) {
					dir = (dir + 1) % 4;
				} else {
					dir = (dir + 3) % 4;
				}
				if (times.size() > 0)
					rotateTime = times.removeFirst();
			}
			time++;
		}
		System.out.println(time);
	}

	static class Trace {
		int y, x, dir;

		public Trace(int y, int x, int dir) {
			this.y = y;
			this.x = x;
			this.dir = dir;
		}
	}
}