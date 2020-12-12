package ct;

// 처음 풀 때부터 특이케이스 잘 생각하기
public class DN01 {
	public static String solution(String[] strs) {
		String[] arrStr = strs;
		String answer = "";
		int idx = 0;
		int minLen = Integer.MAX_VALUE;

		if (arrStr.length == 0) {
			return answer;
		} else if (arrStr.length == 1) {
			return arrStr[0];
		}

		// str 중 가장 짧은 길이의 index까지만 비교하기 위해 미리 길이를 가져오고 추후 소스의 가독성을 높인다.
		for (int i = 0; i < arrStr.length; i++) {
			if (arrStr[i].length() < minLen) {
				minLen = arrStr[i].length();
			}
		}

		// 같은 index의 character를 비교하여 다른게 하나라도 생기면 전체 break
		Loop1: for (int i = 0; i < minLen; i++) {
			for (int j = 0; j < arrStr.length - 1; j++) {
				if (arrStr[j].charAt(i) != arrStr[j + 1].charAt(i)) {
					idx = i;
					break Loop1;
				} else {
					idx = i + 1;
				}
			}
		}

		// 접두사는 모두 동일하므로 아무 str값에서 접두사만 분리한다.
		answer = arrStr[0].substring(0, idx);

		return answer;
	}

	public static void main(String args[]) {
		String[] s = { "aa" };

		String solution = solution(s);

		System.out.println(solution);
	}

}