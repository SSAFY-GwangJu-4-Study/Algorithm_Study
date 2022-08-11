import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

enum direction {
	NORTH, EAST, SOUTH, WEST
}

public class Main_14503_최지성 {
	// 순서는 dir의 순서의 왼쪽 순서(dir의 0번이 북쪽이니까 deltaLeft의 0번은 서쪽)
	public static final int[][] deltaLeft = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	// 순서는 dir의 순서의 왼쪽 순서(dir의 0번이 북쪽이니까 deltaBack의 0번은 남쪽)
	public static final int[][] deltaBack = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
	public static int N;
	public static int M;
	public static int map[][];
	public static int cnt; // 청소한 칸 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		line = br.readLine();
		st = new StringTokenizer(line, " ");

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			line = br.readLine();
			st = new StringTokenizer(line, " ");
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean(r, c, d);

		System.out.println(cnt);
	}

	public static void clean(int r, int c, int d) {	
//		System.out.println("시작 :" + r + " " + c);
		
		// 1. 현재 위치 청소
		if (map[r][c] == 0) {
			map[r][c] = 2; // 청소한 땅은 2
			++cnt;
		}

		int nr = r + deltaLeft[d][0];
		int nc = c + deltaLeft[d][1];
//		System.out.println("다음 :" + nr + " " + nc + " " + map[nr][nc]);
		
		if (map[nr][nc] == 0) {
			int dir = (d - 1 + 4) % 4;
			clean(nr, nc, dir);
		} else {
			if (cantMove(r, c)) {
				int br = r + deltaBack[d][0];
				int bc = c + deltaBack[d][1];

				if (map[br][bc] != 1) {
					clean(br, bc, d);
				} else {
					return;
				}
			} else {
				int dir = (d - 1 + 4) % 4;
				clean(r, c, dir);
			}
		}
	}

	public static boolean cantMove(int r, int c) {
		return map[r - 1][c] != 0 && map[r + 1][c] != 0 && map[r][c - 1] != 0 && map[r][c + 1] != 0;
	}
}
