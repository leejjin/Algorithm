import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * . 빈필드 / # 울타리/ o 양 / v 늑대 / 양 <= 늑대 : 잡아먹힘
 */
public class Main {

	private static int R, C, sheep = 0, wolf = 0; // 행, 열, 양, 늑대
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != '#' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		int s = 0, w = 0;

		switch (map[x][y]) {
		case 'v':
			w++;
			break;
		case 'o':
			s++;
			break;
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (0 <= nr && nr < R && 0 <= nc && nc < C) {
					if (map[nr][nc] != '#' && !visited[nr][nc]) {
						q.offer(new int[] { nr, nc });
						visited[nr][nc] = true;
						switch (map[nr][nc]) {
						case 'v':
							w++;
							break;
						case 'o':
							s++;
							break;
						}
					}
				}
			}
		}

		if (w >= s) // 늑대가 양보다 많거나 같으면
			s = 0; // 양은 잡아먹힘
		else
			w = 0;

		sheep += s;
		wolf += w;
	}

}
