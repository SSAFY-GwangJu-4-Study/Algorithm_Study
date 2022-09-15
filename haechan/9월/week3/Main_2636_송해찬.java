import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_2636_송해찬 {

	static int N, M, cheeseCnt;
	static int[][] grid, grid2;
	static int[][] deltas = {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited;
	
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		grid2 = new int[N][M];
		
		// 첫 치즈 위치 받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				// 치즈 개수 세놓기
				if(grid[i][j] == 1) cheeseCnt++;
			}
		}
		
		int cnt = 0;
		int temp = 0;
		while(true) {
			visited = new boolean[N][M];
			temp = cheeseCnt;
			bfs(0, 0);
			meltingCheese();
			cnt++;
			if(cheeseCnt <= 0) {
				break;
			}
		}
		sb.append(cnt).append("\n").append(temp);
		System.out.println(sb);
	}
	
	static void bfs(int r, int c) {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(r, c));
		visited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			for(int d=0; d<deltas.length; d++) {
				int nr = pos.r + deltas[d][0];
				int nc = pos.c + deltas[d][1];
				if(!isInside(nr, nc) || visited[nr][nc]) continue;
				// 공기 중이면 계속 bfs 나아가기
				if(grid[nr][nc] == 0) {
					visited[nr][nc] = true;
					queue.offer(new Pos(nr, nc));
				}
				// 치즈 만나면 grid2 3만들고 스탑
				else {
					grid2[nr][nc] = 3;
				}
			}
		}
	}
	
	// grid2에 공기에 닿은 3인 위치 grid에서 0으로 만들기
	static void meltingCheese() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(grid2[i][j] == 3) {
					grid[i][j] = 0;
					// 녹은 개수만큼 치즈 개수 빼기
					cheeseCnt--;
					// grid2 원상태로 돌려놓기
					grid2[i][j] = 0;
				}
			}
		}
	}
	
	static boolean isInside(int nr, int nc) {
		return nr >=0 && nr < N && nc >= 0 && nc < M;
	}
}
