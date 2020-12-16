package boj;

import java.util.*;

// 다시 정독해보기
public class BOJ14499_st {
	public static int[][] array; // 지도에 쓰여있는 수
	public static int[] dice; // 주사위 (위, 뒤, 오른, 왼, 앞, 바닥) 순서
	public static int N; // 세로 크기
	public static int M; // 가로 크기
	public static int x; // 주사위가 놓인 세로 좌표
	public static int y; // 주사위가 놓인 가로 좌표

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		x = scan.nextInt();
		y = scan.nextInt();
		int k = scan.nextInt(); // 명령 개수

		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				array[i][j] = scan.nextInt();
			}
		}

		dice = new int[6]; // 주사위 모든 면 0으로 초기화
		for (int i = 0; i < k; i++) {
			int order = scan.nextInt(); // 명령

			go(order, x, y);
		}
	}

	/* 이동하여 주사위 윗 면에 쓰여있는 수를 출력하는 함수 */
	static void go(int order, int r, int c) {
		if (order == 1) { // 동쪽 이동
			if ((c + 1) >= 0 && (c + 1) < M) {
				diceTurn(order);
				if (array[r][c + 1] == 0) { // 칸에 쓰여있는 수가 0이면
					array[r][c + 1] = dice[5]; // 주사위 바닥을 칸에
				} else {
					dice[5] = array[r][c + 1]; // 칸에 쓰여있는 것을 주사위 바닥에 복사
					array[r][c + 1] = 0; // 칸은 0으로 변경
				}
				// 주사위가 놓인 좌표 갱신하고 주사위 윗면 출력
				x = r;
				y = c + 1;
				System.out.println(dice[0]);
			} else
				return;
		} else if (order == 2) { // 서쪽 이동
			if ((c - 1) >= 0 && (c - 1) < M) {
				diceTurn(order);
				if (array[r][c - 1] == 0) {
					array[r][c - 1] = dice[5];
				} else {
					dice[5] = array[r][c - 1];
					array[r][c - 1] = 0;
				}
				x = r;
				y = c - 1;
				System.out.println(dice[0]);
			} else
				return;
		} else if (order == 3) { // 북쪽 이동
			if ((r - 1) >= 0 && (r - 1) < N) {
				diceTurn(order);
				if (array[r - 1][c] == 0) {
					array[r - 1][c] = dice[5];
				} else {
					dice[5] = array[r - 1][c];
					array[r - 1][c] = 0;
				}
				x = r - 1;
				y = c;
				System.out.println(dice[0]);
			} else
				return;
		} else if (order == 4) { // 남쪽 이동
			if ((r + 1) >= 0 && (r + 1) < N) {
				diceTurn(order);
				if (array[r + 1][c] == 0) {
					array[r + 1][c] = dice[5];
				} else {
					dice[5] = array[r + 1][c];
					array[r + 1][c] = 0;
				}
				x = r + 1;
				y = c;
				System.out.println(dice[0]);
			} else
				return;
		}
	}

	/* 이동 시, 주사위 모양을 갱신하는 함수 */
	static void diceTurn(int order) {
		int temp = 0;

		if (order == 1) { // 동쪽 이동
			temp = dice[5];
			dice[5] = dice[2];
			dice[2] = dice[0];
			dice[0] = dice[3];
			dice[3] = temp;
		} else if (order == 2) { // 서쪽 이동
			temp = dice[5];
			dice[5] = dice[3];
			dice[3] = dice[0];
			dice[0] = dice[2];
			dice[2] = temp;
		} else if (order == 3) { // 북쪽 이동
			temp = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[0];
			dice[0] = dice[4];
			dice[4] = temp;
		} else if (order == 4) { // 남쪽 이동
			temp = dice[5];
			dice[5] = dice[4];
			dice[4] = dice[0];
			dice[0] = dice[1];
			dice[1] = temp;
		}
		return;
	}

}