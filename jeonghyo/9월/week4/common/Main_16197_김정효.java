import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * BOJ 16197 두 동전
 * (조건)
 * 1. 두 동전은 같은 방향으로 동시에 이동
 * 2. 벽으로는 이동X
 * 
 * (출력)
 * 동전 하나만 떨어뜨리기 위한 최소 횟수   /  떨어뜨릴 수 없거나, 버튼을 10번보다 많이 눌러야 한다면, -1
 * 
 * (실수)
 * 함수의 for문 안에서 c1, c2의 조건들을 다 봐주려고 했는데 생각대로 안돼서
 * return 되는 조건(동전이 밖으로 떨어지는 경우) // bfs를 불러오는 조건으로 따로 분류해서 해줬음 (두 동전 모두 맵 안에서 계속 이동하는 경우)
 * @author kjh
 *
 */
public class Main_16197_김정효 {
	static char[][] arr;
	static int n, m, _min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new char[n][m];
		_min = Integer.MAX_VALUE;
		
		int c1_x, c1_y, c2_x, c2_y;
		c1_x = c1_y = c2_x = c2_y = -1;
		
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
				
				if (arr[i][j] == 'o') {
					if (c1_x == -1) {	// 동전1 위치
						c1_x = i;
						c1_y = j;
					}else {				// 동전2 위치
						c2_x = i;
						c2_y = j;
					}
				}
			}
		}
		dfs(c1_x, c1_y, c2_x, c2_y, 0);
		System.out.println(_min == Integer.MAX_VALUE? -1: _min);
	}

	private static void dfs(int c1_x, int c1_y, int c2_x, int c2_y, int cnt) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		// 10번 넘어갈 때,
		if (cnt > 10) {
			return;
		}
		// c1, c2: 밖
		if ( (c1_x<0 || c1_y<0 || c1_x>=n || c1_y>=m)
			&& (c2_x<0 || c2_y<0 || c2_x>=n || c2_y>=m) ) {	
			return;
		}
		// c1: 밖, c2: 안        or    c1: 안, c2: 밖
		if ( (c1_x<0 || c1_y<0 || c1_x>=n || c1_y>=m)
			|| (c2_x<0 || c2_y<0 || c2_x>=n || c2_y>=m) ) {	
			_min = Math.min(_min, cnt);
			return;
		}
		for (int k = 0; k < 4; k++) {
			int nx1 = c1_x + dx[k];
			int ny1 = c1_y + dy[k];
			int nx2 = c2_x + dx[k];
			int ny2 = c2_y + dy[k];
			// c1: 안, c2: 안
			if ((nx2>=0 && ny2>=0 && nx2<n && ny2<m)
					&& arr[nx2][ny2] == '#') {	// c2: 벽 만나면
				nx2 = c2_x;
				ny2 = c2_y;
			}
			if ((nx1>=0 && ny1>=0 && nx1<n && ny1<m)
					&& arr[nx1][ny1] == '#') {	// c1: 벽 만나면
				nx1 = c1_x;
				ny1 = c1_y;
			}
			dfs(nx1, ny1, nx2, ny2, cnt+1);
		}
	}

}
