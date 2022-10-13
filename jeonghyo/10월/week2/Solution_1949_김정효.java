import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * SWEA 1949 등산로 조성 (DFS)
 * BFS로 풀려고 했는데 경로마다 공사 진행 여부 체크하는게 어려워서 DFS로 바꿈
 * DFS는 파라미터로 공사 여부 체크함
 * @author kjh
 *
 */
public class Solution_1949_김정효 {
	static int N, K, ml, map[][];
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());	// 깍을 수 있는 깊이
			map = new int[N][N];
			visit = new boolean[N][N];
			ml = 0;
			int _max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					 map[i][j] = Integer.parseInt(st.nextToken());
					 // 가장 높은 위치 찾기
					_max = Math.max(_max, map[i][j]);
				}
			}
			// 가장 높은 위치에서 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 가장 높은 위치 좌표 찾기
					if (map[i][j] == _max){
						visit[i][j] = true;
						dfs(i, j, 1, false);
						visit[i][j] = false;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(ml).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	private static void dfs(int x, int y, int cnt, boolean flag) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		// 경로 길이 갱신
		ml = Math.max(ml, cnt);
		
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny]) {
				// 크거나 같을 때
				if (map[nx][ny] >= map[x][y]) {
					// flag=false이면
					if (flag == false && map[nx][ny] - K < map[x][y]) {
						visit[nx][ny] = true;
						int temp = map[nx][ny];	// 실수 주의
						map[nx][ny] = map[x][y] -1;
						dfs(nx, ny, cnt+1, !flag);
						visit[nx][ny] = false;
						map[nx][ny] = temp;	// 원래 값으로 돌려주기 위해서 temp 변수 사용
					} else continue;
				} else {
					visit[nx][ny] = true;
					dfs(nx, ny, cnt+1, flag);
					visit[nx][ny] = false;
				}
			}
		}
	}
}
