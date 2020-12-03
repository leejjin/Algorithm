package day1202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1021_회전하는큐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		LinkedList<Integer> deque = new LinkedList<>();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			deque.add(i);
		}

		int cnt = 0;
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			while (target != deque.peekFirst()) {
				if (deque.indexOf(target) <= deque.size() / 2) {
					deque.addLast(deque.peekFirst());
					deque.removeFirst();
				} else {
					deque.addFirst(deque.peekLast());
					deque.removeLast();
				}
				cnt++;
			}
			deque.removeFirst();
		}

		System.out.println(cnt);
	}
}