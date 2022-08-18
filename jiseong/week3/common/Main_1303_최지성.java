import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1303_최지성 {
	static int[][] delta = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	static int[] cnt;// dfs하면서 만나는 팀의 수 / 화이트, 블루
	static int[] pow; // 위력 / 화이트, 블루

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		visited = new boolean[M][N];
		cnt = new int[2];
		pow = new int[2];

		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					char team = map[i][j];
					dfs(i, j, team);

					if (team == 'W') {
						pow[0] += cnt[0] * cnt[0];
						cnt[0] = 0;
					} else {
						pow[1] += cnt[1] * cnt[1];
						cnt[1] = 0;
					}
				}
			}
		}

		System.out.println(pow[0] + " " + pow[1]);
	}

	public static void dfs(int r, int c, char team) {
		if (team == 'W') {
			cnt[0]++;
		} else {
			cnt[1]++;
		}

		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + delta[i][1];
			int nc = c + delta[i][0];

			if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == team && !visited[nr][nc])
				dfs(nr, nc, team);
		}
	}
}
