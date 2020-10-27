package day1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11656_접미사배열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		String[] tail = new String[s.length()]; // 접미사는 문자열의 길이만큼 존재

		for (int i = 0; i < tail.length; i++) {
			tail[i] = s.substring(i);
		}

		Arrays.sort(tail);

		for (String str : tail) {
			sb.append(str).append('\n');
		}

		System.out.println(sb);

	}
}
