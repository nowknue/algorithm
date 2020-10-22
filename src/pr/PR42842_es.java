package pr;

import java.util.*;

public class PR42842_es {   
   public static void main(String[] args) {
       System.out.println(solution(10, 2));
   }   
     
   public static int[] solution(int brown, int yellow) {
       int x = 0;
       int y = 0;
       
       for (int i = 3; i < brown/2; i++) {
           for (int j = 3; j < brown/2; j++) {
               if (brown + yellow == i*j && (j - 2) * (i - 2) == yellow) {
                   x = j;
                   y = i;
                   break;
               }
           }
       }
       
       int[] answer = {Math.max(x, y), Math.min(x, y)};
       return answer;
   }
}
