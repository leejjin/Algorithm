package day1204;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4179_불 {

	public static int R, C;
	public static char[][] map;
	public static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	public static int[] dc = { 0, 0, -1, 1 };
	public static int[][] js; // 지훈이 이동시간
	public static int[][] fs; // 불의 이동시간
	public static Queue<int[]> jq = new LinkedList<>(); // 지훈이의 이동을 담을 큐
	public static Queue<int[]> fq = new LinkedList<>(); // 불의 이동을 담을 큐

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		js = new int[R][C];
		fs = new int[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for (int i = 0; i < R; i++) {
			Arrays.fill(js[i], -1);
			Arrays.fill(fs[i], -1);
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'J') {
					jq.offer(new int[] { i, j });
					js[i][j] = 0;
				} else if (map[i][j] == 'F') {
					fq.offer(new int[] { i, j });
					fs[i][j] = 0;
				}
			}
		}
		fireBFS();
		jhBFS();
	}

	private static void fireBFS() {
		while (!fq.isEmpty()) {
			int[] now = fq.poll();
			int row = now[0];
			int col = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (map[nr][nc] != '#' && fs[nr][nc] == -1) { // 벽이 아니고 방문하지 않은 곳
						fs[nr][nc] = fs[row][col] + 1;
						fq.offer(new int[] { nr, nc });
					}
				}
			}
		}
	}

	private static void jhBFS() {
		while (!jq.isEmpty()) {
			int[] now = jq.poll();
			int row = now[0];
			int col = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (map[nr][nc] != '#' && js[nr][nc] == -1) { // 벽이 아니고 방문하지 않은 곳
						if (fs[nr][nc] > js[row][col] + 1 || fs[nr][nc] == -1) { // 지훈이가 불보다 더 먼저 도착한 경우 or 불이 접근하지 않은 경우
							js[nr][nc] = js[row][col] + 1;
							jq.offer(new int[] { nr, nc });
						}
					}
				} else { // 탈출 성공
					System.out.println(js[row][col] + 1);
					return;
				}
			}
		}
		System.out.println("IMPOSSIBLE");
		return;
	}
}
