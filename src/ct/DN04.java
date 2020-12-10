package ct;

import java.util.ArrayList;
import java.util.Arrays;

// 처음부터 문제 파악 잘하고 리스트로 했어야함.
public class DN04 {
	public static int[] solution(int[][] customer, int K) {
		int[][] cust = customer;
		int k = K;
		int[] room = new int[k];
		ArrayList<Integer> waitList = new ArrayList<>();

		for (int i = 0; i < room.length; i++) {
			room[i] = -1;
		}

		for (int i = 0; i < cust.length; i++) {
			if (cust[i][1] == 0) {
				for (int j = 0; j < k; j++) {
					if (room[j] == cust[i][0]) {
						room[j] = -1;
						if (!waitList.isEmpty()) {
							room[j] = waitList.get(0);
							waitList.remove(0);
						}
						break;
					} else {
						if (j == k - 1) {
							// 대기열에 있는데 취소한 경우
							for (int idx = 0; idx < waitList.size(); idx++) {
								if (waitList.get(idx) == cust[i][0]) {
									waitList.remove(idx);
									break;
								}
							}
						}
					}
				}
			} else {
				for (int j = 0; j < k; j++) {
					if (room[j] == -1) {
						room[j] = cust[i][0];
						break;
					} else {
						if (j == k - 1) {
							waitList.add(cust[i][0]);
						}
					}
				}
			}
		}

		ArrayList<Integer> answerList = new ArrayList<>();
		for (int i = 0; i < room.length; i++) {
			if (room[i] != -1) {
				answerList.add(room[i]);
			}
		}

		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}

		Arrays.sort(answer);

		return answer;
	}

	public static void main(String args[]) {
		int[][] s = { { 1, 1 }, { 2, 1 }, { 3, 1 }, { 2, 0 }, { 2, 1 } };
		int K = 2;

		int[] solution = solution(s, K);

		System.out.println(solution);
	}

}