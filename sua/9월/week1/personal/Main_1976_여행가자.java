import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1976_여행가자 {
	public static int parents[];
	public static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		int[] plan = new int[m];

		make();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int c = Integer.parseInt(st.nextToken());

				if (c == 1) {
					union(i, j);
				}
				
			}
			st = new StringTokenizer(br.readLine());
		}

		for (int i = 0; i < m; i++) {
			plan[i] = Integer.parseInt(st.nextToken());

			if (find(plan[0]) != find(plan[i])) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}

	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return;

		parents[bRoot] = aRoot;
	}

	public static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	public static void make() {
		parents = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			parents[i] = i;
		}
	}

}
