package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ14500_st {
    static int N;
    static int M;
    static int R;
    static int C;
    static int[][] map;
    static int max = 0;
    static ArrayList<Pair> list1 = new ArrayList<>();
    static ArrayList<Pair> list2 = new ArrayList<>();
    static ArrayList<Pair> list3 = new ArrayList<>();
    static ArrayList<Pair> list4 = new ArrayList<>();
    static ArrayList<Pair> list5 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];

        list1.add(new Pair(0, 0));
        list1.add(new Pair(0, 1));
        list1.add(new Pair(0, 2));
        list1.add(new Pair(0, 3));
        list2.add(new Pair(0, 0));
        list2.add(new Pair(0, 1));
        list2.add(new Pair(1, 0));
        list2.add(new Pair(1, 1));
        list3.add(new Pair(0, 0));
        list3.add(new Pair(1, 0));
        list3.add(new Pair(2, 0));
        list3.add(new Pair(2, 1));
        list4.add(new Pair(0 ,0));
        list4.add(new Pair(1 ,0));
        list4.add(new Pair(1 ,1));
        list4.add(new Pair(2 ,1));
        list5.add(new Pair(0, 0));
        list5.add(new Pair(0, 1));
        list5.add(new Pair(0, 2));
        list5.add(new Pair(1, 1));

        for(int i=0; i<N; i++) {
            String[] str = br.readLine().split(" ");
            for(int j=0; j<M; j++)
                map[i][j] = Integer.parseInt(str[j]);
        }

        R=1;
        C=4;
        for(int i=0; i<2; i++) {
            attach(list1);
            turnClock(list1);
        }

        R=2;
        C=2;
        attach(list2);

        R=3;
        C=2;
        for(int i=0; i<4; i++) {
            attach(list3);
            turnClock(list3);
        }
        symmetry(list3);
        for(int i=0; i<4; i++) {
            attach(list3);
            turnClock(list3);
        }

        R=3;
        C=2;
        for(int i=0; i<2; i++) {
            attach(list4);
            turnClock(list4);
        }
        symmetry(list4);
        for(int i=0; i<2; i++) {
            attach(list4);
            turnClock(list4);
        }

        R=2;
        C=3;
        for(int i=0; i<4; i++) {
            attach(list5);
            turnClock(list5);
        }

        System.out.println(max);
    }

    static void attach(ArrayList<Pair> list) {

        for (int i = 0; i < N - R + 1; i++) {
            for (int j = 0; j < M - C + 1; j++) {
                ArrayList<Pair> tempList = new ArrayList<>(list);
                int sum = 0;

                while (!tempList.isEmpty()) {
                    Pair temp = tempList.remove(0);
                    sum += map[i + temp.x][j + temp.y];
                }
                max = Math.max(max, sum);
            }
        }
    }

    static void turnClock(ArrayList<Pair> list) {
        int t=R;
        R = C;
        C = t;
        int leng = list.size();

        for(int i=0; i<leng; i++) {
            Pair temp = list.remove(0);
            list.add(new Pair(temp.y, C-temp.x-1));
        }
    }

    static void symmetry(ArrayList<Pair> list) {
        int leng = list.size();

        for(int i=0; i<leng; i++) {
            Pair temp = list.remove(0);
            if(temp.y==0)
                list.add(new Pair(temp.x, 1));
            if(temp.y==1)
                list.add(new Pair(temp.x, 0));
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}