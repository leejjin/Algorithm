package day0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ��Ʈ��ŷ
// anta ~ tica : a n t i c 
// �ܾ ���� ���ؼ� 5���ڸ� ������ �����ؾ� ��
public class BOJ1062_����ħ {

	static int N, K, answer = 0;
	static boolean[] alpha = new boolean[26];
	static String[] word;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K < 5) { // antic�� �������� �ʴ� ���
			System.out.println(0);
			return;
		}
		if (K == 26) { // ��� ���ĺ��� �� ��� �� �ִ� ���
			System.out.println(N);
			return;
		}

		word = new String[N];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			word[i] = temp.substring(4, temp.length() - 4); // anta ~ tica ������ ���ڸ� ������
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
		if (cnt == K) {// �������� : K���� ���ڸ� ���
			// ��, �ܾ��� ������ �ִ��� �� �����ؾ��Ѵ�.

			int count = 0;
			for (int i = 0; i < N; i++) {
				boolean unknown = true;
				for (int j = 0; j < word[i].length(); j++) {
					if (!alpha[word[i].charAt(j) - 'a']) { // ����� ���� ���ڶ�� ī��Ʈ
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
