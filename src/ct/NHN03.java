package ct;

import java.util.Scanner;

class NHN03 {
  private static void solution(int numOfOrder, String[] orderArr) {
    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	
  }
	
	private static String solvNum(String s) {
		String ret = "2(RGB)";
		
		for (int i = 0; i < s.charAt(0) - '0'; i++) {
			ret += s.substring(2, s.lastIndexOf(s) - 1);
		}
		
		System.out.println(ret);
		return ret;
	}

  private static class InputData {
    int numOfOrder;
    String[] orderArr;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.orderArr = new String[inputData.numOfOrder];
      for (int i = 0; i < inputData.numOfOrder; i++) {
        inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
	  String ret = "";
		String s = "12345678";

		for (int i = 2; i < s.length() - 1; i++) {
			ret += s.charAt(0);
			ret += s.charAt(i);
		}
		String ord = "B2(RG)";
		int j = 2;
		int k = 5;
		ord = ord.substring(0, j-1) +ord.substring(j-1, k) + ord.substring(k);
		
		System.out.println(ord);
		System.out.println(ord.substring(j-1, k));
		
    //InputData inputData = processStdin();

    //solution(inputData.numOfOrder, inputData.orderArr);
  }
}