import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빙산 G4
 * 
 * @author multicampus
 *
 */
public class Main_2573_김경삼 {
	static int R, C;
	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };
	static int[][] map, tmpMap;
	static int time,checkCnt;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		simul();
		System.out.println(time);
	}

	// 1. 구현 문제, 배열을 돌면서 각 좌표에서 상하좌우 보고 0개수 count, 0개수만큼 빼주기.
	// 0이 되면, 다른 좌표에 영향을 주기때문에 map 복사해서 진행하기.
	// 2. 1년이 지나서 녹는게 끝나면 dfs로 덩어리가 나눠졌는지 check 해주기.
	static void simul() {
		while (true) {
			time++;
			checkCnt=0;
			tmpMap = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0) {
						int zeroCnt = 0;
						for (int d = 0; d < 4; d++) {
							int nr = i + deltaR[d];
							int nc = j + deltaC[d];
							if (nr < 0 || nc < 0 || nr >= R || nc >= C)
								continue;
							if (map[nr][nc] == 0)
								zeroCnt++;
						}
						tmpMap[i][j] += zeroCnt;
					}
				}
			}
			// 0개수 카운트가 끝나면 tmpMap 반영 결과만큼 map에서 빼주기
			// 음수 되면 0으로 바꿔주기
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0) {
						map[i][j] -= tmpMap[i][j];
						if (map[i][j] < 0)
							map[i][j] = 0;
					}
				}
			}
			//dfs로 호출 횟수 checkCnt --> 덩어리의 개수 의미.
			visited = new boolean[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0&&!visited[i][j]) {
						check(i, j);
						checkCnt++;
					}
				}
			}
			if(checkCnt>=2) return;
			if (allMeltCheck()) {
				time = 0;
				return;
			}
		}
	}
	// 모든 얼음이 녹은 경우 0 출력
	private static boolean allMeltCheck() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 0)
					return false;
			}
		}
		return true;
	}

	private static void check(int r, int c) {
		visited[r][c]=true;
		
		for (int d = 0; d < 4; d++) {
			int nr = r + deltaR[d];
			int nc = c + deltaC[d];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C||map[nr][nc]==0||visited[nr][nc])continue;
			check(nr,nc);
		}
	}
}
