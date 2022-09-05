import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_최지성 {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int M;
	static int N;
	static int K;
	static int[][] farm;
	static boolean[][] visited;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			farm = new int[N][M];
			visited = new boolean[N][M];
			count = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				farm[r][c] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (farm[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}

			System.out.println(count);
		}
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nr = y + delta[i][0];
			int nc = x + delta[i][1];

			if (nc >= 0 && nc < M && nr >= 0 && nr < N && !visited[nr][nc] && farm[nr][nc] == 1) {
				dfs(nr, nc);
			}
		}
	}
}
