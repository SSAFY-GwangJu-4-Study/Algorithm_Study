import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
//	G4 2573 빙산
public class Main_2573 {
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static int M;
	static int[][] map;
	static int[][] tempMap;
	static Queue<Point> q;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int day;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		tempMap = new int[N][M];
		q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				q.offer(new Point(i, j));
			}
		}
		copy(map, tempMap);
		bfs();
		System.out.println(day);
	}

	private static void copy(int[][] src, int[][] to) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				to[i][j] = src[i][j];
			}
		}
	}

	private static void bfs() {
		day = 0;

//		visited = new boolean[N][M];
//		if(check()) {
//			return;
//		}
		while (!q.isEmpty()) {
			day++;
			visited = new boolean[N][M];
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point p = q.poll();
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int dx = p.x + delta[d][0];
					int dy = p.y + delta[d][1];
					if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] == 0) {
						cnt++;
					}
				}
				if (map[p.x][p.y] <= cnt) {
					tempMap[p.x][p.y] = 0;
				} else {
					tempMap[p.x][p.y] -= cnt;
					q.offer(new Point(p.x, p.y));
				}
			}
			copy(tempMap, map);
//			print(map);

			if (check()) {
				return;
			}
		}
		day = 0;
	}

	private static boolean check() {
		int c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visited[i][j]) {
					c++;
					if (c >= 2) {
//						System.out.println("count "+c);
						return true;
					}
					visited[i][j] = true;

//					System.out.println(i + " " + j);
					dfs(i, j);
				}
			}
		}
		return false;
	}

	private static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] != 0 && !visited[nx][ny]) {
				visited[nx][ny] = true;
//				System.out.println(nx + " " + ny);
				dfs(nx, ny);
			}
		}
	}

	private static void print(int[][] m) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
