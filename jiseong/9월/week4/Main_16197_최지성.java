import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16197_최지성 {
	static class Marble {
		int y;
		int x;

		public Marble(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static Marble[] marbles;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M;
	static char[][] map;
	static int[] cmd;
	static boolean success;
	static int button;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N + 2][M + 2];
		marbles = new Marble[2];
		cmd = new int[11];
		button = 10;

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			char[] line = br.readLine().toCharArray();

			for (int j = 1; j <= M; j++) {
				map[i][j] = line[j - 1];
				
				if (map[i][j] == 'o') {
					marbles[cnt++] = new Marble(i, j);
				}
			}
		}

		dfs(0);

		System.out.println(success ? button : -1);

	}

	static void dfs(int cnt) {
		if (cnt > button) {
			return;
		}

		if (simul(cmd, cnt)) {
			button = Math.min(button, cnt);
			success = true;
			return;
		}

		for (int i = 0; i < 4; i++) {
			cmd[cnt] = i;
			dfs(cnt + 1);
		}
	}

	static boolean simul(int[] cmd, int cnt) {
//		for(int i = 0; i < cnt; i++) {
//			System.out.print(cmd[i] + " ");
//		}
//		
//		System.out.println();
//		System.out.println(cnt);
//		System.out.println();
		
		Marble marble1 = new Marble(marbles[0].y, marbles[0].x);
		Marble marble2 = new Marble(marbles[1].y, marbles[1].x);

		for (int i = 0; i < cnt; i++) {
			if (map[marble1.y + delta[cmd[i]][0]][marble1.x + delta[cmd[i]][1]] != '#') {
				marble1.y += delta[cmd[i]][0];
				marble1.x += delta[cmd[i]][1];
			}
			if (map[marble2.y + delta[cmd[i]][0]][marble2.x + delta[cmd[i]][1]] != '#') {
				marble2.y += delta[cmd[i]][0];
				marble2.x += delta[cmd[i]][1];
			}

//			System.out.println(marble1.y + " " + marble1.x + " " + marble2.y + " " + marble2.x);
			
			if ((inMap(marble1) && !inMap(marble2)) || (!inMap(marble1) && inMap(marble2))) {
//				System.out.println("하나 나감");
				return true;
			}

			if ((!inMap(marble1) && !inMap(marble2))) {
//				System.out.println("둘 다 나감");
				return false;
			}
		}

		return false;
	}

	static boolean inMap(Marble m) {
		return m.y > 0 && m.y <= N && m.x > 0 && m.x <= M;
	}
}
