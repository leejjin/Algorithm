package day0224;

public class PRG_Level3_네트워크 {
	
	public boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(i, computers);
				answer++;
			}
		}
        
        return answer;
    }

	private void dfs(int idx, int[][] computers) {
		visited[idx] = true;
		
		for (int j = 0; j < computers.length; j++) {
			if(!visited[j] && computers[idx][j] == 1) {
				dfs(j, computers);
			}
		}
	}
}
