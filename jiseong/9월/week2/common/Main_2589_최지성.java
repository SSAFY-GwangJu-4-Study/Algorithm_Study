import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_최지성 {
	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M;
	static char[][] map;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L')
					explore(i, j);
			}
		}

		System.out.println(ans - 1);
	}

	public static void explore(int r, int c) {
		int count = 0;
		boolean[][] visited = new boolean[N][M];
		visited[r][c] = true;
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(r, c));

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Point now = q.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = now.y + delta[d][0];
					int nc = now.x + delta[d][1];

					if (nc >= 0 && nc < M && nr >= 0 && nr < N && map[nr][nc] == 'L' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc));
					}
				}
			}

			count++;
		}

		ans = Math.max(ans, count);
	}
}
