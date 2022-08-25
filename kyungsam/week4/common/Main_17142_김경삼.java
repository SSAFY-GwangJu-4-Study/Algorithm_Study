import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

/**
 * 연구소3 골드4 조합으로 경우의 수 구하고, bfs 시뮬레이션 문제?
 * 
 * @author 김경삼
 *
 */
public class Main_17142_김경삼 {
	static int N, M, zeroCnt=0;
	static int[] deltaR = { -1, 1, 0, 0 };
	static int[] deltaC = { 0, 0, -1, 1 };
	static ArrayList<Virus> list;
	static int[][] map;
	static int[][] visited;
	static int[] target;
	static TreeSet<Integer> result = new TreeSet<>();

	static class Virus {
		int r, c;
//		boolean a;
		int time;

		public Virus(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new int[N][N];
		target = new int[M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Virus(i, j, 0));
				}
				if (map[i][j] == 0) {
					zeroCnt++;
				}
			}
		}
//		print();
		if (zeroCnt == 0) {
			System.out.println(0);
			return;
		}
		// 조합 찾아서 조합마다 bfs 수행하기 (모든 경우의 수 완전탐색)
		comb(0, 0);
		if (result.contains(-1)) {
			if (result.size() == 1) {
				System.out.println(-1);
				return;
			} else {
				result.remove(-1);
			}
		}
			System.out.println(result.first());
	}

	private static void comb(int cnt, int index) {
		// 한개의 조합이 완성되면 해당 조합마다 bfs 수행.
		if (cnt == M) {
			int nowresult = 0;
			int nowCnt = zeroCnt;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited[i][j] = map[i][j];
				}
			}

			Queue<Virus> queue = new LinkedList<>();
			for (int i = 0; i < M; i++) {
				Virus virus = list.get(target[i]);
				queue.offer(new Virus(virus.r, virus.c, virus.time));
			}

			loop: while (!queue.isEmpty()) {
				Virus cur = queue.poll();

				for (int d = 0; d < 4; d++) {
					int nr = cur.r + deltaR[d];
					int nc = cur.c + deltaC[d];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] == 1 || visited[nr][nc] == 3) {
						continue;
					}
					if (visited[nr][nc] == 0) {
						nowCnt --;
					}
					queue.offer(new Virus(nr, nc, cur.time + 1));
					visited[nr][nc] = 3;
					nowresult = Math.max(nowresult, cur.time + 1);
					if (nowCnt == 0) {
						break loop;
					}
				}
			}
			if (nowCnt != 0) {
				nowresult = -1;
			}
			result.add(nowresult);
			return;
		}
		
		for (int i = index; i < list.size(); i++) {
			target[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
	
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
