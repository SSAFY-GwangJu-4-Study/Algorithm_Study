import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_14500_송해찬 {

	static int N, M, ans;
	static int[][] grid;
	static int[][] deltas = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, grid[i][j]);
				visited[i][j] = false;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				tetromino(i, j, grid[i][j]);
			}
		}
		
		
		
		sb.append(ans);
		System.out.println(sb);
	}
	
	static void dfs(int r, int c, int cnt, int sum) {
		if(cnt == 4) {
			ans = Math.max(ans, sum);
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(visited[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println("합 : " + sum);
			return;
		}
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			// 범위밖이거나 방문된적 있으면 넘어감
			if(!isInside(nr, nc) || visited[nr][nc]) continue;
			// 사방탐색하면서 값 더해넣기
			sum += grid[nr][nc];
			visited[nr][nc] = true;
			dfs(nr, nc, cnt+1, sum);
			sum -= grid[nr][nc];
			visited[nr][nc] = false;
		}
	}
	
	static void tetromino (int r, int c, int sum) {
		
		for(int i=0; i<4; i++) {
			sum = grid[r][c];
			for(int d=0; d<deltas.length-1; d++) {
				int nr = r + deltas[(d+i)%4][0];
				int nc = c + deltas[(d+i)%4][1];
				if(!isInside(nr, nc)) continue;
				sum += grid[nr][nc];
			}
			ans = Math.max(ans, sum);
		}
	}
	
	static boolean isInside(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
