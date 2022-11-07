import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
	static int N, M;
	static int[][] iceberg;
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
		M = Integer.parseInt(st.nextToken());
		
		iceberg = new int [N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				iceberg[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(timer());
	}
	
	public static int timer() {
		int time = 0;
		
		if(check() == 2) return 0;
		
		while(true) {
			time++;
			boolean melted = melt();
			if(melted) {
				if(check() == 2) {
					return time;
				}else if(check() == -1) {
					return 0;
				}
			}
		}
	}
	
	public static boolean melt() {//다 녹아 없어진 게 하나라도 있으면 true 반환
		boolean flag = false;
		int[][] tmp = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmp[i][j] = iceberg[i][j];
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(iceberg[i][j] == 0) continue;
				
				int cnt = 0;
				for(int m = 0; m < 4; m++) {
					int tx = i + dx[m];
					int ty = j + dy[m];
					
					if(tx >= 0 && tx < N && ty >= 0 && ty < M && iceberg[tx][ty] == 0) {
						cnt++;
					}
				}			
				tmp[i][j] = iceberg[i][j] - cnt;
				if(tmp[i][j] < 0) tmp[i][j] = 0;
				if(tmp[i][j] == 0) flag = true;
			}			
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				iceberg[i][j] = tmp[i][j];
			}
		}
		
		return flag;
	}
	
	public static int check() {
		int x = 0, y = 0, cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(iceberg[i][j] != 0) {
					x = i;
					y = j;
					cnt++;
				}
			}
		}
		if(cnt == 0) return -1;//다 녹아있으면 -1 반환
		
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.offer(new Point(x, y));
		cnt = cnt-1;
		boolean[][] visited = new boolean[N][M];
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			
			for(int i = 0, size = queue.size(); i < size; i++) {
				Point p = queue.poll();
				
				for(int j = 0; j < 4; j++) {
					int tx = p.x + dx[j];
					int ty = p.y + dy[j];
					
					if(tx >= 0 && tx < N && ty >= 0 && ty < M && !visited[tx][ty] && iceberg[tx][ty] != 0) {
						cnt = cnt-1;
						queue.offer(new Point(tx, ty));
						visited[tx][ty] = true;
					}
				}
			}
		}
		if(cnt == 0) return 1; //한번에 다 돌아지면 1 반환
		return 2;//한 번 돌았는데 빙산 남아있으면 2 반환
	}

}
