import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2589_보물섬 {
	static int r, c, max;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static char[][] map;
	static boolean[][] visited;
	static Queue<Point> queue;

	static class Point {
		int x, y, distance;

		public Point(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		max = 0;
		int tmp = 0;

		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'L') {
					visited = new boolean[r][c];
					tmp = bfs(i,j);
					max = Math.max(tmp, max);
				}
			}
		}

		System.out.println(max);

	}

	static int bfs(int x, int y) {
		queue = new ArrayDeque<Point>();
		queue.offer(new Point(x, y, 0));
		visited[x][y] = true;
		int distance = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				if (tx >= 0 && ty >= 0 && tx < r && ty < c)
					if (!visited[tx][ty] && map[tx][ty] == 'L') {
						queue.offer(new Point(tx, ty, p.distance + 1));
						distance = Math.max(distance, p.distance+1);
						visited[tx][ty] = true;
					}

			}
		}
		return distance;
	}

}
