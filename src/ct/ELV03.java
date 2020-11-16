package ct;

import java.util.ArrayList;
import java.util.HashMap;

public class ELV03 {
   public static int solution(int[] X, int[] Y) {
      int[] xArr = X;
      int[] yArr = Y;

      // xArr/yArr을 모두 기약분수로 만들기
      for (int i = 0; i < xArr.length; i++) {
         if (xArr[i] == 0) {
            continue;
         }
         
         // 유클리드 호제법으로 최대공약수 구하기
         int gcd = gcd(xArr[i], yArr[i]);
         
         xArr[i] /= gcd;
         yArr[i] /= gcd;
      }

      ArrayList<String> fracList = new ArrayList<>();
      HashMap<String, Integer> fracMap = new HashMap<String, Integer>();

      // 분수값을 리스트에 담고 맵에서 개수를 체크한다.
      for (int i = 0; i < xArr.length; i++) {
         String fraction = xArr[i] + "/" + yArr[i];
         if (fracMap.containsKey(fraction)) {
            fracMap.put(fraction, fracMap.get(fraction) + 1);
         } else {
            fracMap.put(fraction, 1);
            fracList.add(fraction);
         }
      }

      int max = Integer.MIN_VALUE;
      
      // 리스트에 담긴 분수값들의 개수를 맵에서 체크 후 최댓값을 가져온다.
      for (String fraction : fracList) {
         if (fracMap.get(fraction) > max) {
            max = fracMap.get(fraction);
         }
      }

      return max;
   }
   
   public static int gcd(int x, int y) {
      int a, b, gcd;
      if (x > y) {
         a = x;
         gcd = y;
      } else {
         a = y;
         gcd = x;
      }
      
      while (true) {
         b = a % gcd;
         if (b == 0) {
            break;
         }
         a = gcd;
         gcd = b;
      }

      return gcd;
   }

   public static void main(String args[]) {
      int[] X = { 1, 2, 3, 4, 0, 2000000000, 0, 2000000000, 1, 2000000000, 2 };
      int[] Y = { 2, 3, 6, 8, 4, 2000000000, 2000000000, 1, 2000000000, 2, 2000000000 };

      int solution = solution(X, Y);

      System.out.println(solution);
   }

}