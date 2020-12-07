package day1205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569_토마토 {

	public static int N, M, H, day = 0;
	public static int[][][] box;
	public static int[] dx = { -1, 1, 0, 0, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1, 0, 0 };
	public static int[] dz = { 0, 0, 0, 0, -1, 1 }; // 상 하 좌 우 위 아래
	public static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[N][M][H];

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						q.offer(new int[] { i, j, k, 0 });
					}
				}
			}
		}

		bfs();

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (box[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(day);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int z = now[2];
			day = now[3];

			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
					if (box[nx][ny][nz] == 0) {
						box[nx][ny][nz] = 1;
						q.offer(new int[] { nx, ny, nz, day + 1 });
					}
				}
			}
		}
	}
}
