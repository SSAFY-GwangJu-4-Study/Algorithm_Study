import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_헌터_최지성 {
	static int N;
	static int[][] map;
	static int[][] customer; // 고객 위치 y, x좌표
	static int[][] monster; // 몬스터 위치 y, x좌표
	static ArrayList<Integer> list; // 몬스터 번호, 고객 번호 => 순열 위함
	static int minTime;	// 결과
	static int count; // 고객과 몬스터 수
	static boolean[] visited;
	static boolean[] canVisit; // 현재 몬스터를 잡아서 고객한테 돌아갈 수 있는지 체크

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			minTime = Integer.MAX_VALUE;
			count = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			customer = new int[5][2];	// 4명까지 들어옵니다
			monster = new int[5][2];

			StringTokenizer st = null;

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] != 0) {
						if (map[i][j] > 0) {
							monster[map[i][j]][0] = i;	//1번몬스터 => 배열의 1, 0 y값, 1,1 x값
							monster[map[i][j]][1] = j;
						} else {
							customer[-map[i][j]][0] = i;
							customer[-map[i][j]][1] = j;
							count++;
						}
					}
				}
			}

			list = new ArrayList<>();
			// -1, -2,-3, 1, 2, 3 순으로 저장
			for (int i = 1; i <= count; i++) {
				list.add(-i);
			}
			for (int i = 1; i <= count; i++) {
				list.add(i);
			}
			visited = new boolean[list.size()];
			canVisit = new boolean[list.size()];

			for (int i = 0; i < canVisit.length; i++) {
				if (list.get(i) > 0)
					canVisit[i] = true;
			}

			perm(0, new ArrayList<Integer>());
			
			System.out.println("#" + tc + " " + minTime);
		}
	}

	public static void perm(int cnt, ArrayList<Integer> path) {
		if (cnt == list.size()) {
			int y = 1;
			int x = 1;

			int sum = 0;
			for (int i = 0; i < path.size(); i++) {
				int now = path.get(i);
				
				int nextY = -1;
				int nextX = -1;
				if (now > 0) {	// 몬스터라면
					nextY = monster[now][0];
					nextX = monster[now][1];
				} else {	// 고객이라면
					nextY = customer[-now][0];
					nextX = customer[-now][1];					
				}
				sum += getDist(y, x, nextY, nextX);
				
				y = nextY;
				x = nextX;
			}
			
			minTime = Math.min(minTime, sum);
			return;
		}

		for (int i = 0, size = list.size(); i < size; i++) {
			if (!visited[i] && canVisit[i]) {
				visited[i] = true;
				if (list.get(i) > 0)
					canVisit[i - count] = true;
				path.add(list.get(i));
				perm(cnt + 1, path);
				path.remove(path.indexOf(list.get(i)));
				visited[i] = false;
				if (list.get(i) > 0)
					canVisit[i - count] = false;
			}
		}
	}

	public static int getDist(int curY, int curX, int destY, int destX) {
		return Math.abs(curY - destY) + Math.abs(curX - destX);
	}
}
