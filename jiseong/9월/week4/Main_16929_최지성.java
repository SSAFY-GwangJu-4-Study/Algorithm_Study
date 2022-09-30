import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16929_최지성 {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M;
	static char[][] map;
	static boolean[][] visited; // dfs를 돌 때 방문 체크
	static boolean cycle;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(0, i, j, i, j, map[i][j]);

				if (cycle)
					break loop;
			}
		}

		System.out.println(cycle ? "Yes" : "No");
	}

	public static void dfs(int cnt, int r, int c, int srcR, int srcC, char ch) {
		if (cnt >= 4 && r == srcR && c == srcC) {
			cycle = true;
			return;
		}

		if (cnt > 0 && cnt < 4 && r == srcR && c == srcC) {
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == ch) {
				visited[nr][nc] = true;
				dfs(cnt + 1, nr, nc, srcR, srcC, ch);
				visited[nr][nc] = false;
			}
		}
	}
}
