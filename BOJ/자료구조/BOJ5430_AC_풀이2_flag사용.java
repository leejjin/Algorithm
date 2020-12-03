package day1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ5430_AC_풀이2_flag사용 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			char[] op = br.readLine().toCharArray(); // 명령어
			int n = Integer.parseInt(br.readLine()); // 배열의 길이
			Deque<Integer> deque = new LinkedList<>(); // 숫자 저장할 덱
			boolean isError = false;

			String arr = br.readLine();
			if (n != 0) {
				StringTokenizer st = new StringTokenizer(arr.substring(1, arr.length() - 1), ",");
				for (int j = 0; j < n; j++) {
					deque.add(Integer.parseInt(st.nextToken()));
				}
			} // end of input

			boolean isReverse = false;
			for (int j = 0; j < op.length; j++) {
				if (op[j] == 'R')
					isReverse = !isReverse;
				else {
					if (deque.isEmpty()) {
						sb.append("error\n");
						isError = true;
						break;
					}
					if (isReverse)
						deque.removeLast();
					else
						deque.removeFirst();
				}
			}
			if (isError)
				continue;

			sb.append("[");
			while (!deque.isEmpty()) {
				if (isReverse)
					sb.append(deque.pollLast());
				else
					sb.append(deque.pollFirst());
				if (deque.size() != 0)
					sb.append(",");
			}
			sb.append("]\n");
		}
		System.out.println(sb);
	}
}