package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2668_dfs {
	static int n;
	static int[] arr;
	static boolean[] visited;
	static Set<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[i] = a;
		}
		// i부터 시작해서 자기 자신인 i로 돌아와야하며, 그 때의 conunt인 1로 초기화 해준다.
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			dfs(i, i, 1);
		}
		// set은 오름차순이 안되므로 iterator을 사용해 arrayList에 넣어주고 정렬 후 출력한다.
		System.out.println(set.size());
		ArrayList<Integer> result = new ArrayList<Integer>();
		Iterator<Integer> it = set.iterator();

		while (it.hasNext()) {
			result.add(it.next());
		}

		Collections.sort(result);

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}

	// 만약 arr[start] = end가 같다면 사이클을 돌아 자신으로 돌아오거나,
	// 처음부터 index와 value가 같은 것이므로 set에 넣어준다.
	// 만약 count가 n보다 커지면 종료하고 그렇지 않으면 conut를 추가해서 다시 실행한다.
	static void dfs(int start, int end, int count) {
		if (arr[start] == end) {
			set.add(end);
		}

		if (count > n) {
			return;
		}

		dfs(arr[start], end, count + 1);
	}
}