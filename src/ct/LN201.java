package ct;

import java.util.Arrays;
import java.util.regex.Pattern;

public class LN201 {
   public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
      String prog = program;
      String[] rules = flag_rules;
      String[] cmds = commands;
      
      boolean[] answer = new boolean[cmds.length];
      Arrays.fill(answer, true); // 한개의 룰이라도 어길시 false 이므로 초기값 true 후 조건 당 false 처리
      
      Loop1 :
      for (int i = 0; i < cmds.length; i++) {
         String[] cmd = cmds[i].split(" ");
         
         // 1번 조건 : program으로 시작합니다.
         if (!cmd[0].equals(prog)) {
            answer[i] = false;
            continue Loop1;
         }
         
         boolean ruleFourChk = false; // 4번 조건 용
         
         // 3번 조건 : 각 flag는 0번이나 1번 나타납니다.
         for (int j = 1; j < cmd.length; j++) {
            for (int k = j + 1; k < cmd.length; k++) {
               if (cmd[j].startsWith("-") && cmd[j].equals(cmd[k])) {
                  answer[i] = false;
                  continue Loop1;
               }
            }
         }
         
         // 2번 조건 : 각 flag argument는 대응하는 flag의 flag_argument_type과 일치합니다.
         Loop2 :
         for (int j = 1 ; j < cmd.length; j++) {
            for (int k = 0; k < rules.length; k++) {
               if (rules[k].substring(0, rules[k].indexOf(" ")).equals(cmd[j])) { //flag_rule의 첫 문자열과 command의 값이 일치할 경우 ex)'-s'
                  ruleFourChk = true;
                  
                  // 커맨드의 마지막 단어가 flag_name일 경우
                  if (j == cmd.length - 1) {
                     if (rules[k].indexOf("NULL") == -1) {
                        answer[i] = false;
                        break Loop2;
                     }
                  } else {
                     String command = cmd[j + 1];
                     // flag_argument_type이 NULL인데 flag_argument를 받을 경우
                     if (rules[k].indexOf("NULL") > -1 && !(command.startsWith("-"))) {
                         answer[i] = false;
                         break Loop2;
                     }
                     // flag_argument_type이 NUMBER인데 flag_argument가 숫자가 아닐 경우
                     else if (rules[k].indexOf("NUMBER") > -1 && !isNum(command)) {
                        answer[i] = false;
                        break Loop2;
                     }
                     // flag_argument_type이 STRING인데 flag_argument가 문자열이 아닐 경우
                     else if (rules[k].indexOf("STRING") > -1 && !isEng(command)) {
                        answer[i] = false;
                        break Loop2;
                     }
                     // **** flag_name이 연속으로 나오면서 앞의 flag_argument_type이 NULL이 아닌 경우는 각 NUMBER/STRING 체크할 때 같이 체크된다. ****
                     
                     // 연속으로 flag argument가 올 경우
                     if (rules[k].indexOf("NULL") == -1 && j < cmd.length - 2) {
                        if (!cmd[j + 2].startsWith("-")) {
                           answer[i] = false;
                           break Loop2;
                        }
                     }
                  }
                  
               }
            }
            
         }
         
         // 4번 조건 : flag_rules에 존재하는 flag만 나타납니다.
         if (!ruleFourChk) {
            answer[i] = false;
            continue Loop1;
         }
      }
      
        return answer;
    }
   
   // 문자열이 영어 대소문자인지 체크한다.
    public static boolean isEng(String cmd) {
        return Pattern.matches("^[a-zA-Z]*$", cmd);
    }
    
    // 문자열이 영어 숫자인지 체크한다.
    public static boolean isNum(String cmd) {
       return cmd.matches("[+-]?\\d*(\\.\\d+)?");
    }


   public static void main(String args[]) {
      String[] s = { "aa" };
      String program = "line";
      String[] flag_rules = {"-s STRING", "-n NUMBER", "-e NULL"};
      String[] commands = {"line -n 100 102 -s hi -e", "line -n id pwd -n 100"};
      boolean[] solution = solution(program, flag_rules, commands);

      System.out.println(solution[0]);
      System.out.println(solution[1]);
   }

}