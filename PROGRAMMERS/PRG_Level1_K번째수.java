package day0202;

import java.util.Arrays;

public class PRG_Level1_K번째수 {


    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int TC = 0; TC < commands.length; TC++) {
            int[] command = commands[TC];

            int size = command[1] - command[0] + 1;
            int[] cut = new int[size];

            for (int i = 0, j = command[0] - 1; i < size; i++, j++) {
                cut[i] = array[j];
            }
            Arrays.sort(cut);
            answer[TC] = cut[command[2] - 1];
        }
        return answer;
    }

}
