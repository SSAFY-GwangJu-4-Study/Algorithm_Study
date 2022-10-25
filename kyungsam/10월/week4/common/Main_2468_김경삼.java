import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 안전 영역 문제
 * 
 * @author 김경삼
 *
 */
public class Main_2468_김경삼 {
	static int N, maxHeight, cnt, ans;
	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };

	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		maxHeight = 0;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
//		System.out.println(maxHeight);
		for (int k = 0; k < maxHeight; k++) {
			cnt = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]&&map[i][j] > k) {
						dfs(i, j, k);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int height) {
		visited[r][c]=true;
		int cur = map[r][c];

		for (int d = 0; d < 4; d++) {
			int nr = r + deltaR[d];
			int nc = c + deltaC[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] <= height) {
				continue;
			}
			dfs(nr,nc,height);
		}
	}

}
