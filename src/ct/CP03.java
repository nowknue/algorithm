package ct;

import java.util.ArrayList;
import java.util.HashMap;

public class CP03 {
   public static int solution(int k, int[] score) {
      int times = k;
      int[] sco = score;
      int[] diff = new int[sco.length];

      ArrayList<Integer> diffList = new ArrayList<>();
      HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();

      if (sco.length == 1) {
         return 0;
      }

      for (int i = 1; i < sco.length; i++) {
         diffList.add(sco[i - 1] - sco[i]);
         diff[i] = sco[i - 1] - sco[i];
      }

      for (int i = 0; i < diffList.size(); i++) {
         if (countMap.containsKey(diffList.get(i))) {
            countMap.put(diffList.get(i), countMap.get(diffList.get(i)) + 1);
         } else {
            countMap.put(diffList.get(i), 1);
         }
      }

      int[] ansArr = new int[sco.length];

      for (int i = 1; i < diff.length; i++) {
         if (times <= countMap.get(diff[i])) {
            ansArr[i - 1] = -1;
            ansArr[i] = -1;
         }
      }
      int count = 0;
      for (int i = 0; i < ansArr.length; i++) {
         if (ansArr[i] != -1) {
            count++;
         }
      }

      int answer = count;
      return answer;
   }

   public static void main(String args[]) {
      int k = 2;
      int[] score = { 24, 22, 20 };

      int solution = solution(k, score);

      System.out.println(solution);
   }

}