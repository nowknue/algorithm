package pr;

import java.util.*;

public class PR42578_hash {   
   public static void main(String[] args) {
	   String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
       System.out.println(solution(clothes));
   }   
     
   public static int solution(String[][] clothes) {
       int answer = 0;
       String[][] clot = clothes;

       HashMap<String, Integer> countMap = new HashMap<>();
       ArrayList<String> typeList = new ArrayList<>();
       
       for (int i = 0; i < clot.length; i++) {
           if (countMap.containsKey(clot[i][1])) {
               countMap.replace(clot[i][1], countMap.get(clot[i][1]) + 1);
           } else {
               countMap.put(clot[i][1], 1);
               typeList.add(clot[i][1]);
           }
       }
       answer = 1;
       for (String type : typeList) {
           answer *= countMap.get(type) + 1;
       }

       return answer - 1;
   }
}
