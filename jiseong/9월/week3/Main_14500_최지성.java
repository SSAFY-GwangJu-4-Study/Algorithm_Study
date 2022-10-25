import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_최지성 {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(0, i, j, 0);
				countConvex(i, j);
			}
		}

		System.out.println(max);
	}

	public static void dfs(int cnt, int r, int c, int sum) {
		if (cnt == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(cnt + 1, nr, nc, sum + map[nr][nc]);
				visited[nr][nc] = false;
			}
		}
	}

	public static void countConvex(int r, int c) {
		int sum;
		int nr, nc;

		for (int d = 0; d < 4; d++) {
			sum = map[r][c];

			for (int i = 0; i < 3; i++) {
				nr = r + delta[(d + i) % 4][0];
				nc = c + delta[(d + i) % 4][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M)
					sum += map[nr][nc];
			}

			max = Math.max(max, sum);
		}
	}
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int max = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        int[][] maps = new int[N + 6][M + 6];

        for (int i = 3; i < N + 3; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 3; j < M + 3; j++) {
                maps[i][j] = Integer.parseInt(inputs[j - 3]);
            }
        }

        brute(maps);
        System.out.println(max);
    }

    private static void brute(final int[][] maps) {
        for (int i = 3; i < N + 3; i++) {
            for (int j = 3; j < M + 3; j++) {
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 2][j] + maps[i + 3][j]);
                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i][j + 2] + maps[i][j + 3]);

                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i + 1][j] + maps[i + 1][j + 1]);

                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i][j + 2] + maps[i + 1][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i][j + 2] + maps[i - 1][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 2][j] + maps[i + 2][j + 1]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 2][j] + maps[i + 2][j - 1]);
                max = Math.max(max, maps[i][j] + maps[i - 1][j] + maps[i - 2][j] + maps[i - 2][j - 1]);
                max = Math.max(max, maps[i][j] + maps[i - 1][j] + maps[i - 2][j] + maps[i - 2][j + 1]);
                max = Math.max(max, maps[i][j] + maps[i][j - 1] + maps[i][j - 2] + maps[i - 1][j - 2]);
                max = Math.max(max, maps[i][j] + maps[i][j - 1] + maps[i][j - 2] + maps[i + 1][j - 2]);

                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i + 1][j + 1] + maps[i + 1][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i - 1][j + 1] + maps[i - 1][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 1][j + 1] + maps[i + 2][j + 1]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 1][j - 1] + maps[i + 2][j - 1]);

                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i + 1][j + 1] + maps[i][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i][j + 1] + maps[i - 1][j + 1] + maps[i][j + 2]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 1][j + 1] + maps[i + 2][j]);
                max = Math.max(max, maps[i][j] + maps[i + 1][j] + maps[i + 1][j - 1] + maps[i + 2][j]);
            }
        }
    }
}
 */
