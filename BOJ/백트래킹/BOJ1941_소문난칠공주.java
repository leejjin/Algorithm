import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 1. 25명 중에서 7명 뽑기
// 2. 7명 중에서 최소 4명이 이다솜파인 경우 뽑기
// 3. 그 4명이 연결되어 있는지 확인
public class BOJ1941_소문난칠공주 {

	static int answer;
	static char[][] map = new char[5][5];
	static boolean[] visited = new boolean[25];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 1. 25명 중에서 7명 뽑기
		for (int i = 0; i < 25; i++) {
			combination(i, 1, 0);
		}

		System.out.println(answer);
	}

	private static void combination(int start, int cnt, int dasomCnt) {
		if (map[start / 5][start % 5] == 'S') // 이다솜파이면
			dasomCnt++;
		visited[start] = true; // 방문 표시

		if (cnt == 7) { // 기저조건
			if (dasomCnt >= 4) { // 다솜파가 4명 이상인 경우
				if (bfs(start / 5, start % 5)) // bfs 를 돌며 연결되어 있는지 확인한다.
					answer++;
			}
			visited[start] = false;
			return;
		}

		for (int i = start; i < 25; i++) {
			if (!visited[i]) {
				combination(i, cnt + 1, dasomCnt);
			}
		}
		visited[start] = false; // 백트래킹
	}

	private static boolean bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] used = new boolean[5][5];

		q.offer(new int[] { r, c });
		used[r][c] = true;
		int linkCnt = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
					if (!used[nr][nc] && visited[nr * 5 + nc]) { // bfs에서 방문하지 않았고, 칠공주에 소속되었으면
						used[nr][nc] = true;
						q.offer(new int[] { nr, nc });
						linkCnt++;
					}
				}
			}
		}
		if (linkCnt == 7)
			return true;
		else
			return false;
	}
