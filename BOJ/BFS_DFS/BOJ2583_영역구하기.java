package day1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2583_영역구하기 {

	private static int M, N, K;
	private static boolean[][] map;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };
	private static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int r = x1; r < x2; r++) {
				for (int c = y1; c < y2; c++) {
					if (!map[c][r])
						map[c][r] = true;
				}
			}
		}

		int total = 0;
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < N; c++) {
				if (!map[r][c]) {
					total++;
					bfs(r, c);
				}
			}
		}
		sb.append(total + "\n");

		Collections.sort(list);
		for (int i : list) {
			sb.append(i + " ");
		}

		System.out.println(sb);
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		map[r][c] = true;

		int count = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int row = now[0];
			int col = now[1];
			count++;

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
					if (!map[nr][nc]) {
						map[nr][nc] = true;
						q.offer(new int[] { nr, nc });
					}
				}
			}
		}
		list.add(count);
	}
}
