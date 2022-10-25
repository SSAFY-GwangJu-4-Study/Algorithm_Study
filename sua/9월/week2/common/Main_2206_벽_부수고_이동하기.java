import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽_부수고_이동하기 {
	static int N, M, min;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Point {
		int x, y, distance, broken;

		Point(int x, int y, int distance, int broken) {
			this.x = x;
			this.y = y;
			this.distance = distance;
			this.broken = broken;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		visited = new boolean[N][M][2];
		
		bfs();

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	static void bfs() {
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.offer(new Point(0, 0, 1, 0));
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			
			for (int i = 0, n = queue.size(); i < n; i++) {
				Point p = queue.poll();
				int tx = p.x;
				int ty = p.y;
				int td = p.distance;
				int tb = p.broken;
				
				if(tx == N-1 && ty == M-1) {
					min = Math.min(min, td);
					continue;
				}
				
				for (int j = 0; j < 4; j++) {
					int nx = tx + dx[j];
					int ny = ty + dy[j];

					if (nx >= 0 && nx < N && ny >= 0 && ny < M) {// 맵을 벗어나지 않을 때
						if(tb == 1) {//이미 벽 뿌숨
							if (!visited[nx][ny][tb] && (map[nx][ny] == 0)) {
								queue.offer(new Point(nx, ny, td+1, tb));
								visited[nx][ny][tb] = true;
							}
						}else {//안부쉈을때
							if(map[nx][ny] == 0) {
								if(!visited[nx][ny][tb]) {
									queue.offer(new Point(nx, ny, td+1, tb));
									visited[nx][ny][tb] = true;
								}
							}else {
								if(!visited[nx][ny][tb+1]) {
									queue.offer(new Point(nx, ny, td+1, tb+1));
									visited[nx][ny][tb+1] = true;
								}
							}
						}
						
					}
				}
			}
			
			
		}
	}
}
