package day0203;

import java.util.Arrays;
import java.util.Comparator;

public class PRG_Level2_����ū�� {

	public static String solution(int[] numbers) {
		String answer = "";

		String[] str = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++)
			str[i] = String.valueOf(numbers[i]);

		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		// ���� ū ���� 0�϶��� 0���� �̷���� �迭��. 0�� ǥ��
		if (str[0].startsWith("0"))
			answer = "0";
		else
			for (String s : str)
				answer += s;

		return answer;
	}

}
