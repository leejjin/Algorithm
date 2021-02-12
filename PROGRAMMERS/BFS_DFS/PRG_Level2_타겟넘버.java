package day0210;

public class PRG_Level2_타겟넘버 {

	public int solution(int[] numbers, int target) {
		int answer = 0;

		answer = dfs(numbers, target, 0, 0);

		return answer;
	}

	private int dfs(int[] numbers, int target, int index, int sum) {
		if (index == numbers.length) { // 기저조건
			if (sum == target)
				return 1;
			else
				return 0;
		}

		//	더하는 dfs + 빼는 dfs 를 통해 결과를 얻는다.
		return dfs(numbers, target, index + 1, sum + numbers[index])
				+ dfs(numbers, target, index + 1, sum - numbers[index]);
	}

}