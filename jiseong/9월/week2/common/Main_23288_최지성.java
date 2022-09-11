import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23288_최지성 {
	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M, K;
	static int r, c, d; // d는 방향, 0 : 북, 1 : 동, 2 : 남, 3 : 서
	static int[] dice;
	static int[][] map;
	static int totalPoint;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		r = 0;
		c = 0;
		d = 1; // 처음 방향은 동쪽

		dice = new int[] { 1, 6, 5, 2, 4, 3 }; // 순서는 위, 아래, 앞, 뒤, 왼쪽, 오른쪽
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			moveDice();
			int point = bfs();
			totalPoint += point;
		}

		System.out.println(totalPoint);
	}

	public static void moveDice() {
		int[] tempDice = Arrays.copyOf(dice, dice.length);

		switch (d) {
		case 0:
			if (r == 0) {
				d = (d + 2) % 4;
				moveDice();
				return;
			}

			r--;

			dice[0] = tempDice[2]; // 위 <= 앞
			dice[2] = tempDice[1]; // 앞 <= 아래
			dice[1] = tempDice[3]; // 아래 <= 뒤
			dice[3] = tempDice[0]; // 뒤 <= 위

			break;
		case 1:
			if (c == M - 1) {
				d = (d + 2) % 4;
				moveDice();
				return;
			}
			c++;

			dice[0] = tempDice[4]; // 위 <= 왼쪽
			dice[4] = tempDice[1]; // 왼쪽 <= 아래
			dice[1] = tempDice[5]; // 아래 <= 오른쪽
			dice[5] = tempDice[0]; // 오른쪽 <= 위

			break;
		case 2:
			if (r == N - 1) {
				d = (d + 2) % 4;
				moveDice();
				return;
			}
			r++;

			dice[0] = tempDice[3]; // 위 <= 뒤
			dice[3] = tempDice[1]; // 뒤 <= 아래
			dice[1] = tempDice[2]; // 아래 <= 뒤
			dice[2] = tempDice[0]; // 앞 <= 위

			break;
		case 3:
			if (c == 0) {
				d = (d + 2) % 4;
				moveDice();
				return;
			}
			c--;

			dice[0] = tempDice[5]; // 위 <= 오른쪽
			dice[5] = tempDice[1]; // 오른쪽 <= 아래
			dice[1] = tempDice[4]; // 아래 <= 왼쪽
			dice[4] = tempDice[0]; // 왼쪽 <= 위

			break;
		}

		if (dice[1] > map[r][c]) {
			d = (d + 1 + 4) % 4;
		} else if (dice[1] < map[r][c]) {
			d = (d - 1 + 4) % 4;
		}
	}

	public static int bfs() {
		int point = 0;

		Queue<Point> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		visited[r][c] = true;
		q.offer(new Point(r, c));

		while (!q.isEmpty()) {
			Point now = q.poll();
			point += map[now.y][now.x];

			for (int i = 0; i < 4; i++) {
				int nr = now.y + delta[i][0];
				int nc = now.x + delta[i][1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[now.y][now.x] == map[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new Point(nr, nc));
				}
			}
		}

		return point;
	}
}
