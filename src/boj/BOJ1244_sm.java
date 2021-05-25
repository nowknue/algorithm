package boj;

import java.util.Scanner;

public class BOJ1244_sm {

	static int number, stuNumber;
	static int[] status;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		number = sc.nextInt() + 1;

		status = new int[number];
		for (int i = 1; i < number; i++) {
			status[i] = sc.nextInt();
		}

		stuNumber = sc.nextInt(); // 학생 수
		for (int i = 1; i <= stuNumber; i++) {
			int sex = sc.nextInt(); // 성별
			int key = sc.nextInt(); // 받은 키 번호

			// 남자라면
			if (sex == 1) {
				// key의 배수 스위치 토글
				for (int j = key; j < number; j += key) {
					status[j] ^= 1;
				}
			}

			// 여자라면
			else if (sex == 2) {
				// 양쪽 대칭 중 가장 긴거 찾자
				int LP = key - 1;
				int RP = key + 1;

				while (true) {
					if (LP < 1 || RP >= number)
						break;
					if (status[LP] != status[RP]) {
						break;
					}
					LP--;
					RP++;
				}

				LP++;
				RP--;
				for (; LP <= RP; LP++) {
					status[LP] ^= 1;
				}
			}
		}
		for (int j = 1; j < number; j++) {
			System.out.print(status[j] + " ");
			if (j % 20 == 0)
				System.out.println();
		}

		sc.close();
	}
}