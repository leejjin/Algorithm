package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15961_회전초밥 {

	static int N, d, k, c;
	static int[] sushi, eat;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 벨트 위 접시의 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰번호

		eat = new int[d + 1];
		sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		// 쿠폰 초밥 먹기
		int cnt = 1;
		eat[c]++;

		// 벨트 위 접시 첫 확인
		for (int i = 0; i < k; i++) {
			if (eat[sushi[i]] == 0)
				cnt++;
			eat[sushi[i]]++;
		}

		int start = 0, end = k - 1;
		int max = cnt;

		while (start < N) {
			end++;

			if (end >= N) // 배열 한바퀴를 돈 경우 0으로 초기화
				end = 0;

			if (eat[sushi[end]] == 0)
				cnt++;
			eat[sushi[end]]++; // 먹기

			eat[sushi[start]]--; // 뱉기
			if (eat[sushi[start]] == 0) // 뱉은 후 먹은 목록에 해당 초밥이 없으면 카운트 빼기
				cnt--;

			start++;

			if (cnt > max)
				max = cnt;
		}

		System.out.println(max);
	}
}
