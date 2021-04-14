package il;

public class LicenseKeyFormatting {

   public static void main(String[] args) {
      LicenseKeyFormatting a = new LicenseKeyFormatting();
      
      String str = "8F3Z-2e-9-wabcdef";
      //String str = "8-5g-3-3";
      int k = 4;
      System.out.println(a.solve(str, k));
      
   }

   public String solve(String str, int k) {
      String newStr = str.replace("-", "");
      newStr = newStr.toUpperCase();
      
      System.out.println(newStr);
      
      int leng = newStr.length();
      
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < leng; i++) {
         sb.append(newStr.charAt(i));
      }
      
      for (int i = k; i < leng; i = i + k) { // i를 4(k)에서 시작해서 4씩 증가시키는데 '-'은 뒤에서부터(leng-i)에 넣어서 늘어난 길이에도 영향없게 
         System.out.println(i + " i임");
         sb.insert(leng - i, '-');
      }
      
      return sb.toString();
   }
}