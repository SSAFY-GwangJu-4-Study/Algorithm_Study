import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1197_최지성 {
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] set = new int[V + 1];
		ArrayList<Edge> edges = new ArrayList<>();

		make(set);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edges.add(new Edge(v1, v2, w));
		}

		Collections.sort(edges);

		long mst = 0;
		for (int i = 0, size = edges.size(); i < size; i++) {
			Edge now = edges.get(i);

			if (union(now.to, now.from, set)) {
				mst += (long) now.weight;
			}
		}

		System.out.println(mst);
	}

	public static void make(int[] set) {
		for (int i = 1; i < set.length; i++) {
			set[i] = i;
		}
	}

	public static int find(int i, int[] set) {
		if (set[i] == i)
			return i;
		else
			return set[i] = find(set[i], set);
	}

	public static boolean union(int i, int j, int[] set) {
		int s1 = find(i, set);
		int s2 = find(j, set);

		if (s1 == s2)
			return false;

		set[s2] = s1;

		return true;
	}
}
