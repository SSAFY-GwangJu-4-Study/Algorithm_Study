

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468 {
	static int[][] map;
	static int N;
	static boolean[][] temp;
	static boolean[][] visited;
	static int safe;
	static int max;
	static int maxHeight;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		max = 1;
		maxHeight = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(map[i][j], maxHeight);
			}
		}
		



		for (int h = 0; h <= maxHeight; h++) {
			safe = 0;
			// 안전지대 지도 그리기
			temp = new boolean[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] <= h) {
						temp[i][j] = false;
					} else if (map[i][j] > h) {
						temp[i][j] = true;
					}
				}
			}

//						안전지대 출력 해보기
//			System.out.println("높이=" + h);
//			print();
//			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] && !visited[i][j]) {
						safe++;
						visited[i][j] = true;
						dfs(i, j);
					}
				}
			}
//			System.out.println(safe);
			max = Math.max(safe, max);
		}
		System.out.println(max);
	}

	private static void dfs(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + delta[d][0];
			int ny = y + delta[d][1];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && temp[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}

	static void print() {
		// for (int i = 0; i < N; i++) {
		// for (int j = 0; j < N; j++) {
		// System.out.print(map[i][j] + " ");
		// }
		// System.out.println();
		// }
		//
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] == true)
					System.out.print(1 + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
