package day0203;

import java.util.Arrays;
import java.util.Comparator;

public class PRG_Level2_가장큰수 {

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

		// 가장 큰 수가 0일때는 0으로 이루어진 배열임. 0만 표시
		if (str[0].startsWith("0"))
			answer = "0";
		else
			for (String s : str)
				answer += s;

		return answer;
	}

}
