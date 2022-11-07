import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	static int N, safe;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] check;
	static List<Integer> list;
	static Queue<Point> queue;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<Integer>();
		check = new boolean[101];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				check[map[i][j]] = true;
			}
		}
		
		for (int i = 1; i < 101; i++) {
			if(check[i]) list.add(i);
		}
		
		System.out.println(calSafe());
		
	}
	
	static int calSafe() {
		int max = 1;
		for (int i = 0, size = list.size()-1; i <= size; i++) {
			visited = new boolean[N][N];
			int nowsafe = 0;
			int high = list.get(i);
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(high >= map[j][k]) {
						visited[j][k] = true;
						cnt++;
					}
				}
			}
			
			while(cnt < N*N) {
				queue = new ArrayDeque<Point>();
				Loop1:
				for (int j = 0; j < N; j++) {
					for (int k = 0; k < N; k++) {
						if(!visited[j][k]) {
							queue.offer(new Point(j, k));
							visited[j][k] = true;
							cnt++;
							nowsafe++;
							break Loop1;
						}
					}
				}
				
				while(!queue.isEmpty()) {				
					Point p = queue.poll();
					for (int j = 0; j < 4; j++) {
						int tx = p.x + dx[j];
						int ty = p.y + dy[j];
						
						if(tx >= 0 && ty >= 0 && tx < N && ty < N && !visited[tx][ty]) {
							visited[tx][ty] = true;
							cnt++;
							queue.offer(new Point(tx, ty));
						}
					}
				}
				
			}
			if(max < nowsafe) max = nowsafe;
		}
		return max;
	}

}
