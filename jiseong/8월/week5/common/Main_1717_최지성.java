import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_최지성 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] set = new int[n + 1];

		make(set);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int cmd = Integer.parseInt(st.nextToken());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			if (cmd == 0) {
				union(v1, v2, set);
			} else if (cmd == 1) {
				sb.append((find(v1, set) == find(v2, set) ? "YES" : "NO") + "\n");
			}
		}

		System.out.println(sb.toString());

	}

	public static void make(int[] set) {
		for (int i = 0; i < set.length; i++) {
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
