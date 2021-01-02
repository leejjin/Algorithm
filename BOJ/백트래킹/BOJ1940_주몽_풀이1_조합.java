package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1940_주몽_풀이1_조합 {
	static int N, M, answer = 0;
	static int[] nums, result;
	static boolean[] isused;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		nums = new int[N];
		result = new int[2];
		isused = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		combination(0, 0);

		System.out.println(answer);
	}

	private static void combination(int start, int cnt) {
		if (cnt == 2) {
			int sum = 0;
			for (int i = 0; i < 2; i++) {
				sum += result[i];
			}
			if (sum == M)
				answer++;
			return;
		}
		for (int i = start; i < N; i++) {
			if (isused[i])
				continue;
			result[cnt] = nums[i];
			isused[i] = true;
			combination(i, cnt + 1);
			isused[i] = false;
		}
	}
}
