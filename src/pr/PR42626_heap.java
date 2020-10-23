package pr;

import java.util.*;

public class PR42626_heap {   
   public static void main(String[] args) {
	   int[] sco = {1, 2, 3, 9, 10, 12};
       System.out.println(solution(sco, 7));
   }   
     
   public static int solution(int[] scoville, int K) {
       int answer = 0;
       PriorityQueue<Integer> heap = new PriorityQueue();

       for (int aScoville : scoville) {
           heap.offer(aScoville);
       }

       while (heap.peek() <= K) {
           if (heap.size() == 1) {
               return -1;
           }
           int a = heap.poll();
           int b = heap.poll();


           int result = a + (b * 2);

           heap.offer(result);
           answer ++;
       }
       return answer;
   }
}
