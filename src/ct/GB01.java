package ct;

import java.util.Arrays;

/*


 */
// Java의 int배열은 2^31-1 개를 담을 수 없어서 효율성 다 틀림
public class GB01 {
   static int[] index; // 동적 계획법을 위한 배열 
   public static int solution(int n) {
      int num = n;
      int answer = 0;
      
      index = new int[num + 1]; // 각 곱해지는 수와 index 값을 갖게 맞춘다.
      Arrays.fill(index, -1); // 초기값 -1로 구분
      
      for (int i = 1; i < num + 1; i++) {
         index[i] = count(i);
         answer += index[i];
      }
      
        return answer;
    }
   
   // 재귀적으로 5의 개수를 센다.
   public static int count(int n) {
      if (n % 5 != 0) {
         return 0;
      } else if (index[n] != -1) {
         return index[n]; // 한번 지나간 수는 인덱스로 구분되게 저장한다.
      } else {
         return count(n / 5) + 1;
      }
   }


   public static void main(String args[]) {
      String[] s = { "aa" };
      String program = "trip";
      String[] flag_rules = {"-days NUMBERS", "-dest STRING"};
      String[] commands = {"trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"};
      
      int n =  214748364;//7;
      int solution = solution(n);

      System.out.println(solution);
      
   }

}