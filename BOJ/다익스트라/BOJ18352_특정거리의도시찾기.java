package day0113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ18352_특정거리의도시찾기 {

	static int N, M, K, X; // 도시, 도로, 거리, 출발도시
	static ArrayList<Node>[] list;
	static int[] dist; // 최단 거리

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		list = new ArrayList[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}

		int from, to;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, 1));
		}

		dijkstra(X);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if (dist[i] == K)
				sb.append(i + "\n");
		}
		if (sb.length() == 0)
			System.out.println(-1);
		else
			System.out.println(sb);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int cur = now.vertex;

			if (check[cur])
				continue;
			check[cur] = true;

			for (Node node : list[cur]) {
				if (dist[node.vertex] > dist[cur] + node.distance) {
					dist[node.vertex] = dist[cur] + node.distance;
					pq.add(new Node(node.vertex, dist[node.vertex]));
				}
			}
		}

	}

	static class Node implements Comparable<Node> {
		int vertex, distance;

		public Node() {
		}

		public Node(int vertex, int dist) {
			super();
			this.vertex = vertex;
			this.distance = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
}
