package il;

import java.util.HashSet;

public class JewelsAndStones {

   public static void main(String[] args) {
      JewelsAndStones a = new JewelsAndStones();

      String jewels = "aA";
      String stones = "aAAbbbb";
      
      System.out.println(a.solve(jewels, stones));
   }

   public int solve(String jewels, String stones) {
      // 1
      HashSet<Character> set = new HashSet<>();
      for (char jewel : jewels.toCharArray()) {
         set.add(jewel);
      }
      
      // 2
      int result = 0;
      for (char stone : stones.toCharArray()) {
         if (set.contains(stone)) {
            result++;
         }
      }
      
      return result;
   }
}