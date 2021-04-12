package il;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class DailyTemperature {

   public static void main(String[] args) {
      DailyTemperature a = new DailyTemperature();

      int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
      int[] res = a.solve(nums);
      
      for (int i : res)
         System.out.println(i);
   }

   //
   public int[] solve(int[] temper) {
      // 1 ds
      Stack<Integer> stack = new Stack<>();
      int[] result = new int[temper.length];
      
      // 2 for, while algo
      for (int i = 0; i < temper.length; i++) {
         while (!stack.isEmpty() &&  temper[stack.peek()] < temper[i]) {
            int index = stack.pop();
            result[index] = i - index;
         }
         
         stack.add(i);
      }
      
      return result;
   }
}