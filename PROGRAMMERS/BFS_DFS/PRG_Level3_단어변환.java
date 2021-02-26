package day0224;

public class PRG_Level3_단어변환 {

	public int answer = 51;
	public boolean[] visited;

	public int solution(String begin, String target, String[] words) {

		visited = new boolean[words.length];

		dfs(0, begin, target, words);

		if (answer == 51) // 모두 탐색했지만 target이 없는 경우
			return 0;

		return answer;
	}

	private void dfs(int cnt, String now, String target, String[] words) {
		if (now.equals(target)) {
			if (answer > cnt)
				answer = cnt;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (!visited[i] && isDiffOneChar(now, words[i])) { // 방문 안했고 한글자만 다르면
				visited[i] = true; // 방문
				dfs(cnt + 1, words[i], target, words);
				visited[i] = false; // 복귀
			}
		}
	}

	// 한 글자만 다른지 체크
	private boolean isDiffOneChar(String now, String next) {
		int cnt = 0;
		for (int i = 0; i < now.length(); i++) {
			if (now.charAt(i) != next.charAt(i)) {
				cnt++;
				if (cnt > 1)
					return false;
			}
		}
		return true;
	}

}
