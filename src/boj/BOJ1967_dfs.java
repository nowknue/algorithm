package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
         
public class BOJ1967_dfs {

	private static class Node {
		int next, value;

		Node(int next, int value) {
			this.next = next;
			this.value = value;
		}
	}

	static int N, max = -1, starting;
	static boolean[] visit;
	static ArrayList<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		init();

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int value = stoi(st.nextToken());
			list[a].add(new Node(b, value));
			list[b].add(new Node(a, value));
		}

		visit = new boolean[N + 1];
		dfs(0, 1);

		visit = new boolean[N + 1];
		dfs(0, starting);

		System.out.println(max);
	}

	private static void dfs(int length, int now) {
		if (max < length) {
			max = length;
			starting = now;
		}

		for (Node n : list[now]) {
			if (!visit[n.next]) {
				visit[n.next] = true;
				dfs(length + n.value, n.next);
			}
		}
	}

	private static void init() {
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}
