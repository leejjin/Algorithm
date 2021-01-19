package day0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//  �Ӹ���� : �Ųٷ� �о ����� �д� �Ͱ� ���� �����̳� ����, ����, ���ڿ� ���̴�.
public class BOJ1213_�Ӹ���Ҹ���� {

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
				if (isOdd) { // Ȧ���� ���ĺ��� �ΰ� �̻� ������ ���� �Ӹ������ ������ ����
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				isOdd = true;
				midIdx = i;
			}
		}

		String answer = "";
		// ��
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < alphabet[i] / 2; j++) {
				answer += (char) (i + 'A');
			}
		}
		// Ȧ���� ��� �߰�
		if (isOdd)
			answer += (char) (midIdx + 'A');
		// ��
		for (int i = 25; i >= 0; i--) {
			for (int j = 0; j < alphabet[i] / 2; j++) {
				answer += (char) (i + 'A');
			}
		}

		System.out.println(answer);
	}
}
