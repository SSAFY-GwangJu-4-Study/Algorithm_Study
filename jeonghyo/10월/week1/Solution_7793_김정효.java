import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * SWEA 7793 오! 나의 여신님 (BFS)
 * (실수)
 * - 악마 이동할 때, 조건이 ., S인데 ., *로 해서 안됐었음
 *      => 조건이 *가 안되는 이유는 *로 되어 있는 것은 이미 큐에 들어가 있어서 지금 탐색해야 할 목록 중 하나이기 때문
 * @author kjh
 *
 */
public class Solution_7793_김정효 {
	static int N, M, cnt;
	static char map[][];
	static boolean[][] visit;
	static Queue<int[]> q, devil;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visit = new boolean[N][M];
			q = new LinkedList<>();
			devil = new LinkedList<>();
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'S') {
						q.offer(new int[] {i, j});
					}
					else if (map[i][j] == '*') {
						devil.offer(new int[] {i, j});
					}
				}
			}
			bfs();
			sb.append("#").append(tc).append(" ").append(cnt==-1?"GAME OVER" : cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		while (true) {
			// 악마 이동
			int size = devil.size();
			while (size-- > 0) {
				int[] cur2 = devil.poll();
				int r = cur2[0];
				int c = cur2[1];
				for (int k = 0; k < 4; k++) {
					int nx = r+dx[k];
					int ny = c+dy[k];
					if (nx>=0 && ny>=0 && nx<N && ny<M) {
						if (map[nx][ny]=='.' || map[nx][ny] == 'S') {
							map[nx][ny] = '*';
							devil.offer(new int[] {nx, ny});
						}
					}
				}
			}
			// 수연 이동
			size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				for (int k = 0; k < 4; k++) {
					int nx = x+dx[k];
					int ny = y+dy[k];
					if (nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny]) {
						if (map[nx][ny]=='.') {
							visit[nx][ny] = true;
							q.offer(new int[] {nx, ny});
							continue;
						} else if (map[nx][ny]=='D') {
							cnt++;
							return;
						}
					}
				}
			}
			if (q.size() == 0) {
				cnt = -1;
				return;
			}
			cnt++;
		}
	}

}
