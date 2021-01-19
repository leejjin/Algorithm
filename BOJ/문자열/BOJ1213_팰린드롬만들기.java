package day0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//  팰린드롬 : 거꾸로 읽어도 제대로 읽는 것과 같은 문장이나 낱말, 숫자, 문자열 등이다.
public class BOJ1213_팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] alphabet = new char[26];
		String arr = br.readLine();
		for (int i = 0; i < arr.length(); i++) {
			alphabet[arr.charAt(i) - 'A']++;
		}

		boolean isOdd = false;
		int midIdx = 0;
		for (int i = 0; i < 26; i++) {
			if (alphabet[i] % 2 != 0) {
				if (isOdd) { // 홀수인 알파벳이 두개 이상 존재할 때는 팰린드롬을 만들지 못함
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				isOdd = true;
				midIdx = i;
			}
		}

		String answer = "";
		// 앞
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < alphabet[i] / 2; j++) {
				answer += (char) (i + 'A');
			}
		}
		// 홀수일 경우 중간
		if (isOdd)
			answer += (char) (midIdx + 'A');
		// 뒤
		for (int i = 25; i >= 0; i--) {
			for (int j = 0; j < alphabet[i] / 2; j++) {
				answer += (char) (i + 'A');
			}
		}

		System.out.println(answer);
	}
}
