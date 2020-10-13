package day1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 변경된 크로티아 알파벳 : c=, c-, dz=, d-, lj, nj, s=, z=
 * 1. charAt() 을 이용하여 인덱스의 문자 받아오기
 * 2. 문자의 다음 문자를 확인하기
 * 3. 문자열 범위를 벗어나는지 확인하기
 */
public class BOJ2941_크로티아알파벳_문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int count = 0;
		int length = input.length();

		for (int i = 0; i < length; i++) {

			switch (input.charAt(i)) {
			case 'c': // c=, c- 인 경우
				if (i < length-1 && (input.charAt(i + 1) == '=' || input.charAt(i + 1) == '-'))
					i++;
				break;
			case 'd': // dz= , d- 인 경우
				if (i < length-2 && input.charAt(i + 1) == 'z' && input.charAt(i + 2) == '=')
					i += 2;
				else if (i < length-1 && input.charAt(i + 1) == '-')
					i++;
				break;
			case 'l':
			case 'n':
				if (i < length-1 && input.charAt(i + 1) == 'j')
					i++;
				break;
			case 's':
			case 'z':
				if (i < length-1 && input.charAt(i + 1) == '=')
					i++;
				break;
			}
			count++;
		}
		System.out.println(count);
	}
}
