import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1197_최소스패닝트리_크루스칼 {

	private static int V, E;
	private static Edge[] edgeList;
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		edgeList = new Edge[E];
		parents = new int[V + 1];

		int A, B, C;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(A, B, C);
		}

		Arrays.sort(edgeList);

		make();

		int cnt = 0, result = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				cnt++;
				result += edge.weight;
				if (cnt == V - 1)
					break;
			}
		}
		System.out.println(result);
	}

	// 각 정점은 자기 자신을 부모로 칭함
	private static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) // 이미 같은 부모 아래 있음
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge() {
		}

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
