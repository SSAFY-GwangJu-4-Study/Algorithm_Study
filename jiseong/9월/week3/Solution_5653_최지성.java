import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5653_최지성 {
	static class Point  {
		int y;
		int x;
		int life; // 생명력
		int actTime; // 활성화 시간
		int deathTime; // 죽는 시간

		public Point(int y, int x, int life, int actTime, int deathTime) {
			this.y = y;
			this.x = x;
			this.life = life;
			this.actTime = actTime;
			this.deathTime = deathTime;
		}
	}

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M, K;
	static int[][] map;
	static int[][] tempMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[300 + N][300 + M];
			tempMap = new int[300 + N][300 + M];

			Queue<Point> activate = new ArrayDeque<>();
			Queue<Point> disable = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				for (int j = 0; j < M; j++) {
					map[150 + i][150 + j] = Integer.parseInt(st.nextToken());

					if (map[150 + i][150 + j] > 0) {
						disable.offer(new Point(150 + i, 150 + j, map[150 + i][150 + j], map[150 + i][150 + j],
								map[150 + i][150 + j] * 2));
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tempMap[150 + i][150 + j] = map[150 + i][150 + j];
				}
			}

			Point p = null;
			for (int t = 1; t <= K; t++) {
//				System.out.println(t);
				// 활성화 퍼뜨리기
				for (int itr = 0, size = activate.size(); itr < size; itr++) {
					p = activate.poll();
					
					for (int d = 0; d < 4; d++) {
						int nr = p.y + delta[d][0];
						int nc = p.x + delta[d][1];
						if (nr >= 0 && nr < 300 + N && nc >= 0 && nc < 300 + M && map[nr][nc] == 0
								&& tempMap[nr][nc] < p.life) {
							tempMap[nr][nc] = 1000 + p.life;
						}
					}

					if (p.deathTime > t)
						activate.offer(p);

				}
				
				for (int i = 0; i < 300 + N; i++) {
					for (int j = 0; j < 300 + M; j++) {
						if (tempMap[i][j] > 1000) {
//							System.out.println(tempMap[i][j]);
							disable.offer(new Point(i, j, tempMap[i][j] - 1000, t + tempMap[i][j] - 1000,
									t + (tempMap[i][j] - 1000) * 2));
							
							tempMap[i][j]-=1000;
						}
					}
				}

				for (int i = 0; i < 300 + N; i++) {
					for (int j = 0; j < 300 + M; j++) {
						map[i][j] = tempMap[i][j];
					}
				}

				// 비활성화 => 활성화
				for (int itr = 0, size = disable.size(); itr < size; itr++) {
					p = disable.poll();

					if (p.actTime > t) { // 아직 활성화 안됨
						disable.offer(p);
					} else {
						activate.offer(p);
					}
				}

//				System.out.println(activate.size() + " " + disable.size());
			}

			System.out.println("#" + tc + " " + (activate.size() + disable.size()));
		}
	}
}
