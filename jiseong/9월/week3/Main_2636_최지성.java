import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_최지성 {
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
	static int[][] map;
	static int[][] tempMap;
	static boolean[][] visited;
	static int restCheeze;
	static int recentCheeze;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tempMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1)
					restCheeze++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}

		int time = 0;
		Queue<Point> q = new ArrayDeque<>();

		while (restCheeze > 0) {
			recentCheeze = restCheeze;

			visited = new boolean[N][M];
			q.offer(new Point(0, 0));
			visited[0][0] = true;

			while (!q.isEmpty()) {
				Point now = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = now.y + delta[d][0];
					int nc = now.x + delta[d][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
						if (map[nr][nc] == 0) {
							visited[nr][nc] = true;
							q.offer(new Point(nr, nc));
						} else {
							visited[nr][nc] = true;
							tempMap[nr][nc] = 0;
							restCheeze--;
						}
					}
				}
			}
			
//			System.out.println(restCheeze);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = tempMap[i][j];
				}
			}
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			q.clear();
			time++;
		}

		System.out.println(time);
		System.out.println(recentCheeze);
	}
}
