import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_최지성 {
	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "[y=" + y + ", x=" + x + "]";
		}
	}

	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M;
	static int[][] map;
	static ArrayList<Point> virus;
	static Queue<Point> q;
	static int minTime;
	static int rest;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		virus = new ArrayList<>();
		q = new ArrayDeque<>();
		minTime = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line, " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					virus.add(new Point(i, j));
				}
			}
		}
		
		rest = findBlank(map);

		comb(0, 0, 0);
		if(minTime == Integer.MAX_VALUE)
			minTime = -1;
		
		System.out.println(minTime);
	}

	public static void comb(int num, int cnt, int flag) {
		if (cnt > M)
			return;

		if (num == virus.size()) {
			if (cnt == M) {
				ArrayList<Point> chosen = new ArrayList<>();
				for (int i = 0; i < virus.size(); i++) {
					if ((flag & 1 << i) != 0)
						chosen.add(virus.get(i));
				}
				minTime = Math.min(minTime, bfs(chosen));
			}
			return;
		}

		comb(num + 1, cnt, flag);
		comb(num + 1, cnt + 1, flag | 1 << num);
	}

	public static int bfs(ArrayList<Point> chosen) {
//		System.out.println("야옹");
		int[][] tempMap = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		for (Point p : chosen) {
			tempMap[p.y][p.x] = 3;
			visited[p.y][p.x] = true;
			q.offer(p);
		}
		
		int nowRest = rest;
		int time = 0;

		while (!q.isEmpty() && nowRest > 0) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				Point now = q.poll();

				for (int j = 0; j < 4; j++) {
					int nr = now.y + delta[j][0];
					int nc = now.x + delta[j][1];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && tempMap[nr][nc] != 1) {
						if(tempMap[nr][nc] == 0)
							nowRest--;
						visited[nr][nc] = true;
						tempMap[nr][nc] = 3;
						q.offer(new Point(nr, nc));
					}
				}
			}
			
//			System.out.println(q.toString());
//
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(tempMap[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(nowRest);

			time++;
		}
		q.clear();
		if(nowRest > 0)
			time = Integer.MAX_VALUE;
		return time;
	}

	public static int findBlank(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}

		return count;
	}
}
