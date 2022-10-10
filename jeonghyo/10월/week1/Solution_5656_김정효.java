import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * SWEA 5656 벽돌 깨기 - 구현 (시간 엄청엄청 오래 걸림)
 * 구현이 복잡해지면서 스스로 길을 잃었다..
 * 인덱스 실수 조심!!
 * 1. n개의 구슬을 떨어뜨릴 위치 구하기 : 중복순열 (perm)
 * 2. 구슬 떨어질 때, 처음 명중하는 벽 찾기 (search)
 * 3. 벽돌 깨기 -> 구슬 1개에 대해 다 처리되면 벽돌 중력 처리하기  (bfs)
 * 4. 순열 하나에 대해 다 돌고나면, 돌아와서 최솟값 구하기 (count)
 * 5. 다음 순열에 대해 처리하기 위해 map 배열을 원래대로 되돌리기 (copy)
 * @author kjh
 *
 */
public class Solution_5656_김정효 {
	static int n, w, h, _min, map[][], copyMap[][], list[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			copyMap = new int[h][w];
			list = new int[n];
			_min = Integer.MAX_VALUE;
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					copyMap[i][j] = map[i][j];
				}
			}
			// 구슬을 떨어뜨릴 n개의 w좌표 구하기 -> bfs 호출
			perm(0);
			sb.append("#").append(tc).append(" ").append(_min).append("\n");
		}
		System.out.print(sb);
	}

	private static void perm(int cnt) {
		if (cnt == n) {
			// 구한 w좌표에 구슬 떨어뜨리기
			search();
			// 돌아와서 최솟값 갱신해주기
			_min = Math.min(_min, count());
			// 배열 원래대로 되돌려 놓기
			copy();
			return;
		}
		
		// 중복 순열 (방문체크 X)
		for (int i = 0; i < w; i++) {
			list[cnt] = i;
			perm(cnt+1);
		}
	}
	
	private static void search() {
		int x = h-1;	// 해당 열에 벽돌이 없다면
		for (int i : list) {	// 구슬을 떨어뜨렸을 때,
			for (int j = 0; j < h; j++) {
				if (map[j][i] > 0) {	// 명중할 벽돌 찾기
					x = j;
					break;
				}
			}
			// 벽돌 명중하기
			bfs(x, i);
		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		int[] dx = {-1, 0, 1, 0};		// 상, 우, 하, 좌
		int[] dy = {0, 1, 0, -1};
		q.add(new int[] {x, y, map[x][y]});
		map[x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int power = cur[2];
			// '벽돌에 쓰여진 수 - 1' 만큼 벽돌 꺠뜨림  => (power-1) 만큼 반복
			for (int p = 1; p < power; p++) {
				for (int k = 0; k < 4; k++) {
					int nx = cur[0] + dx[k] * p;
					int ny = cur[1] + dy[k] * p;
					// 벽돌은 저장해뒀다가 터트림.
					if (nx>=0 && ny>=0 && nx<h && ny<w) {	// 범위 내에 있고,
						if (map[nx][ny] != 0) {	// 벽돌이 존재한다면,
							q.add(new int[] {nx, ny, map[nx][ny]});	// 벽돌을 q에 저장
							map[nx][ny] = 0;	// 깨진 벽돌 처리
							continue;
						}
					}
				}
			}
		}

		// 벽돌 하나에 대한 작업이 다 끝나면, 위의 벽돌을 아래로 옮김
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (map[j][i] > 0) {
					stack.add(map[j][i]);
				}
			}
			for (int j = h-1; j >= 0; j--) {
				if (stack.isEmpty()) {
					map[j][i] = 0;
				} else {
					map[j][i] = stack.pop();
				}
			}
		}
	}
	
	private static void copy() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	private static int count() {
		int _cnt = 0;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] != 0) _cnt++;
			}
		}
		return _cnt;
	}
}
