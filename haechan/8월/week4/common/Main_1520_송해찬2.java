import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_1520_송해찬2 {

	static int M, N, ans;
	static int[][] grid;
	static boolean[][] visited;
	static int[][] deltas = {{0,1}, {0,-1}, {1,0}, {-1,0}};
	// 시간초과 나지 않게  2차원 배열 dp에 길찾기 경우의수를 저장
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		grid = new int[M][N];
		// 길찾는 경우의 수를 저장한 배열 추가
		dp = new int[M][N];
//		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				// 갈수없는곳 0과 구분하기 위해 방문안한곳을 -1로 선언 (시간 최적화)
				dp[i][j] = -1;
			}
		}
		ans = dfs(0,0);

		sb.append(ans);
		System.out.println(sb);
	}
	
	static int dfs(int r, int c) {
		// 끝에 도달하면 
		if(r == M-1 && c == N-1) {
			return 1;
		}
		// 방문했던 곳이면
		if(dp[r][c] != -1) {
			// 그 위치에 있는 길찾기 경우의 수 가져오기(더하기 위해)
			return dp[r][c];
		}
		// 처음 간 곳이면
		else {
			// 현재 위치에서 끝점까지 갈 수 있는 경우의 수 초기화
			dp[r][c] = 0;
			
			// 주변에 길찾기 경우의수 가져오기
			for(int d=0; d<deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				// 범위 밖이거나 갈 곳이 현 위치 이상이면 안봄
				if(!isInside(nr, nc) || grid[nr][nc] >= grid[r][c]) continue;
				dp[r][c] += dfs(nr, nc);
			}
			return dp[r][c];
		}
	}
	
	static boolean isInside(int nr, int nc) {
		return nr >= 0 && nr < M && nc >= 0 && nc < N;
	}
}
