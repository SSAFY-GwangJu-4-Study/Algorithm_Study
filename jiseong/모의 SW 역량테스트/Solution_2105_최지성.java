import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 다음 위치의 숫자가 겹치는 숫자면 더 이상 안감
 */

public class Solution_2105_최지성 {
	static int[][] delta = { { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 } }; // 우상부터 시계방향
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] eat; // 먹은 디저트
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			max = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			eat = new boolean[101];

			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i < N - 1; i++) {
				for (int j = 0; j < N - 2; j++) {
//					System.out.println("시작");
					dfs(i, j, 0, 0, -1, -1);
//					System.out.println();
				}
			}

			System.out.println("#" + tc + " " + max);
		}
	}

	public static void dfs(int r, int c, int stage, int len, int up, int down) {
//		System.out.println(r + " " + c + " " + stage + " " + map[r][c]);
//
//		for (int i = 0; i < 10; i++) {
//			System.out.print(eat[i] ? 1 + " " : 0 + " ");
//		}
//		System.out.println();

		if (stage == 4) {
			max = Math.max(max, len);
//			System.out.println("야옹 + " + len);
			return;
		}

		int nr, nc, count;
		boolean canGo;
		switch (stage) {
		case 0:
			nr = r + delta[stage][0];
			nc = c + delta[stage][1];
			count = 0;

			while (nr >= 0 && nc < N) {
				if (eat[map[nr][nc]]) {
					break;
				}

				eat[map[nr][nc]] = true;
				dfs(nr, nc, 1, ++count, count, down);

				nr = nr + delta[stage][0];
				nc = nc + delta[stage][1];
			}

			for (int i = 0; i < count; i++) {
				nr = nr + delta[(stage + 2) % 4][0];
				nc = nc + delta[(stage + 2) % 4][1];

				eat[map[nr][nc]] = false;
			}

			break;
		case 1:
			nr = r + delta[stage][0];
			nc = c + delta[stage][1];
			count = 0;

			while (nr < N && nc < N) {
				if (eat[map[nr][nc]]) {
					break;
				}

				eat[map[nr][nc]] = true;
				dfs(nr, nc, 2, len + ++count, up, count);

				nr = nr + delta[stage][0];
				nc = nc + delta[stage][1];
			}
			
			for (int i = 0; i < count; i++) {
				nr = nr + delta[(stage + 2) % 4][0];
				nc = nc + delta[(stage + 2) % 4][1];
				eat[map[nr][nc]] = false;
			}

			break;
		case 2:
			if (r + up >= N)
				return;

			nr = r;
			nc = c;
			count = 0;
			canGo = true;

			for (int i = 0; i < up; i++) {
				nr = nr + delta[stage][0];
				nc = nc + delta[stage][1];

				if (eat[map[nr][nc]]) {
					canGo = false;
					break;
				}

				eat[map[nr][nc]] = true;
				count++;
			}

			if (canGo)
				dfs(nr, nc, 3, len + up, up, down);

			if (canGo) {
				for (int i = 0; i < count; i++) {
					eat[map[nr][nc]] = false;

					nr = nr + delta[(stage + 2) % 4][0];
					nc = nc + delta[(stage + 2) % 4][1];
				}
			} else {
				for (int i = 0; i < count; i++) {
					nr = nr + delta[(stage + 2) % 4][0];
					nc = nc + delta[(stage + 2) % 4][1];
					eat[map[nr][nc]] = false;
				}
			}

			break;
		case 3:
			nr = r;
			nc = c;
			count = 0;
			canGo = true;

			for (int i = 0; i < down; i++) {
				nr = nr + delta[stage][0];
				nc = nc + delta[stage][1];

				if (eat[map[nr][nc]]) {
					canGo = false;
					break;
				}

				eat[map[nr][nc]] = true;
				count++;
			}

			if (canGo)
				dfs(nr, nc, 4, len + down, up, down);

			if (canGo) {
				for (int i = 0; i < count; i++) {
					eat[map[nr][nc]] = false;

					nr = nr + delta[(stage + 2) % 4][0];
					nc = nc + delta[(stage + 2) % 4][1];
				}
			} else {
				for (int i = 0; i < count; i++) {
					nr = nr + delta[(stage + 2) % 4][0];
					nc = nc + delta[(stage + 2) % 4][1];
					eat[map[nr][nc]] = false;
				}
			}

			break;
		}
	}
}
