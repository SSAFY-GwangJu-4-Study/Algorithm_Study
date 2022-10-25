import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14620_최지성 {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N;
	static int[][] map;
	static int[][] sumMap;
	static boolean[][] visited;
	static int cost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		sumMap = new int[N][N];
		visited = new boolean[N][N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int tempSum = 0;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				tempSum = map[i][j];
				for (int d = 0; d < 4; d++) {
					tempSum += map[i + delta[d][0]][j + delta[d][1]];
				}
				sumMap[i][j] = tempSum;
			}
		}

//		checkVisitTrue(4, 1);
//		checkVisitTrue(1, 1);
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(visited[i][j]? 1 : 0);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		checkVisitFalse(1, 1);
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(visited[i][j]? 1 : 0);
//			}
//			System.out.println();
//		}

		cost = Integer.MAX_VALUE;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				dfs(i, j, 0, 0);
			}
		}

		System.out.println(cost);
	}

	public static void dfs(int y, int x, int cnt, int sum) {
		if (cnt == 3) {
			cost = Math.min(cost, sum);

			return;
		}

		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (canPlant(i, j)) {
					visited[i][j] = true;
					dfs(i, j, cnt + 1, sum + sumMap[i][j]);
					visited[i][j] = false;
				}
			}
		}
	}

	public static boolean canPlant(int r, int c) {
		for (int i = r - 2; i <= r + 2; i++) {
			for (int j = c - (2 - Math.abs(r - i)); j <= c + (2 - Math.abs(r - i)); j++) {
				if (i >= 0 && i < N && j >= 0 && j < N) {
					if (visited[i][j])
						return false;
				}
			}
		}
		return true;
	}

//	public static void checkVisitTrue(int r, int c) {
//		for (int i = r - 2; i <= r + 2; i++) {
//			for (int j = c - (2 - Math.abs(r - i)); j <= c + (2 - Math.abs(r - i)); j++) {
//				if (i >= 0 && i < N && j >= 0 && j < N)
//					visited[i][j] = true;
//			}
//		}
//	}
//
//	public static void checkVisitFalse(int r, int c) {
//		for (int i = r - 2; i <= r + 2; i++) {
//			for (int j = c - (2 - Math.abs(r - i)); j <= c + (2 - Math.abs(r - i)); j++) {
//				if (i >= 0 && i < N && j >= 0 && j < N)
//					visited[i][j] = false;
//			}
//		}
//	}
}
