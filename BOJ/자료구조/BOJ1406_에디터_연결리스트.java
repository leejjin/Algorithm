package day1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ1406_에디터_연결리스트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] str = br.readLine().toCharArray();
		int M = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<>();
		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);
		}

		ListIterator<Character> it = list.listIterator(list.size());

		for (int i = 0; i < M; i++) {
			String op = br.readLine();
			switch (op.charAt(0)) {
			case 'L':
				if (it.hasPrevious())
					it.previous();
				break;
			case 'D':
				if (it.hasNext())
					it.next();
				break;
			case 'B':
				if (it.hasPrevious()) {
					it.previous();
					it.remove();
				}
				break;
			case 'P':
				it.add(op.charAt(2));
				break;
			}
		}
		for (char c : list) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
