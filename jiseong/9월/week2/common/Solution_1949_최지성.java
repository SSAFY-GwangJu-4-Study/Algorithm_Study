import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1949_최지성 {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, K;
	static int[][] map;
	static int[][] top; // 봉우리 좌표 배열
	static int countOfTop; // 봉우리 개수
	static int topHeight; // 봉우리의 높이
	static boolean[][] visited;
	static int maxLen;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			top = new int[5][2];
			map = new int[N][N];
			
			countOfTop = 0;
			topHeight = 0;
			maxLen = 0;
			

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] > topHeight) {
						topHeight = map[i][j];
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == topHeight) {
						top[countOfTop][0] = i;
						top[countOfTop++][1] = j;
					}
				}
			}

			for (int i = 0; i < countOfTop; i++) {
				visited = new boolean[N][N];
				visited[top[i][0]][top[i][1]] = true;
				dfs(1, top[i][0], top[i][1], map[top[i][0]][top[i][1]],false);
				visited[top[i][0]][top[i][1]] = false;
			}

			System.out.println("#" + tc + " " + maxLen);
		}

	}

	public static void dfs(int cnt, int r, int c, int now, boolean cut) {
		for (int d = 0; d < 4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				if(now > map[nr][nc]) {
					visited[nr][nc] = true;
					dfs(cnt + 1, nr, nc, map[nr][nc], cut);
					visited[nr][nc] = false;
				}
				if(!cut && now <= map[nr][nc] && map[nr][nc] - K < now) {
					visited[nr][nc] = true;
					dfs(cnt + 1, nr, nc, now - 1, true);
					visited[nr][nc] = false;
				}
			}
		}
		
		maxLen = Math.max(maxLen, cnt);
	}
}
