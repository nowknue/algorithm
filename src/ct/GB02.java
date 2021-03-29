package ct;

/*



 */
public class GB02 {
   public static int solution(String s) {
        int answer = 0;
        String str = s;
        
        String[] strs = str.split("");
        
        for (int i = 0; i < strs.length; i++) {
           int count = 0;
           for (int j = i + 1; j < strs.length; j++) {
              if (strs[i].equals(strs[j])) {
                 count++;
              }
           }
           answer += strs.length - i - count;
        }
        
        
        
        return answer;
    }

   public static void main(String args[]) {
      
      
      String s = "abac";
      int solution = solution(s);

      System.out.println(solution);
      
      //abcadeafg
   }

}