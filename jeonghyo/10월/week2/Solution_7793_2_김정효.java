import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7793_2_김정효 {
	static int N, M, cnt;
	static char map[][];
	static Queue<int[]> q1;
	static Queue<int[]> q2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			cnt = 0;
			q1 = new LinkedList<int[]>();
			q2 = new LinkedList<int[]>();
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					// 수연이라면 큐1에 넣기
					if (map[i][j] == 'S') {
						q1.offer(new int[] {i, j});
					}
					// 악마라면 큐2에 넣기
					if (map[i][j] == '*') {
						q2.offer(new int[] {i, j});
					}
				}
			}
			
			bfs();
			sb.append("#").append(tc).append(" ").append(cnt==0? "GAME OVER" : cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		boolean[][] visit = new boolean[N][M];
		while(true) {
			// 악마 확장
			int size = q2.size();
			while(size-- > 0) {
				int[] cur = q2.poll();
				int x = cur[0];
				int y = cur[1];
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx>=0 && ny>=0 && nx<N && ny<M) {
						if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
							map[nx][ny] = '*';
							q2.offer(new int[] {nx, ny});
						}
					}
				}
			}
			// 수연 확장
			size = q1.size();
			while(size-- > 0) {
				int[] cur = q1.poll();
				int x = cur[0];
				int y = cur[1];
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny]) {
						if (map[nx][ny] == '.') {
							visit[nx][ny] = true;
							q1.offer(new int[] {nx, ny});
						} else if (map[nx][ny] == 'D') {
							cnt++;
							return;
						}
					}
				}
				cnt++;
			}
			if (q1.size() == 0) {
				cnt = 0;
				return;
			}
		}
	}

}
