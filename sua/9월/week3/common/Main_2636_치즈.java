import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static int N, M, hour, last;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> queue;
	static Queue<Point> cheese;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static class Point{
		int x, y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		airVisit();

		System.out.println(hour);
		System.out.println(last);
	}
	
	static void airVisit() {
		queue = new ArrayDeque<Point>();
		cheese = new ArrayDeque<Point>();
		queue.offer(new Point(0,0));
		visited[0][0] = true;
		
		while(!isVisit()) {
			hour++;
			while(!queue.isEmpty()) {
				for (int i = 0, n = queue.size(); i < n; i++) {
					Point p = queue.poll();
					int x = p.x;
					int y = p.y;
					
					for (int j = 0; j < 4; j++) {
						int tx = x + dx[j];
						int ty = y + dy[j];
						if(tx >= 0 && ty >= 0 && tx < N && ty < M) {
							if(!visited[tx][ty] && map[tx][ty] == 0) {
								queue.offer(new Point(tx, ty));
								visited[tx][ty] = true;
							}if(!visited[tx][ty] && map[tx][ty] == 1) {
								cheese.offer(new Point(tx, ty));
								visited[tx][ty] = true;
							}
						}
						
					}
				}		
			}
			last = cheese.size();
			for (int i = 0, n = cheese.size(); i < n; i++) {
				queue.offer(cheese.poll());
			}		
		}	
	}
	
	static boolean isVisit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] == false && map[i][j] == 1) return false;
			}
		}
		return true;
	}	
}
