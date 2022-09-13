import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution_1949_송해찬 {

	static int N, K, maxHeight, maxDist;
	static int[][] grid;
	static boolean[][] visited;
	static int[][] deltas = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 초기화, 시작높이 찾기
			grid = new int[N][N];
			visited = new boolean[N][N];
			maxHeight = maxDist = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, grid[i][j]);
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(grid[i][j] != maxHeight) {
						// 파고
						grid[i][j] -= K;
						// 찾았다가
						find();
						// 메꾸기
						grid[i][j] += K;
					}
				}
			}
			
			System.out.printf("#%d %d%n", tc, maxDist);
		}
	}
	
	static void find() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(grid[i][j] == maxHeight) {
					// 시작점 포함
					dfs(1, i, j);
				}
			}
		}
	}
	
	static void dfs(int cnt, int r, int c) {
		maxDist = Math.max(maxDist, cnt);
		
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			// 범위밖이거나 높이가 같거나 크면 넘어감
			if(!isInside(nr, nc) || grid[nr][nc] >= grid[r][c]) continue;
			visited[nr][nc] = true;
			dfs(cnt+1, nr, nc);
			visited[nr][nc] = false;
		}
	}
	
	static boolean isInside(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
