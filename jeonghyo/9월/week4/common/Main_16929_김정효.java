import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 16929 Two dots - DFS 사용
 * (실수)
 * - dfs를 돌고 돌아 왔을 때, 당연히 true 일 줄 알고 설정 안해줬는데 false로 돌아오는 경우도 있었다..
 * @author kjh
 *
 */
public class Main_16929_김정효 {
	static char[][] arr;
	static int n, m, f_x, f_y;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		
		for (int i = 0; i < n; i++) {
			String c = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = c.charAt(j);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit = new boolean[n][m];
				f_x = i;
				f_y = j;
				visit[i][j] = true;
				if (dfs(i, j, 1)) {
					System.out.println("Yes");
					return;
				}
			}
		}
		System.out.println("No");
	}

	private static boolean dfs(int x, int y, int cnt) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx>=0 && ny>=0 && nx<n && ny<m) {
				if (arr[nx][ny] == arr[x][y]) {
					if(!visit[nx][ny]) {
						visit[nx][ny] = true;
						if (dfs(nx, ny, cnt+1))	return true;
					}
					else {
						if(cnt >= 4 && f_x == nx && f_y == ny) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
