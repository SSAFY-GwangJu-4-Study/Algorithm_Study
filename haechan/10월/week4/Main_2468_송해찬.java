import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_2468_송해찬 {

	static int N, maxNum, minNum, ans;
	static int[][] grid;
	static boolean[][] visited;
	static int[][] deltas = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	
	static class Pos{
		int r, c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		maxNum = Integer.MIN_VALUE;
		minNum = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				maxNum = Math.max(maxNum, grid[i][j]);
				minNum = Math.min(minNum, grid[i][j]);
			}
		}
		// 아무도 안덮힌 경우도 있어서 minNum 부터가 아니라 minNum-1
		for(int i=minNum-1; i<maxNum; i++) {
			int temp = 0;
			// 방문배열 준비
			visited = new boolean[N][N];
			// 방문배열 먼저 꺼놓기
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(grid[r][c] <= i) {
						visited[r][c] = true;
					}
				}
			}
			// bfs 시작
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(visited[r][c] == false) {
						bfs(r,c);
						temp++;
					}
				}
			}
			// 구한 안전영역 최대값 저장
			ans = Math.max(ans, temp);
		}
		
		System.out.println(ans);
	}
	
	static void bfs(int r, int c) {
		
		Queue<Pos> queue = new ArrayDeque<Pos>();
		queue.offer(new Pos(r, c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for(int d=0; d<deltas.length; d++) {
				int nr = pos.r + deltas[d][0];
				int nc = pos.c + deltas[d][1];
				if(!isInside(nr, nc) || visited[nr][nc]) continue;
				queue.offer(new Pos(nr, nc));
				visited[nr][nc] = true;
			}
			
		}
	}
	
	static boolean isInside(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
