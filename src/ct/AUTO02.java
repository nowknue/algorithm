package ct;

public class AUTO02 {
	public static int solution(int[] dollars) {
		int money = 1000;
		int[] arr = dollars;
		boolean hasDol = false;
		
		for (int i = 0; i < arr.length - 1; i++) {
			if (hasDol && arr[i] > arr[i + 1]) {
				hasDol = false;
				money += arr[i];
			} else if (!hasDol && money >= arr[i] && arr[i] < arr[i + 1]) {
				hasDol = true;
				money -= arr[i];
			}
		}
		
		return hasDol ? money + arr[arr.length - 1] : money;
	}

	public static void main(String args[]) {
		int[] dollars = { 1200, 1000, 800, 900, 1300, 1200, 1400, 900, 900, 1000, 1300 };

		int solution = solution(dollars);

		System.out.println(solution);
	}

}