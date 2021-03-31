package ct;

import java.util.LinkedList;
import java.util.Queue;

/*

 */

//300000짜리 while 안에 10000짜리 for 넣으면 안됨
public class GB03 {
   public static int[] solution(int N, int[] coffee_times) {
      int makers = N;
      int[] times = coffee_times;
      
      int[] making = new int[makers + 1];
        int[] answer = new int[times.length];
        int[] indexes = new int[times.length];
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int time : times) {
           queue.add(time);
        }
        int endCount = 0;
        int index = 1;
        while(answer[times.length - 1] == 0) {
           if (!queue.isEmpty()) {
              for (int i = 1; i < making.length; i++) {
                 if (making[i] == 0) {
                    making[i] = queue.poll();
                    indexes[i] = index++;
                 }
              }
           }
           
           int min = Integer.MAX_VALUE;
           for (int i = 1; i < making.length; i++) {
              if (making[i] < min && making[i] > 0) {
                 min = making[i];
              }
           }
           
           for (int i = 1; i < making.length; i++) {
              making[i] = making[i] - min; 
              if (making[i] == 0) {
                 answer[endCount++] = indexes[i];
              }
           }
        }
        
        return answer;
    }


   public static void main(String args[]) {
      int N = 3;
      int[] c = {4, 2, 2, 5, 3};
      
      int[] solution = solution(N, c);

      System.out.println(solution[0]);
      System.out.println(solution[1]);
      System.out.println(solution[2]);
      System.out.println(solution[3]);
      System.out.println(solution[4]);
   }

}