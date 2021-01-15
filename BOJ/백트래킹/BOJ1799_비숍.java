package day0115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1799_비숍 {

	static int N; // 체스판의 크기
	static int[] answer = new int[2]; // 검정, 흰색 칸의 비숍의 수
	static int[][] chess; // 체스판. 비숍을 놓을 수 없는 곳은 0으로 표시
	static boolean[][] color; // 체스판처럼 검은 칸을 기억함
	static boolean[][] visited;
	static int[] dr = { -1, -1 }; // 좌상 우상
	static int[] dc = { -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N][N];
		color = new boolean[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				chess[i][j] = Integer.parseInt(st.nextToken());
				// color 배열을 통해 체스판처럼 색깔 표시를 함
				color[i][j] = (i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0);
			}
		}

		// -1 : 처음 시작할 때 비숍을 놓지 않는 경우 체크
		solve(-1, true, 0);
		solve(-1, false, 0);

		System.out.println(answer[0] + answer[1]);
	}

	private static void solve(int idx, boolean isBlack, int cnt) {
		// 이중 for 문을 사용하지 않고 N*N 탐색
		for (int i = idx + 1; i < N * N; i++) {
			int r = i / N;
			int c = i % N;

			// 체스판에 놓을 수 없는 곳이거나, 색상이 일치하지 않으면 비숍을 놓을 수 없음
			if (chess[r][c] == 0 || color[r][c] != isBlack)
				continue;

			if (dfs(r, c)) {
				visited[r][c] = true;
				solve(i, isBlack, cnt + 1); // cnt : 비숍의 수 카운트
				visited[r][c] = false;
			}
		}

		if (isBlack) // 검정일 때
			answer[0] = Math.max(answer[0], cnt);
		else // 흰색일 때
			answer[1] = Math.max(answer[1], cnt);
	}

	// 현재 위치에서 비숍을 놓을 수 있는가 dfs를 돌며 판별함
	private static boolean dfs(int r, int c) {

		// 현재 위치에서 아래쪽은 비숍이 없는 상태, 위쪽은 비숍이 있을 수 있는 상태이다.
		// 그러므로 위쪽에 비숍이 있는지만 판별해주면 되므로 좌상, 우상만 탐색한다.
		for (int i = 0; i < 2; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			for (int j = 0; j < N; j++) {
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc]) // 비숍이 있으면 false 리턴
					return false;

				// 대각선 이동
				nr += dr[i];
				nc += dc[i];
			}

		}
		// 비숍을 놓을 수 있음
		return true;
	}
}
