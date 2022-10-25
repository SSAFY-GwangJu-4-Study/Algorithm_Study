import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * BOJ 2468 안전 영역 (BFS)
 * 1. 물높이가 최소 높이부터 최대 높이까지 BFS로 탐색
 * 2. 방문체크는 map의 값을 0으로 바꾸는 것으로 함
 * 3. 해당 물높이에 대해 map을 다 탐색하고 나면 원래 맵으로 돌려놓기
 * 4. 물높이가 바뀔 때마다 영역 개수를 구해서 최대 영역 개수 값으로 업데이트 해주기
 * @author kjh
 *
 */
public class Main_2468_김정효 {
	static int n, cnt, copy[][], map[][], _min, _max, result;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		copy = new int[n][n];
		_min = Integer.MAX_VALUE;
		_max = Integer.MIN_VALUE;
		result = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				copy[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
				_min = Math.min(map[i][j], _min);
				_max = Math.max(map[i][j], _max);
			}
		}
		// 최소 높이부터 탐색 시작
		go(_min);
		// 물높이가 모두 같을 때는 1 출력, 아니라면 최대영역 개수 출력
		System.out.println(result==0? 1:result);
	}
	
	private static void go(int k) {
		cnt = 0;	// 영역 개수
		
		if (k == _max+1) {
			return;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] <= k) {
					map[i][j] = 0;
				}
			}
		}
		// 영역 개수 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					map[i][j] = 0;
					check(i, j);
					cnt += 1;
				}
			}
		}
		// 최대 영역 개수로 업데이트
		result = Math.max(cnt, result);
		// 맵 되돌리기
		copy();
		// 다음 물높이로 확인
		go(k+1);
	}

	private static void check(int i, int j) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i, j});

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for (int d = 0; d < 4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if (nx>=0 && ny>=0 && nx<n && ny<n && map[nx][ny] != 0) {
					q.offer(new int[] {nx, ny});
					map[nx][ny] = 0;
				}
			}
		}
	}

	private static void copy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}
		
}
