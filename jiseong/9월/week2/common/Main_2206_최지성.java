import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_최지성 {
	static class Point {
		int y;
		int x;
		int count;

		public Point(int y, int x, int count) {
			super();
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		String line = null;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		int cnt = bfs() + 1;

		System.out.println(cnt);
	}

	public static int bfs() {
		Queue<Point> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N][M][2];
		q.offer(new Point(0, 0, 0));
		visited[0][0][0] = true;
		int count = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Point now = q.poll();
				visited[now.y][now.x][now.count] = true;
				
//				System.out.println(count + " " + now.y + " " + now.x + " " + now.count);

				if (now.y == N - 1 && now.x == M - 1) {
					return count;
				}

				for (int d = 0; d < 4; d++) {
					int nr = now.y + delta[d][0];
					int nc = now.x + delta[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc][now.count]) {
						if (now.count == 1) {
							if (map[nr][nc] == 0) {
								visited[nr][nc][1] = true;
								q.offer(new Point(nr, nc, 1));
							}
						} else {
							if (map[nr][nc] == 0) {
								visited[nr][nc][0] = true;
								q.offer(new Point(nr, nc, 0));
							} else {
								visited[nr][nc][1] = true;
								q.offer(new Point(nr, nc, 1));
							}
						}
					}
				}
			}

			count++;
		}
		
		return -2;
	}
}
