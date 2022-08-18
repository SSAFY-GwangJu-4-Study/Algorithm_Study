import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1303_송해찬 {

	static int n, m, wPower, bPower, cnt;
	static char[][] grid;
	static boolean[][] isVisited;
	static int[][] deltas = {{0,1}, {1,0}, {-1,0}, {0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		grid = new char[m][n];
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				grid[i][j] = str.charAt(j);
			}
		}
//		System.out.println(Arrays.deepToString(grid));
		
		isVisited = new boolean[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				// 방문된 적이 없다면 dfs 탐색해서 cnt 얻기
				if(!isVisited[i][j]) {
					cnt = 1;
					dfs(grid[i][j], i, j);
					// 얻은 cnt로 군사력 더해주기
					if(grid[i][j] == 'W') wPower += cnt*cnt;
					else if(grid[i][j] == 'B') bPower += cnt*cnt;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(wPower).append(" ").append(bPower);
		System.out.println(sb);
	}
	
	static void dfs(char color, int r, int c) {
		// 방문처리
		isVisited[r][c] = true;
		
		// 사방으로 dfs 탐색
		for(int d=0; d<deltas.length; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			// 배열 범위 벗어나면 다른 곳 탐색
			if(!(nr>=0 && nr<m && nc>=0 && nc<n)) {
				continue;
			}
			// 이미 방문한 곳이면 다른 곳 탐색
			if(isVisited[nr][nc]) {
				continue;
			}
			// 다른 팀이면 다른 곳 탐색
			if(grid[nr][nc] != color) {
				continue;
			}
			
			cnt++;
			dfs(color, nr, nc); //grid[nr][nc] 같음
		}
	}
}
