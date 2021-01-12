import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753_최단경로 {

	static int INF = Integer.MAX_VALUE;
	static int V, E, K;
	static int[] dist; // 최단 거리 저장 배열
	static ArrayList<Node>[] list;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		dist = new int[V + 1];
		list = new ArrayList[V + 1];

		Arrays.fill(dist, INF);

		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<Node>();
		}

		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, weight));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF)
				sb.append("INF\n");
			else
				sb.append(dist[i] + "\n");
		}
		System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V + 1];
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int cur = now.vertex;

			if (check[cur] == true)
				continue;
			check[cur] = true;

			for (Node node : list[cur]) {
				if(dist[node.vertex] > dist[cur] + node.distance) {
					dist[node.vertex] = dist[cur] + node.distance;
					pq.add(new Node(node.vertex, dist[node.vertex]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int vertex;
		int distance;

		public Node() {
		}

		public Node(int vertex, int distance) {
			super();
			this.vertex = vertex;
			this.distance = distance;
		}

		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}

}
