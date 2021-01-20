package day0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹
// anta ~ tica : a n t i c 
// 단어를 배우기 위해선 5글자를 무조건 포함해야 함
public class BOJ1062_가르침 {

	static int N, K, answer = 0;
	static boolean[] alpha = new boolean[26];
	static String[] word;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K < 5) { // antic를 포함하지 않는 경우
			System.out.println(0);
			return;
		}
		if (K == 26) { // 모든 알파벳을 다 배울 수 있는 경우
			System.out.println(N);
			return;
		}

		word = new String[N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			word[i] = temp.substring(4, temp.length() - 4); // anta ~ tica 사이의 문자를 저장함
		}

		alpha[0] = true; // a
		alpha[2] = true; // c
		alpha['i' - 'a'] = true; // i
		alpha['n' - 'a'] = true; // n
		alpha['t' - 'a'] = true; // t
		K -= 5;

		combination(0, 0);
		System.out.println(answer);
	}

	private static void combination(int start, int cnt) {
		if (cnt == K) {// 기저조건 : K개의 글자를 배움
			// 단, 단어의 개수가 최대일 때 리턴해야한다.

			int count = 0;
			for (int i = 0; i < N; i++) {
				boolean unknown = true;
				for (int j = 0; j < word[i].length(); j++) {
					if (!alpha[word[i].charAt(j) - 'a']) { // 배우지 못한 글자라면 카운트
						unknown = false;
						break;
					}
				}
				if (unknown)
					count++;
				answer = Math.max(count, answer);
			}
			return;
		}
		for (int i = start; i < 26; i++) {
			if (alpha[i])
				continue;
			alpha[i] = true;
			combination(i, cnt + 1);
			alpha[i] = false;
		}
	}
}
