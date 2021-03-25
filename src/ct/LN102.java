package ct;

/*


 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//regex 보기
public class LN102 {
   public static Matcher match;
//   public static final String pattern1 = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}$"; // 영문, 숫자, 특수문자
//   public static final String pattern2 = "^[A-Za-z[0-9]]{10,20}$"; // 영문, 숫자
//   public static final String pattern3 = "^[[0-9]$@$!%*#?&]{10,20}$"; //영문,  특수문자
//   public static final String pattern4 = "^[[A-Za-z]$@$!%*#?&]{10,20}$"; // 특수문자, 숫자
   public static final String pattern1 = "(\\w)\\1\\1\\1"; 
   public static final String pattern2 = "([\\{\\}\\[\\]\\/?.,;:|\\)*~`!^\\-_+<>@\\#$%&\\\\\\=\\(\\'\\\"])\\1\\1\\1";
   
   public static int[] solution(String inp_str) {
      String pwd = inp_str;
      ArrayList<Integer> answerList = new ArrayList<>();
      
      if (pwd.length() >= 8 || pwd.length() <= 15) {
         answerList.add(1);
      }

      final String ptn1 = "^(?=.*[A-Z]).{1,1000000}$";
      final String ptn2 = "^(?=.*[a-z]).{1,1000000}$";
      final String ptn3 = "^(?=.*[0-9]).{1,1000000}$";
      final String ptn4 = "^(?=.*\\d)(?=.*[~!@#$%^&*])[A-Za-z\\d~!@#$%^&*]{1,1000000}$";
      
      
      
      
      int cnt = 0;
      
      match = Pattern.compile(ptn1).matcher(pwd);
      if (match.find()) {
         cnt++;
      }

      match = Pattern.compile(ptn2).matcher(pwd);
      if (match.find()) {
         cnt++;
      }

      match = Pattern.compile(ptn3).matcher(pwd);
      if (match.find()) {
         cnt++;
      }

      match = Pattern.compile(ptn4).matcher(pwd);
      if (match.find()) {
         cnt++;
      }

      if (cnt < 3) {
         answerList.add(3);
      }
   
      if (continuousChk(pwd)) {
         answerList.add(4);
      }
      
      pwd = "221222";
      if (sameChk(pwd)) {
         answerList.add(5);
         System.out.println("Trrrrr");
      }
      
        int[] answer = {};
        return answer;
    }
   
   /**
    * 
    * 같은 문자, 숫자 4자리 체크
    * 
    * @param pwd
    * 
    * @return
    * 
    */

   public static boolean sameChk(String pwd) {
      match = Pattern.compile(pattern1).matcher(pwd);
      Matcher   match2 = Pattern.compile(pattern2).matcher(pwd);

      return match.find() || match2.find() ? true : false;
   }

   /**
    * 
    * 연속 문자, 숫자 4자리 체크
    * 
    * @param pwd
    * 
    * @return
    * 
    */

   public static boolean continuousChk(String pwd) {
      int o = 0;
      int d = 0;
      int p = 0;
      int n = 0;

      int limit = 5;

      for (int i = 0; i < pwd.length(); i++) {
         char tempVal = pwd.charAt(i);
         if (i > 0 && (p = o - tempVal) > -2 && (n = p == d ? n + 1 : 0) > limit - 3) {
            return true;
         }
         d = p;
         o = tempVal;
      }

      return false;

   }

   public static void main(String args[]) {
      String inp_str = "AaTa+!12-3=";

      int[] solution = solution(inp_str);

      //System.out.println(solution);
   }

}