import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * SWEA 1953 탈주범 검거 - (bfs, 큐 이용)
 * 1. 탐색지점이 범위 내에 있는지
 * 2. 미방문인지
 * 3. 연결되어 있는지
 * 상, 좌, 우, 하 (3의 보수)
 * 현재 큐에 비어있는 것을 소진하고, 다음 턴에서 방금 소진했떤 것에서 생긴 것을 소진
 * @author kjh
 *
 */
public class Solution_1953_김정효 {
	static int n, m, l, r, c, cnt, map[][];
	static int[] dx = {-1, 0, 0, 1};		// 상, 좌, 우, 하
	static int[] dy = {0, -1, 1, 0};
	static int[][] types = {		// 각 7종류가 갈 수 있는 방향
			{},
			{0, 1, 2, 3},
			{0, 3},
			{1, 2},
			{0, 2},
			{2, 3},
			{1, 3},
			{0, 1}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visit = new boolean[n][m];
		cnt = 0;
		
		queue.add(new int[] {r, c});
		visit[r][c] = true;
		cnt++;	// 맨홀 뚜껑도 방문 장소에 포함
		
		while (--l > 0) {	// 맨홀 뚜겅 방문도 1시간에 포함
			int size = queue.size();
			while (size-- > 0) {
				int x = queue.peek()[0];
				int y = queue.peek()[1];
				queue.poll();
				for (int i : types[map[x][y]]) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					if (nx>=0 && ny>=0 && nx<n && ny<m && !visit[nx][ny] && connection(3-i, types[map[nx][ny]])) {
						visit[nx][ny] = true;
						queue.add(new int[] {nx, ny});
						cnt++;
					}
				}
			}
		}
	}
	
	// 통로가 연결되어 있는지 확인
	private static boolean connection(int d, int[] t_arr) {
		for (int j : t_arr) {
			if (j == d) return true;
		}
		return false;
	}
}
