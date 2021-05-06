package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ15961_sw {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);
        int max;
        int[] arr = new int[N];
        int[] visited = new int[3000001];
        int cnt= 0;

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<k; i++) {
            int num = arr[i%N];

            if(visited[num]==0)
                cnt++;

            visited[num]++;
        }

        max = cnt;

        for(int i=0; i<N-1; i++) {
            int head = arr[i];
            int tail = arr[(i+k)%N];

            if(visited[head]==1)
                cnt--;

            visited[head]--;

            if(visited[tail]==0)
                cnt++;

            visited[tail]++;

            if(visited[c]==0)
                cnt++;

            max = Math.max(max, cnt);

            if(visited[c]==0)
                cnt--;
        }

        System.out.println(max);
    }
}