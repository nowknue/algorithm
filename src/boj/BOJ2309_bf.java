package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309_bf {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
 
        for(int i =0; i<9; i++){
            arr[i] = sc.nextInt();
        }
        
        for(int i=0; i<9; i++){
            int num = Arrays.stream(arr).sum()-arr[i]-100;                                              
 
            for(int j=0; j<9; j++){
                if(j==i){
                    continue;
                }
                if(arr[j]==num){
                    arr[j]=0;
                    arr[i]=0;
                }
            }
        }
         Arrays.sort(arr);
        for(int i=2; i<9; i++){
            System.out.println(arr[i]);
        }
	}
}