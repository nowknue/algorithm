package ct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class CP02 {
   public static int solution(int n, String[] customers) throws ParseException {
      int kio = n;
      String[] cus = customers;
      int[] kioTime = new int[kio];
      long[] time = new long[kio];
      SimpleDateFormat f = new SimpleDateFormat("MM/dd HH:mm:ss");

      for (int i = 0; i < kio; i++) {
         time[i] = f.parse("01/01 00:00:00").getTime();
      }

      for (int i = 0; i < cus.length; i++) {
         String[] dtTime = cus[i].split(" ");
         long min = Long.MAX_VALUE;
         int idx = -1;
         for (int j = 0; j < kio; j++) {
            if (min > time[j]) {
               min = time[j];
               idx = j;
            }
         }

         Calendar calKio = Calendar.getInstance();
         Calendar calNew = Calendar.getInstance();

         calKio.setTimeInMillis(time[idx]);
         calNew.setTime(f.parse(dtTime[0] + " " + dtTime[1]));

         if (calKio.getTimeInMillis() <= calNew.getTimeInMillis()) {
            kioTime[idx]++;
            time[idx] = calNew.getTimeInMillis() + (long) Long.parseLong(dtTime[2]) * 60 * 1000;
         } else {
            kioTime[idx]++;
            time[idx] = calKio.getTimeInMillis() + (long) Long.parseLong(dtTime[2]) * 60 * 1000;
         }
      }

      Arrays.sort(kioTime);
      int answer = kioTime[kioTime.length - 1];
      return answer;
   }

   public static void main(String args[]) throws ParseException {
      int n = 2;
      String[] customers = { "02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01" };

      int solution = solution(n, customers);

      System.out.println(solution);
   }

}