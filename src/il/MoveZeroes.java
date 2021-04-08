package il;

public class MoveZeroes {
   public static void main(String args[]) {
      // 1
      int[] nums = { 0, 3, 2, 0, 8, 5 };
      int index = 0;
      
      // 2
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] != 0) {
            nums[index] = nums[i];
            index++;
         }
      }
      
      // 3
      while (index < nums.length) {
         nums[index] = 0;
         index++;
      }
      
      // 4
      for (int num : nums) {
         System.out.println(num);
      }
   }
}