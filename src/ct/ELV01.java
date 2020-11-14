package ct;

import java.util.Arrays;

public class ELV01 {
   public static int solution(int[] A) {
      int answer = 0;
      int[] arr = A;
      int len = arr.length;
      
      Arrays.sort(arr); // 값 비교를 위해 정렬
      
      // 최댓값은 하나만 남기고 나머지는 두개씩만 남기기
      for (int i = len - 2; i > 1; i--) {
         if (arr[len - 1] == arr[i]) {
            arr[i] = -1;
         } else if (arr[i] == arr[i - 2]) {
            arr[i] = -1;
         }
      }
      
      answer = len;
      
      // -1로 처리한 개수 제외
      for (int i = 0; i < len; i++) {
         if (arr[i] == -1) {
            answer--;
         }
      }
      
      return answer;
   }

   public static void main(String args[]) {
      int[] A = { 1 };

      int solution = solution(A);

      System.out.println(solution);
   }

}