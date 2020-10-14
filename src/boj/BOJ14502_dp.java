package boj;

import java.util.Scanner;

public class BOJ14502_dp {
	static int[][] array = new int[8][8];
	static int[][] wall_visited = new int[8][8];
	static int[][] virus_visited = new int[8][8];
	static int[][] temp = new int[8][8];
	static int N, M;
	static int wall_count = 0;
	
	static int clear_count = 0;
	static int max_count = 0;

	static int[] x_dir = { -1, 1, 0, 0 };
	static int[] y_dir = { 0, 0, -1, 1 };
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		
		int i, j;
		for(i = 0; i < N; i++){
			for(j = 0; j < M; j++){
				array[i][j] = scan.nextInt();
			}
		}
		for(i = 0; i < N; i++){
			for(j = 0; j < M; j++){
				if(wall_visited[i][j] == 0 && array[i][j] == 0){
					wall_DFS(i,j);
				}
			}
		}
		
		System.out.println(max_count);
		
	}
	
	static void wall_DFS(int x, int y){
		wall_visited[x][y] = 1;
		wall_count++;
		int i, j;
		
		if(wall_count == 3){
			for(i = 0; i < N; i++){
				for(j = 0; j < M; j++){
					temp[i][j] = array[i][j];
					if(wall_visited[i][j] == 1){
						temp[i][j] = wall_visited[i][j];
					}
				}
			}

			for(i = 0; i < N; i++){
				for(j = 0; j < M; j++){
					if(temp[i][j] == 2 && virus_visited[i][j] == 0){
						virus_DFS(i, j);
					}
				}
			}

			clear_count = 0;
			for(i = 0; i < N; i++){
				for(j = 0; j < M; j++){
					if(temp[i][j] == 0) clear_count++;
				}
			}
			if(clear_count > max_count)	max_count = clear_count;
			for(i = 0; i < N; i++){
				for(j = 0; j < M; j++){
					virus_visited[i][j] = 0;
				}
			}
			
			wall_visited[x][y] = 0;
			wall_count--;
			return;
		}
		
		for(i = 0; i < N; i++){
			for(j = 0; j < M; j++){
				if(wall_visited[i][j] == 0 && array[i][j] == 0){
					wall_DFS(i, j);
				}
			}
		}
		wall_visited[x][y] = 0;
		wall_count--;
		
	}
	
	static void virus_DFS(int x, int y){
		virus_visited[x][y] = 1;
		temp[x][y] = 2;
	
		int next_x, next_y;
		int i;
		for(i = 0; i < 4; i++){
			next_x = x + x_dir[i];
			next_y = y + y_dir[i];
			if(next_x >=0 && next_x < N && next_y >= 0 && next_y < M){
				if(virus_visited[next_x][next_y] == 0 && temp[next_x][next_y] == 0){
					virus_DFS(next_x, next_y);
				}
			}
		}
		
	}
}