package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ16235_st {
	static int N, M, K, A[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 땅
		M = Integer.parseInt(st.nextToken()); // 구매한 나무 개수
		K = Integer.parseInt(st.nextToken()); // k년이 지난후 나무의 개수
		A = new int[N][N];
		int[][] land = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				land[i][j] = 5;
			}
		} // 겨울에 추가되는 양분 리스트
			// 나무
			// 나무의 나이 기준으로 정렬 할 거
		Deque<Integer>[][] namu = new ArrayDeque[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				namu[i][j] = new ArrayDeque<Integer>();
			}
		} // 리스트 생성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			namu[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1]
					.add(Integer.parseInt(st.nextToken()));
		} // 나무 넣기
		for (int k = 0; k < K; k++) { // K 년동안 반복
			// 봄
			int[][] dead = new int[N][N]; // 양분 저장해둘 공간
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int size = namu[i][j].size();
					for (int s = 0; s < size; s++) {
						int tree = namu[i][j].poll();
						if (land[i][j] >= tree) {
							land[i][j] -= tree;
							namu[i][j].addLast(tree + 1);
						} else {
							dead[i][j] += (tree / 2); // 죽은 나무 나이 2로 나눈거
						}

					}
				}
			} // 봄
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					land[i][j] += dead[i][j] + A[i][j];
				}
			} // 여름 죽은 나무의 나이를 2로 나눈 값이 양분으로 추가
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int tree : namu[i][j]) {
						if (tree % 5 == 0) {
							if (i > 0 && j > 0) {
								namu[i - 1][j - 1].addFirst(1);
							}
							if (i > 0)
								namu[i - 1][j].addFirst(1);
							if (i > 0 && j < N - 1)
								namu[i - 1][j + 1].addFirst(1);
							if (j > 0)
								namu[i][j - 1].addFirst(1);
							if (j < N - 1)
								namu[i][j + 1].addFirst(1);
							if (i < N - 1 && j > 0)
								namu[i + 1][j - 1].addFirst(1);
							if (i < N - 1)
								namu[i + 1][j].addFirst(1);
							if (i < N - 1 && j < N - 1)
								namu[i + 1][j + 1].addFirst(1);
						}
					}
				}
			} // 가을 : 번식 나무의 나이가 5의 배수이면, 인접한 8개 칸에 추가
			/*
			 * for( int i = 0 ; i< N; i++) { for ( int j = 0; j< N ; j++) {
			 * land[i][j]+=A[i][j]; } } // 겨울 : S2D2가 땅에 양분 추가
			 */
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans += namu[i][j].size();
			}
		}
		System.out.println(ans);

	}
}