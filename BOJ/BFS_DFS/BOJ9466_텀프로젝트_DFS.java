package day1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9466_텀프로젝트_DFS {

	private static int n, cnt;
	private static int[] students;
	private static boolean[] visited, end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			n = Integer.parseInt(br.readLine());
			students = new int[n + 1];
			visited = new boolean[n + 1];
			end = new boolean[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			} // end of input

			cnt = n;
			for (int i = 1; i <= n; i++) {
				if (!visited[i])
					dfs(i);
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int now) {
		if (visited[now])
			return;

		visited[now] = true;
		int next = students[now];

		if (!visited[next]) {
			dfs(next);
		} else {
			if (!end[next]) {
				cnt--;
				for (int i = next; i != now; i = students[i]) {
					cnt--;
				}
			}
		}
		end[now] = true;
	}
}
