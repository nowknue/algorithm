package ct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FS02 {
	public static int[] solution(String[] nums) {
		ArrayList<Integer> checkedList = new ArrayList<>();
		ArrayList<String> hyphenList = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (ruleOne(nums[i]) && ruleTwo(nums[i]) && ruleThree(nums[i]) && ruleFour(nums[i])) {
				checkedList.add(i);
			}
		}

		for (int i : checkedList) {
			String num = nums[i];
			String hyphenIdx = "";
			for (int j = 0; j < num.length(); j++) {
				if (num.charAt(j) == '-') {
					hyphenIdx += Integer.toString(j);
				}
			}

			hyphenIdx = hyphenIdx + "|" + num.length();

			if (map.containsKey(hyphenIdx)) {
				map.replace(hyphenIdx, map.get(hyphenIdx) + 1);
			} else {
				map.put(hyphenIdx, 1);
				hyphenList.add(hyphenIdx);
			}
		}

		Integer[] arr = new Integer[hyphenList.size()];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = map.get(hyphenList.get(i));
		}

		Arrays.sort(arr, Collections.reverseOrder());

		int[] answer = Arrays.stream(arr).mapToInt(i -> i).toArray();

		return answer;
	}

	public static boolean ruleOne(String s) {
		final String pattern = "^[0-9]+$";
		Matcher mat = Pattern.compile(pattern).matcher(s.replace("-", "0"));
		return mat.find();
	}

	public static boolean ruleTwo(String s) {
		return s.replace("-", "").length() >= 11 && s.replace("-", "").length() <= 14;
	}

	public static boolean ruleThree(String s) {
		int count = 0;
		int idx = -1;
		while ((idx = s.indexOf("-", idx + 1)) >= 0) {
			count++;
		}
		return count <= 3;
	}

	public static boolean ruleFour(String s) {
		return !(s.indexOf("--") > -1 || s.charAt(0) == '-' || s.charAt(s.length() - 1) == '-');
	}

	public static void main(String args[]) {
		String[] arr = { "11-1111-111111", "232323a-11111" };

		int[] solution = solution(arr);

		System.out.println(solution);
	}

}