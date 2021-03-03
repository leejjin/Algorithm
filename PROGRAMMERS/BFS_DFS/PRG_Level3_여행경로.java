import java.util.ArrayList;
import java.util.Collections;

public class PRG_Level3_여행경로 {

	static ArrayList<String> route;
	static boolean[] visited;

	public static String[] solution(String[][] tickets) {

		visited = new boolean[tickets.length];
		route = new ArrayList<String>();

		dfs(0, "ICN", "ICN", tickets);

		Collections.sort(route);

		String[] answer = route.get(0).split(" ");

		return answer;
	}

	private static void dfs(int cnt, String now, String tempRoute, String[][] tickets) {
		if (cnt == tickets.length) {
			route.add(tempRoute);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && tickets[i][0].equals(now)) {
				visited[i] = true;
				dfs(cnt + 1, tickets[i][1], tempRoute + " " + tickets[i][1], tickets);
				visited[i] = false;
			}
		}
		return;
	}

	public static void main(String[] args) {
		String[][] arr = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		String[][] arr2 = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } };
		solution(arr);
		System.out.println(route);
		solution(arr2);
		System.out.println(route);
	}
}
