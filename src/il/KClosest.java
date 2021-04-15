package il;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {

   public static void main(String[] args) {
      KClosest a = new KClosest();
      
      int[][] points = {{1,3}, {-2,2}};
      int k = 1;
      
      int[][] result = a.solve(points, k);
      a.print(result);
   }

   public int[][] solve(int[][] points, int k) {
      //1
      Queue<int[]> pq = new PriorityQueue<>((a,b) ->
      (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
      
      int[][] result = new int[k][points[0].length];
      
      //2
      for (int[] p : points) {
         pq.add(p);
      }
      int index = 0;
      while (index < k) {
         result[index] = pq.poll();
         index++;
      }
      
      return result;
   }
   
   public void print(int[][] result) {
      for (int i = 0; i < result.length; i++) {
         for (int j = 0; j < result[i].length; j++) {
            System.out.print(" [" + i + "][" + j + "] " + result[i][j]);
         }
         System.out.println();
      }
   }
}