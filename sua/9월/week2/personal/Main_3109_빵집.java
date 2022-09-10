import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집 {
	static int R, C, result;
	static char[][] map;
	static boolean[][] visited;
	static boolean flag;
	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < R; i++) {
			flag = false;
			search(i, 0);

		}

		System.out.println(result);
	}

	public static void search(int x, int y) {
		if (y == C - 1) {
			result++;
			flag = true;
			return;
		}
		if (x - 1 >= 0 && map[x - 1][y + 1] == '.' && !visited[x - 1][y + 1] && flag == false) {
			visited[x][y] = true;
			search(x - 1, y + 1);

		}
		if (map[x][y + 1] == '.' && !visited[x][y + 1] && flag == false) {
			visited[x][y] = true;
			search(x, y + 1);
		}
		if (x + 1 < R && map[x + 1][y + 1] == '.' && !visited[x + 1][y + 1] && flag == false) {		

			visited[x][y] = true;
			search(x + 1, y + 1);
		}
		
	}
}
