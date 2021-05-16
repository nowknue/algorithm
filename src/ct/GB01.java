package ct;

import java.util.Arrays;

/*
팩토리얼은 자연수 n에 대해 1부터 n까지 모든 숫자를 곱하는 것을 의미하며 n 팩토리얼은 n! 라고 표기합니다. 예를들어 3! 은 1 x 2 x 3 = 6입니다.

그리고 n! 을 계산했을 때 가장 낮은 자리부터 연속되어 나타나는 0의 개수를 팩토리얼 꼬리의 길이라고 합니다.
예를 들어 n = 10인 경우 10! 은 3628800이며 가장 낮은 자리부터 연속해서 2개의 0이 있으므로 팩토리얼 꼬리의 길이는 2입니다.

입력으로 n이 주어질 때 팩토리얼 꼬리의 길이를 반환하는 함수를 완성해 주세요.

제한사항
n은 2^31 - 1 이하의 자연수입니다.



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