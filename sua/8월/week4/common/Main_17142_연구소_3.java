import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소_3 {
	static int n, m, time, min, zero;
	//답 배열을 만들어서 최소대로 정렬, 첫번째가 -1이면 그 다음 수 출력
	static List<Integer> result;
	static List<Point> virus;
	static Point[] choice;
	static int[][] map;
	static Queue<Point> queue;
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
		boolean print = false;
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		
		map = new int[n][n];
		virus = new ArrayList<Point>();
		choice = new Point[m];
		result = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				map[i][j] = tmp;
				if(tmp == 2) {
					virus.add(new Point(i, j));
				}else if(tmp == 0) zero++;
			}
		}
		
		comb(0,0);

		Collections.sort(result);
		
		for(int i = 0; i < result.size(); i++) {
			if(result.get(i) != -1) {
				System.out.println(result.get(i));
				print = true;
				break;
			}
		}
		
		if(print == false) System.out.println(-1);
		
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == m) {
			int tmp = zero;
			time = 0;
			queue = new ArrayDeque<Point>();
			int[][] arr = new int[n][n];

			boolean[][] visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = map[i][j];
					if(arr[i][j] == 1) visited[i][j] = true;
				}		
			}
			
			for(int i = 0; i < m; i++) {
				queue.offer(choice[i]);
				visited[choice[i].x][choice[i].y] = true;
			}
			
			while(!queue.isEmpty() && tmp > 0) {
				int size = queue.size();
				for (int k = 0; k < size; k++) {
					Point p = queue.poll();
					int x = p.x;
					int y = p.y;
					
					for (int i = 0; i < 4; i++) {
						int tx = x + dx[i];
						int ty = y + dy[i];
						
						if(tx >= 0 && ty >= 0 && tx < n && ty < n && !visited[tx][ty]) {
							if(arr[tx][ty] == 0) tmp--;
							queue.offer(new Point(tx, ty));
							arr[tx][ty] = 2;
							visited[tx][ty] = true;
						}			
						
					}
					
				}
				time++;	
			}
			if(queue.isEmpty() && tmp > 0) time = -1;//못채우면 시간 -1로 바꾸고 
			
			result.add(time);
			return;
		}
		
		for (int i = start; i < virus.size(); i++) {
			choice[cnt] = virus.get(i);	
			comb(cnt+1, i+1);
		}
	}
	

}
