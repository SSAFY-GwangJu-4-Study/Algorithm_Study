import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/**
 * 16234 인구이동
 * dfs 풀이
 * @author 김경삼
 *
 */
public class Main_16234_김경삼 {
	static int N, L, R, sum, cnt;
	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };
	static ArrayList<int[]> posList;
	static ArrayList<Integer> list;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int day = 0;
		while (true) {
			flag = true;
			int[][] visited = new int[N][N];
			int checker = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0) {
						open(i, j, map, visited, checker);
						if (cnt != 1) {
							flag = false;
							int result = sum / cnt;
							for (int k = 0; k < N; k++) {
								for (int l = 0; l < N; l++) {
									if (visited[k][l] == checker) {
										map[k][l] = result;
									}
								}
							}
						}
					}
					sum = 0;
					cnt = 0;
					checker++;
				}
			}
//			print(map);
//			for(int i=0;i<posList.size();i++) {
//				System.out.println(posList.get(i)[0]+" "+posList.get(i)[1]);
//			}

			if (flag)
				break;
			day++;
		}
		System.out.println(day);
	}

	static void open(int r, int c, int[][] map, int[][] visited, int checker) {
		posList = new ArrayList<>();
		visited[r][c] = checker;
		int cur = map[r][c];
		sum += cur;
		cnt += 1;
		posList.add(new int[] { r, c });

		for (int d = 0; d < 4; d++) {
			int nr = r + deltaR[d];
			int nc = c + deltaC[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] != 0)
				continue;
			int next = map[nr][nc];
			int diff = Math.abs(cur - next);
			if (diff >= L && diff <= R) {
				open(nr, nc, map, visited, checker);
			}
		}
	}

	static void print(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
