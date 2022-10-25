import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_최지성 {
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int maxSafe;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int h = 0; h <= 100; h++) {
			visited = new boolean[N][N];
			int temp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						dfs(i, j, h);

						temp++;
					}
				}
			}
			
			maxSafe = Math.max(maxSafe, temp);
		}

		System.out.println(maxSafe);
	}

	public static void dfs(int y, int x, int height) {
		
		visited[y][x] = true;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + delta[d][0];
			int nx = x + delta[d][1];
			
			if(ny >= 0 && ny < N && nx >= 0 && nx < N && !visited[ny][nx] && map[ny][nx] > height) {
				dfs(ny, nx , height);
			}
		}
	}
}
