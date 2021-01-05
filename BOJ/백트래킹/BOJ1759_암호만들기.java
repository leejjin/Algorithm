package day210102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 패스워드는 최소 두개의 자음과 한개의 모음으로 구성
public class BOJ1759_암호만들기 {

	static int L, C; // L : 암호길이, C : 암호 문자의 종류
	static char[] pw, chars;
	static boolean[] used;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		chars = new char[C];
		pw = new char[L];
		used = new boolean[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(chars); // 오름차순으로 정렬

		combination(0, 0);
		System.out.println(sb);
	}

	private static void combination(int start, int cnt) {
		if (cnt == L) {
			if (check()) {
				for (int i = 0; i < L; i++) {
					sb.append(pw[i]);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			if (used[i])
				continue;
			pw[cnt] = chars[i];
			used[i] = true;
			combination(i, cnt + 1);
			used[i] = false;
		}
	}

	private static boolean check() {
		int ja = 0, mo = 0;

		for (int i = 0; i < L; i++) {
			switch (pw[i]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				mo++;
				break;
			default:
				ja++;
				break;
			}
		}
		if (ja < 2 || mo < 1)
			return false;
		return true;
	}
}
