package ct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

//map list 쓰는게 좀 비효율적인
public class DN02 {
	public static String[] solution(String[] orders) {
		String[] ords = orders;
		ArrayList<String> custList = new ArrayList<>();
		HashMap<String, HashSet<String>> ordMap = new HashMap<String, HashSet<String>>();

		// 유저ID와 음식을 구분해서 Map과 Set으로 정리한다.
		for (int i = 0; i < ords.length; i++) {
			String[] ord = ords[i].split(" ");
			String customer = ord[0];
			for (int j = 1; j < ord.length; j++) {
				if (ordMap.containsKey(customer)) {
					HashSet<String> tmpSet = ordMap.get(customer);
					tmpSet.add(ord[j]);
					ordMap.put(customer, tmpSet);
				} else {
					HashSet<String> newSet = new HashSet<>();
					newSet.add(ord[j]);
					ordMap.put(customer, newSet);
					custList.add(customer);
				}
			}
		}

		// 최대주문량
		int maxLen = Integer.MIN_VALUE;
		for (String customer : custList) {
			if (ordMap.get(customer).size() > maxLen) {
				maxLen = ordMap.get(customer).size();
			}
		}

		// 최대주문자 정리 (조건 리턴값이 배열이기때문에 편히 split하기위해 String에 구분자로 처리)
		String answerStr = "";
		for (String customer : custList) {
			if (ordMap.get(customer).size() == maxLen) {
				answerStr = answerStr + "|" + customer;
			}
		}

		if (answerStr.charAt(0) == '|') {
			answerStr = answerStr.substring(1);
		}

		String[] answer = answerStr.split("\\|");
		Arrays.sort(answer);

		return answer;
	}

	public static void main(String args[]) {
		String[] s = { "alex pizza pasta steak", "bob noodle sandwich pasta", "choi pizza sandwich pizza",
				"alex pizza pasta steak" };

		String[] solution = solution(s);

		System.out.println(solution);
	}

}