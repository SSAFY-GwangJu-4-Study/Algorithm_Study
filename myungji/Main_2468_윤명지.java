import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_À±¸íÁö {

	static int N;
	static boolean ch[][];
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		int max = Integer.MIN_VALUE;
		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i][j]);
			}
		}

		for (int i = 0; i <= max; i++) {
			map = new int[N][N];
			int cnt = 0;
			ch = new boolean[N][N];

			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					if (arr[a][b] <= i) {
						map[a][b] = 0;
					} else {
						map[a][b] = 1;
					}
				}
			}

			for (int a = 0; a < N; a++) {
				for (int b = 0; b < N; b++) {
					if (map[a][b] == 1 && !ch[a][b]) {
						dfs(a, b);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);

		}

		System.out.println(ans);

	}

	public static void dfs(int x, int y) {
		ch[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (map[nx][ny] == 1 && !ch[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
	}

}
