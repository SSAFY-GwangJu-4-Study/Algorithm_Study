import java.util.Scanner;

public class Main_1717_집합의_표현 {
	public static int parents[];
	public static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();

		make();

		for (int i = 0; i < m; i++) {
			int order = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			if (order == 0) {// 합집합
				union(a, b);
			} else {// 같은 집합인지 확인
				if (find(a) == find(b))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}

		}
		
		System.out.println(sb);
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
