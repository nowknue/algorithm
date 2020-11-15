package ct;

import java.util.Arrays;

public class ELV02 {
   public static int solution(int[] A) {
      int[] arr = A;
      
      Arrays.sort(arr); // 값 비교를 위해 정렬
      
      // 연달아 인접한 세 값만 비교해줘도 삼각형이 가능한지 판단 가능하다.
      for (int i = arr.length - 1; i > 1; i--) {
         if (canTri(arr[i], arr[i - 1], arr[i - 2])) {
            return arr[i] + arr[i - 1] + arr[i - 2];
         }
      }

      return -1;
   }
   
   public static boolean canTri(int a, int b, int c) {
        return a < b + c ? true : false;
    }

   public static void main(String args[]) {
      int[] A = { 100000000,100000000,100000000 };

      int solution = solution(A);

      System.out.println(solution);
   }

}