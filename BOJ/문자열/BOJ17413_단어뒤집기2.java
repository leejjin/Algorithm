package day1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<>(); // 단어뒤집기를 위한 스택
		char[] list = (br.readLine() + "\n").toCharArray();
		boolean tag = false; // 태그인지 판별할 flag

		for (int i = 0; i < list.length; i++) {
			if (list[i] == '<') // 태그 시작
				tag = true;

			if (tag || list[i] == ' ' || list[i] == '\n') { // 태그, 공백, 문자열 끝을 만났을 때
				while (!stack.isEmpty()) //스택이 빌 때까지 꺼냄
					sb.append(stack.pop());
				if (list[i] != '\n') // 문자열 끝이 아닌 태그나 공백인 경우에 그대로 출력
					sb.append(list[i]);

			} else { // 거꾸로 출력할 문자열을 스택에 저장
				stack.push(list[i]);
			}

			if (list[i] == '>') // 태그 끝
				tag = false;
		}
		System.out.println(sb);

	}

}
