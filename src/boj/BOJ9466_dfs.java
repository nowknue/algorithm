package boj;

import java.util.*;

class BOJ9466_dfs {
	static int a[];
	static int check[]; // 방문 check(시작에서부터 몇번째로 방문되는 것인지)
	static int startVertex[]; // 시작정점
	static int answer = 0;

	static void dfs(int i, int cnt, int start) {

		if (check[i] != 0) { // 이미 방문했던 정점이라면
			if (start != startVertex[i]) { // 시작 정점과 같지 않은지 확인
				return; // 같지않다면 0리턴
			}
			answer = answer - (cnt - check[i]); // 방문수에서 몇번쨰로 방문한 수만큼 뺀 값을 총인원에서 뺌 
			return;
		}

		check[i] = cnt; // 몇번째 방문한건지 저장
		startVertex[i] = start;
		dfs(a[i], cnt + 1, start); // 가리키는 정점, +1번째 방문, start그대로
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();

		for (int t = 0; t < test_case; t++) {
			int n = sc.nextInt();
			a = new int[n + 1];
			check = new int[n + 1];
			startVertex = new int[n + 1];
			answer = n;	

			for (int i = 1; i <= n; i++)
				a[i] = sc.nextInt();

			for (int i = 1; i <= n; i++) {
				if (check[i] == 0)
					dfs(i, 1, i);
			}

			System.out.println(answer);
		}
	}
}