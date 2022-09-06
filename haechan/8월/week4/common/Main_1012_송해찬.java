import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_1012_송해찬 {

	static int M, N, K;
	static int[][] grid;
	static int[][] deltas = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringBuilder sb = new StringBuilder();
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			grid = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<K; i++) { 
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				grid[Y][X] = 1;
			}
//			System.out.println(Arrays.deepToString(grid));
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(grid[i][j] == 1 && !visited[i][j]) {
						visited[i][j] = true;
						dfs(i, j);
						ans++;
					}
				}
			}
			
			sb.append(ans);
			System.out.println(sb);
		}
	}
	
	static void dfs(int r, int c) {
		for(int d=0; d<deltas.length; d++) {
			int nr = r+deltas[d][0];
			int nc = c+deltas[d][1];
			if(!isInside(nr, nc) || grid[nr][nc] == 0 || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}
	
	static boolean isInside(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
