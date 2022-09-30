import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610_최지성 {
	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int[][] delta = { { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };
	static int N, M;
	static boolean[][] lastCloud;
	static int[][] tempMap;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		tempMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				tempMap[i][j] = map[i][j];
			}
		}
		
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(N - 1, 0));
		q.add(new Point(N - 1, 1));
		q.add(new Point(N - 2, 0));
		q.add(new Point(N - 2, 1));

		int cnt = 1;
		for (int i = 0; i < M; i++) {
			lastCloud = new boolean[N][N];

			st = new StringTokenizer(br.readLine(), " ");

			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken()) % N;

			for (int j = 0, size = q.size(); j < size; j++) {
				Point p = q.poll();

				int y = (p.y + delta[d][0] * s + N) % N;
				int x = (p.x + delta[d][1] * s + N) % N;
				
				lastCloud[y][x] = true;

				map[y][x]++;
				tempMap[y][x]++;
			}
			
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (lastCloud[j][k]) {
						for (int l = 1; l < 8; l += 2) {
							int nr = j + delta[l][0];
							int nc = k + delta[l][1];
							if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] >= 1) {
								tempMap[j][k] += 1;
							}
						}
					}
				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					map[j][k] = tempMap[j][k];
				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if (!lastCloud[j][k] && map[j][k] >= 2) {
						map[j][k] -= 2;
						tempMap[j][k] -= 2;
						q.offer(new Point(j, k));
					}
				}
			}
			
		}
		
		int water = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				water += map[i][j];
			}
		}
		
		System.out.println(water);
	}
}
