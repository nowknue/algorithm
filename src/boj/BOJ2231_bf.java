package boj;

import java.util.Scanner;

public class BOJ2231_bf {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(generator(n));

	}
	
	static int bunhaehap( int before) { //분해합 구하는 함수 
		int ans =before;
		while( before > 0) {
			ans += before %10;
			before /= 10;
		}
		return ans;
	}
	
	static int generator( int num) { //N의 가장 작은 생성자를 구하는 함수 
		int temp = num-1;
		int ans = num;
		while( temp >0 ) {
			if( bunhaehap(temp ) == num) {
				if( ans > temp) ans = temp;
			}
			temp--;
		}
		
		if( ans == num) return 0;
		else return ans;
	}

}