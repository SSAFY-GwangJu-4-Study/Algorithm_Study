import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1012번 유기농 배추 실버2
 * 
 * @author 김경삼
 *
 */
public class Main_1012_김경삼 {
	static int N, M, K, cnt;
	static int[][] warms;
	static int[][] map;
	static int[] deltaR = { -1, 1, 0, 0 }; // 상하좌우
	static int[] deltaC = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			warms = new int[K][2];
			map = new int[N][M];
			cnt = 0;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						dfs(i, j); 
						cnt++;	//dfs 호출 횟수가 cnt
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int r, int c) {
		map[r][c] = 0; // 방문 처리, visited 필요 없어짐.
		for (int i = 0; i < 4; i++) {
			int nr = r + deltaR[i];
			int nc = c + deltaC[i];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if (map[nr][nc] != 1)
				continue;
			dfs(nr,nc);
		}
	}
}
