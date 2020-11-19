package boj;

import java.util.Scanner;

public class BOJ10162_bf {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int time;
		time = sc.nextInt();
		
		String times = "";
		
		times += time/300;
		time = time%300;
		
		times += " ";
		
		times += time/60;
		time = time%60;
		
		times += " ";
		
		times += time/10;
		time = time%10;
		
		if (time == 0) {
			System.out.println(times);
		} else {
			System.out.println(-1);
		}
	}
}