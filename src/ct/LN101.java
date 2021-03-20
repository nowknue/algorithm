package ct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LN101 {
   public static String solution(String[] table, String[] languages, int[] preference) {
      String[] tbl = table;
      String[] lang = languages;
      int[] pref = preference;
        String answer = "";
        int score[] = {0, 0, 0, 0, 0};
        String[] jobs = new String[5];
        
        // tbl, lang, arr 의 길이는 모두 10 이하로 매우 작다.
        for(int i = 0; i < tbl.length; i++) {
           for (int k = 0; k < lang.length; k++) {
              String[] arr = tbl[i].split(" ");
              jobs[i] = arr[0];
              for (int j = 0; j < arr.length; j++) {
                 if (arr[j].equals(lang[k])) {
                    score[i] += (6 - j)*pref[k];
                 }
              }
           }
           
        }

        // 최댓값
        List<Integer> vals = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < score.length; ++i) {
            if (score[i] == max) {
                vals.add(i);
            }
            else if (score[i] > max) {
                vals.clear();
                vals.add(i);
                max = score[i];
            }
        }
        
        // 점수 총합이 같은 직업군이 여러 개일 경우
        if (vals.size() != 1) {
           String[] newArr = new String[vals.size()];
           for (int i = 0; i < vals.size(); i++) {
              newArr[i] = jobs[vals.get(i)];
           }
           // 이름이 사전 순으로 가장 빠른 직업군 찾기
           Arrays.sort(newArr);
           
           answer = newArr[0];
        } else {
           answer = jobs[vals.get(0)];
        }
        
        return answer;
    }

   public static void main(String args[]) {
      String[] s = { "aa" };
      String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
      String[] languages = {"PYTHON", "C++", "SQL"}; 
      int[] preference = {7, 5, 5};
      
      
      String solution = solution(table, languages, preference);

      System.out.println(solution);
   }

}