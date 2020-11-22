package boj;

import java.util.Scanner;

// 소스가 약간 난잡한듯 해서 dx dy 쓰는식으로 수정해보
class BOJ14503_imp {
	static int N, M, r, c, d;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		arr = new int[N][M];
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		while (true) {
			if (arr[r][c] != -1) {
				answer++;
				arr[r][c] = -1;
			}
			int cnt = 0;
			boolean isGo = true;
			
			turnLeft();
			while(!go()) {
				if (++cnt == 4) {
					isGo = false;
					break;
				}
				turnLeft();
			}
			
			if (isGo) {
				continue;
			}
			
			if(goBack()) {
				continue;
			} else {
				break;
			}

		}
		
		System.out.println(answer);
		
	}
	
	static void turnLeft() {
		if (d == 0) {
			d = 3;
		} else if (d == 1) {
			d = 0;
		} else if (d == 2) {
			d = 1;
		} else {
			d = 2;
		}
	}

	static boolean go () {
		if (d == 0) {
			if (arr[r - 1][c] == 0) {
				r--;
				return true;
			} else {
				return false;
			}
		} else if (d == 1) {
			if (arr[r][c + 1] == 0) {
				c++;
				return true;
			} else {
				return false;
			}
		} else if (d == 2) {
			if (arr[r + 1][c] == 0) {
				r++;
				return true;
			} else {
				return false;
			}
		} else {
			if (arr[r][c - 1] == 0) {
				c--;
				return true;
			} else {
				return false;
			}
		}
	}
		
	static boolean goBack () {
		if (d == 0) {
			if (arr[r + 1][c] != 1) {
				r++;
				return true;
			} else {
				return false;
			}
		} else if (d == 1) {
			if (arr[r][c - 1] != 1) {
				c--;
				return true;
			} else {
				return false;
			}
		} else if (d == 2) {
			if (arr[r - 1][c] != 1) {
				r--;
				return true;
			} else {
				return false;
			}
		} else {
			if (arr[r][c + 1] != 1) {
				c++;
				return true;
			} else {
				return false;
			}
		}
	}

}