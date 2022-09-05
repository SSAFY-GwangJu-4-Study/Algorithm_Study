import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_최지성 {
	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "[y=" + y + ", x=" + x + "]";
		}
	}

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N;
	static int L;
	static int R;
	static int[][] map;
	static int[][] tempMap;
	static int day; // 날짜

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		tempMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 날짜가 바뀌기 전에 인구 이동을 하면 그 이동한 결과가 그 날짜에 다시 반영될 수 있음
		// 임시 맵을 만들어서 반영한 결과를 저장하고 날짜가 지나면 한 번에 적용하기 위해 tempMap을 생성
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tempMap[i][j] = map[i][j];
			}
		}

		boolean[][] visited;
		boolean changed = true;

		// 변화가 없으면 인구 이동을 멈춘다.
		while (changed) {
			changed = false;
			// 매일 새로 체크해야하므로 visited를 while문 안에 생성
			visited = new boolean[N][N];

			// 모든 국가에 대해서
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 방문한 적이 없고 합칠 수 있으면
					if (!visited[i][j] && canCombine(i,j)) {
						union(i, j, visited);
						// 인구 이동을 했으니 changed는 true
						changed = true;
					}
				}
			}

			// 이동이 끝났으면 이동이 끝난 결과(tempMap)을 map에 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = tempMap[i][j];
				}
			}

			// 변경이 되었으므로 날짜 추가
			if (changed)
				day++;
		}

		System.out.println(day);
	}

	public static void union(int r, int c, boolean[][] visited) {
		Queue<Point> q = new ArrayDeque<>();
		visited[r][c] = true;	// 현재 위치도 소속되므로 방문했다고 하고
		q.offer(new Point(r, c));	// 큐에 넣음
		ArrayList<Point> temp = new ArrayList<>();

		// BFS
		while (!q.isEmpty()) {
			Point now = q.poll();
			int y = now.y;
			int x = now.x;

			temp.add(now);

			for (int i = 0; i < 4; i++) {
				int ny = y + delta[i][0];
				int nx = x + delta[i][1];

				if (ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx]
						&& ((Math.abs(map[y][x] - map[ny][nx]) >= L) && (Math.abs(map[y][x] - map[ny][nx]) <= R))) {
					visited[ny][nx] = true;
					q.offer(new Point(ny, nx));
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < temp.size(); i++) {
			sum += map[temp.get(i).y][temp.get(i).x];
		}
		
		// 임시맵에 이동한 결과 업데이트
		for (int i = 0; i < temp.size(); i++) {
			tempMap[temp.get(i).y][temp.get(i).x] = sum / temp.size();
		}
	}

	public static boolean canCombine(int r, int c) {
		return canCombineUp(r, c) || canCombineRight(r, c) || canCombineDown(r, c) || canCombineLeft(r, c);
	}

	// 각각의 메소드는 그 방향으로 이동할 수 있는지 체크하는 메소드
	// 이동할 수 있는지 && 그 방향에 있는 국가의 인구수와 현재 국가의 인구수의 차이가 L보다 크고 R보다 작은지
	public static boolean canCombineUp(int r, int c) {
		return ((r > 0) && Math.abs(map[r][c] - map[r - 1][c]) >= L && Math.abs(map[r][c] - map[r - 1][c]) <= R);
	}

	public static boolean canCombineRight(int r, int c) {
		return ((c < N - 1) && Math.abs(map[r][c] - map[r][c + 1]) >= L && Math.abs(map[r][c] - map[r][c + 1]) <= R);
	}

	public static boolean canCombineDown(int r, int c) {
		return ((r < N - 1) && Math.abs(map[r][c] - map[r + 1][c]) >= L && Math.abs(map[r][c] - map[r + 1][c]) <= R);
	}

	public static boolean canCombineLeft(int r, int c) {
		return ((c > 0) && Math.abs(map[r][c] - map[r][c - 1]) >= L && Math.abs(map[r][c] - map[r][c - 1]) <= R);
	}
}
