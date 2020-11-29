package day1129;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ5397_키로거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < TC; testCase++) {
			char[] L = br.readLine().toCharArray();

			LinkedList<Character> list = new LinkedList<>();
			ListIterator<Character> it = list.listIterator();

			for (int i = 0; i < L.length; i++) {
				switch (L[i]) {
				case '-':
					if (it.hasPrevious()) {
						it.previous();
						it.remove();
					}
					break;
				case '<':
					if(it.hasPrevious())
						it.previous();
					break;
				case '>':
					if(it.hasNext())
						it.next();
					break;
				default:
					it.add(L[i]);
					break;
				}
			}
			for (char c : list) {
				sb.append(c);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
