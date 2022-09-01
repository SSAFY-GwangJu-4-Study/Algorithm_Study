import java.util.Arrays;
import java.util.Scanner;

public class Main_1197_최소_스패닝_트리 {
	public static int[] parents;
	public static int v, e;
	public static Edge[] edgeList;

	public static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();

		edgeList = new Edge[e];

		for (int i = 0; i < e; i++) {
			int start = sc.nextInt() - 1;
			int end = sc.nextInt() - 1;
			int weight = sc.nextInt();
			edgeList[i] = new Edge(start, end, weight);
		}
		Arrays.sort(edgeList);

		make();

		int cnt = 0;
		long result = 0;
		for (Edge edge : edgeList) {
			if (union(edge.start, edge.end)) {
				result += edge.weight;
				if (++cnt == v - 1)
					break;
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
		parents = new int[v];
		for (int i = 0; i < v; i++) {
			parents[i] = i;
		}
	}
}
