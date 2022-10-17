import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_3_김정효 {
	static int N, M, R, C, L, cnt, map[][];
	static boolean visit[][];
	static int[] dx = {-1, 0, 0, 1};	// 상우좌하
	static int[] dy = {0, 1, -1, 0};
	static int[][] pipe = {
							{},
							{0, 1, 2, 3},
							{0, 3},
							{1, 2},
							{0, 1},
							{1, 3},
							{2, 3},
							{0, 2}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];
			cnt = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			search();
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void search() {
		Queue<int[]> q = new LinkedList<int[]>();
		visit[R][C] = true;
		q.offer(new int[] {R, C});
		cnt++;
		
		while(--L > 0) {
			int size = q.size();
			while(size-- > 0) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				for (int i = 0; i < pipe[map[x][y]].length; i++) {
					int k = pipe[map[x][y]][i];
					int nx = x + dx[k];
					int ny = y + dy[k];
					if (nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny]) {
						// 파이프 연결 확인
						for (int j = 0; j < pipe[map[nx][ny]].length; j++) {
							if (pipe[map[nx][ny]][j] == 3-k) {
								visit[nx][ny] = true;
								q.offer(new int[] {nx, ny});
								cnt++;
								break;
							}
						}
					}
				}
			}
		}
			
		
	}
		
}
