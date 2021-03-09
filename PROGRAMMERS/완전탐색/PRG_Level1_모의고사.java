package day0309;

import java.util.ArrayList;
import java.util.Arrays;

public class PRG_Level1_모의고사 {

    public static Integer[] solution(int[] answers) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (a[i % a.length] == answers[i])
                count[0]++;
            if (b[i % b.length] == answers[i])
                count[1]++;
            if (c[i % c.length] == answers[i])
                count[2]++;
        }

        int max = Math.max(Math.max(count[0], count[1]), count[2]);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (max == count[i])
                list.add(i + 1);
        }

        Integer[] answer = list.toArray(new Integer[list.size()]);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1,3,2,4,2})));
    }

}
