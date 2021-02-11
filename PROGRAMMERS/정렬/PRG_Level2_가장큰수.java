package day0203;

import java.util.Arrays;
import java.util.Comparator;

public class PRG_Level2_가장큰수 {

    public String solution(int[] numbers) {
        String answer = "";

        String[] val = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            val[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(val, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }

        });

        if (val[0].startsWith("0")) {
            return "0";
        } else {
            for (String result : val) {
                answer += result;
            }

            return answer;
        }

    }
}