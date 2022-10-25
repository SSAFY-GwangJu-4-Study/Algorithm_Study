import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_최지성 {
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
	static int[][] pipe = {{}, { 0, 1, 2, 3 }, { 0, 2 }, { 1, 3 }, { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
	static int N, M, r, c, L;
	static int[][] map;
	static boolean[][] visited;
	static int cnt; // 정답

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Point> q = new ArrayDeque<>();
			q.offer(new Point(r,c));
			visited[r][c] = true;
			int time = 1;
			cnt = 1;
			
			while(!q.isEmpty() && time < L) {
				for(int i = 0, size = q.size(); i < size; i++) {
					Point p = q.poll();
					int tunnel = map[p.y][p.x];
			
					for(int j = 0, tsize = pipe[tunnel].length; j < tsize; j++) {
						int d = pipe[tunnel][j];
						int nr = p.y + delta[d][0];
						int nc = p.x + delta[d][1];
						
						if(nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] != 0 && connect(d, map[nr][nc])) {
							visited[nr][nc] = true;
							q.offer(new Point(nr, nc));
							cnt++;
						}
					}
				}
				
				time++;
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	public static boolean connect(int d, int p) {
		for(int i = 0, size = pipe[p].length; i < size; i++) {
			if(pipe[p][i] == (d + 2) % 4) {
				return true;
			}
		}
		
		return false;
	}
}
