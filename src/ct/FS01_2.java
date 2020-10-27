package ct;

import java.util.HashMap;
import java.util.Stack;

public class FS01_2 {
	static String str;
    public static int[] solution(String s, int[] idx) {
        str = s;
        int[] index = idx;
        int[] answer = new int[index.length];

        for (int i = 0; i < index.length; i++) {
            answer[i] = find(index[i]);
        }

        return answer;
    }

    public static int find(int idx) {
        if (str.charAt(idx) == '{') {
            int count = 0;
            for (int i = idx + 1; i < str.length(); i++) {
                if (str.charAt(i) == '}') {
                    if (count == 0) {
                        return i;
                    } else {
                        count--;
                    }
                } else if (str.charAt(i) == '{'){
                    count++;
                }
            }
        } else if (str.charAt(idx) == '}') {
            int count = 0;
            for (int i = idx - 1; i >= 0; i--) {
                if (str.charAt(i) == '{') {
                    if (count == 0) {
                        return i;
                    } else {
                        count--;
                    }
                } else if (str.charAt(i) == '}'){
                    count++;
                }
            }
        }
        return -1;
    }

   public static void main(String args[]) {
	  int[] arr = {4, 11};
      int[] solution = solution("java{python}{}javascript{lang}", arr);

      System.out.println(solution);
   }

}