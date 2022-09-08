import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {
	static int m, n, result;
	static int map[][], memo[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		memo = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				memo[i][j] = -1;
			}
		}

		System.out.println(dfs(0,0));

	}

	public static int dfs(int x, int y) {

		if (x == n - 1 && y == m - 1) {// 끝에 도달한 경우
			return 1;
		}

		if (memo[x][y] != -1) {// 이미 탐색이 된 경우
			return memo[x][y];//그 때까지 저장된 경우의 수 반환
		} else {
			memo[x][y] = 0;
			for (int i = 0; i < 4; i++) {
				int tx = x + dx[i];
				int ty = y + dy[i];

				if (tx >= 0 && tx < n && ty >= 0 && ty < m) {
					if (map[x][y] > map[tx][ty])
						memo[x][y] += dfs(tx, ty);
				}

			}
		}
		return memo[x][y];
	}
}
