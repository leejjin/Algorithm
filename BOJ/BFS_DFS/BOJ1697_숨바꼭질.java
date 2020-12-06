package day1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_숨바꼭질 {

	public static int N, K;
	public static int[] map;
	public static boolean[] visited;
	public static int[] d = { -1, 1, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[100001];
		visited = new boolean[100001];
		if (N == K) {
			System.out.println(0);
			return;
		}
		map[K] = -1; // 동생

		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		visited[N] = true;
		map[N] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < 3; i++) {
				int next;
				if (d[i] % 2 != 0)
					next = now + d[i];
				else
					next = now * d[i];

				if (0 <= next && next <= 100000) {
					if (!visited[next]) {
						if (map[next] == -1) {
							map[next] = map[now] + 1;
							System.out.println(map[next]);
							return;
						}

						map[next] = map[now] + 1;
						q.offer(next);
						visited[next] = true;
					}
				}
			}
		}
	}
}
