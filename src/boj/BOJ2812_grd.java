package boj;

import java.util.Scanner;

public class BOJ2812_grd {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int num = sc.nextInt();
		int solution = solution(N, K, num);

		System.out.println(solution);
	}
	
	public static int solution(int N, int K, int num) {
		int n = N;
		int k = K;
		int number = num;
		String numStr = Integer.toString(number);
		String[] arr = new String[n];

		arr = numStr.split("");

		int i = 0;
		int j = 0;
		while (j != k) {
			if (i == n - 1) {
				break;
			} else {
				if (Integer.parseInt(arr[i]) < Integer.parseInt(arr[i + 1])) {
					arr[i] = "-1";
					j++;
				}
				i++;
			}
		}
		
		for (int idx = n - 1; j != k; idx--) {
			arr[idx] = "-1";
			j++;
		}
		
		String str = "";
		for (int idx = 0; idx < arr.length; idx++) {
			str += arr[idx];
		}
		str = str.replace("-1", "");

		int answer = Integer.parseInt(str);

		return answer;
	}
}