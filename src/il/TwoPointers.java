package il;

public class TwoPointers {

   public static void main(String[] args) {
      TwoPointers a = new TwoPointers();
      int n = 5;
      int answer = a.solve(n);
      System.out.println(answer);
   }

   public int solve(int n) {
      int answer = 0;
      int rt = 2;
      int lt = 1;
      
      while (lt <= n/2) {
         int sum = 0;
         for (int i = lt; i < rt; i++) {
            sum += i;
         }
         System.out.println(lt + " @@ " + rt + " sum: " + sum);
         
         if (sum > n) {
            lt++;
         } else if (sum < n) {
            rt++;
         } else {
            answer++;
            lt++;
         }
      }
      
      return answer;
   }
}