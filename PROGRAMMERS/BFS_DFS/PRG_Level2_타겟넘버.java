package day0210;

public class PRG_Level2_Ÿ�ٳѹ� {

	public int solution(int[] numbers, int target) {
		int answer = 0;

		answer = dfs(numbers, target, 0, 0);

		return answer;
	}

	private int dfs(int[] numbers, int target, int index, int sum) {
		if (index == numbers.length) { // ��������
			if (sum == target)
				return 1;
			else
				return 0;
		}

		//	���ϴ� dfs + ���� dfs �� ���� ����� ��´�.
		return dfs(numbers, target, index + 1, sum + numbers[index])
				+ dfs(numbers, target, index + 1, sum - numbers[index]);
	}

}