package ct;

import java.util.ArrayList;
import java.util.HashMap;

/*

 */
public class KC02 {
   public static int solution(int[][] needs, int r) {
      int[][] wants = needs;
      int robots = r;
        int answer = 0;
        
        ArrayList<Integer> diffList = new ArrayList<>();
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < diffList.size(); i++) {
           if (countMap.containsKey(diffList.get(i))) {
              countMap.put(diffList.get(i), countMap.get(diffList.get(i)) + 1);
           } else {
              countMap.put(diffList.get(i), 1);
           }
        }
        
        int[] arr = new int[wants[0].length];
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
           arr[i] = i;
        }
        
        int[] combArr = new int[n];
        doCombination(combArr, n, robots, 0, 0, arr, wants);
        
        
        for (int i = 0; i < robots - 1; i++) {
           for (int j = 0; j < robots; j++) {
              System.out.println(i + " @@ " + j);
           }
        }
        
        for (int i = 0; i < wants[0].length; i++) {
           for (int j = 0; j < robots; j++) {
              if (wants[i][j] == 0) {
                 break;
              }
              if (j == robots - 1) {
                 
              }
           }
        }

        
        
        
        return answer;
    }
   
   public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr, int[][] wants){
        if(r == 0){
           for (int j = 0; j < wants.length; j++) {
            for (int i = 0; i < index; i++) {
               //System.out.print(j + "번째 완제품 " + arr[combArr[i]] + " ");
               System.out.print(j + "번째 완제품 " + arr[combArr[i]] + "번 부품이 필요한지는 " + wants[j][arr[combArr[i]]] + "     ");
                 if (wants[j][arr[combArr[i]]] == 0) {
                    break;
                 }
                 if (arr[combArr[i]] == r + 1) {
                    System.out.println(j + " 정답?");
                 }
              }
            System.out.println();
         }
           
           System.out.println("^^^^^^^^^^^^^^^^^^");
        }else if(target == n) return;
        else{
            combArr[index] = target;
            doCombination(combArr, n, r-1, index+1, target+1, arr, wants); // (i)
            doCombination(combArr, n, r, index, target+1, arr, wants); //(ii)
        }
    }

   public static long nCr(int n, int r) {
      if (r > n)
         return -1;
      if (r == 0)
         return 1;
      if (n == r)
         return 1;
      if (n - r < r)
         r = n - r;
      long res = 1;
      for (int i = 1; i <= r; i++)
         res = res * (n - i + 1) / i;
      return res;
   }

   public static void main(String args[]) {
      int[][] needs = {{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
      int r = 2;
      int solution = solution(needs, r);

      System.out.println(solution);
      
   }

}