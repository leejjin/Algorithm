package day0106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1647_도시분할계획 {

	private static int N, M;
	private static Edge[] edgeList;
	private static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		edgeList = new Edge[M];
		parents = new int[N + 1];

		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(a, b, c);
		}

		Arrays.sort(edgeList);
		make();

		int cnt = 0, result = 0, max = 0;
		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				cnt++;
				result += edge.weight;
				if (max < edge.weight)
					max = edge.weight;
				if (cnt == N - 1) {
					result -= max;
					break;
				}
			}
		}
		System.out.println(result);
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	public static class Edge implements Comparable<Edge> {

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
