package day1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2493_탑_풀이2 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] top = new int[N + 1]; // 탑의 높이 저장
		int[] stack = new int[N]; // 인덱스 저장
		int cur = -1;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int idx = 1; idx < top.length; idx++) {
			top[idx] = Integer.parseInt(st.nextToken());
			while (cur > -1 && top[stack[cur]] < top[idx])
				cur--;

			if (cur == -1)
				sb.append("0 ");
			else
				sb.append(stack[cur]).append(' ');

			stack[++cur] = idx;
		}
		System.out.println(sb);
	}
}
