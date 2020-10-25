package ct;

import java.util.HashMap;
import java.util.Stack;

public class FS01 {
	public static int[] solution(String s, int[] idx) {
        String str = s;
        int[] index = idx;
        HashMap<Integer, Integer> pairMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[index.length];
        StringBuilder sb = new StringBuilder(str); //setCharAt()을 사용하기 위해 StringBuilder 사용

        while (sb.indexOf("}") > -1) { // sb의 중괄호들을 지워가며 다 지울 때까지 체크
            int openIdx = sb.indexOf("{");
            int closeIdx = sb.indexOf("}");
            if (openIdx > closeIdx || openIdx == -1) {
                int pop = stack.pop(); // "}"의 짝을 찾아 "{"를 매칭하기 위해 Stack 사용
                pairMap.put(pop, closeIdx);
                pairMap.put(closeIdx, pop);

                sb.setCharAt(closeIdx, '@'); // 인덱스 체크가 된 중괄호는 다른 문자로 대체
            } else {
                sb.setCharAt(openIdx, '@'); // 인덱스 체크가 된 중괄호는 다른 문자로 대체
                stack.add(openIdx);
            }
        }

        for (int i = 0; i < index.length; i++) {
            answer[i] = pairMap.get(index[i]);
        }

        return answer;
    }

   public static void main(String args[]) {
	  int[] arr = {4, 11};
      int[] solution = solution("java{python}{}javascript{lang}", arr);

      System.out.println(solution);
   }

}