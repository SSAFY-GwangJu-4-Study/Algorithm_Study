import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;
/**
 * BOJ 16234 인구 이동 (완성) 어려웠다..
 * - BFS 사용
 * 1. 본인 상하좌우 인구 수 확인 (L이상 R 이하인지)
 * 2. 인구이동이 필요하다면 가능한 곳에 방문처리, 못가는 곳은 false => 배열 다 확인했으면 sum에 true인 배열의 값 다 더해주고, 방문한 배열 개수cnt => cnt/sum 한 값을 방문했던 배열에 다시 넣어주기
 * 3. 전체 위치를 탐색하며 다른 구역이 있는지 확인
 * 4. 인구이동이 필요 없을 때 까지, (1, 2) 반복
 * (실수)
 * - 문제 이해를 잘 못함 ㅠ. 구역 여러 개일 때를 고려 안함.
 * @author kjh
 *
 */
public class Main_16234_김정효 {
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};	//상 하 좌 우
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<int[]> list;
	static int n, l, r, cnt;
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}	// -------- 입력 완료 --------

		System.out.println(search());
	}

	private static int search() {
		int day = 0;		// 인구이동 몇 일 했는지 세는 변수
		while(true) {
			visit = new boolean[n][n];
			boolean move = false;		// 인구이동이 있었는지 없었는지 확인하는 변수
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j]) continue;
					int sum = bfs(i, j);
					if(list.size() > 1) {
						change(sum);	// 구역에 해당하는 값 변경하기
						move = true;
					}
				}
			}
			// 인구이동이 없었다면 리턴, 있었다면 day++
			if (!move) 	return day;
			day++;
		}
	}

	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();	// 인구 이동이 필요한 위치 넣기
		list = new ArrayList<>();	// 구역에 해당하는 위치 저장
		
		q.add(new int[] {x, y});
		list.add(new int[] {x, y});
		visit[x][y] = true;
		int sum = arr[x][y];	// 첫 원소값 더해주기
		
		while(!q.isEmpty()) {	// 더이상 인접한 위치가 없을 때 = 구역 끝
			int[] t = q.poll();		// 위치 하나씩 빼서 확인하기
			for (int k = 0; k < 4; k++) {
				int nx = t[0]+dx[k];
				int ny = t[1]+dy[k];
				if (nx<0 || ny<0 || nx>=n || ny>=n) continue;
				if (!visit[nx][ny]) {
					int dif = Math.abs(arr[t[0]][t[1]]-arr[nx][ny]);
					if (l<=dif && r>=dif) {	// 방문하지 않았고, 범위에 속한다면, 인접한 배열 q에 넣기
						visit[nx][ny]=true;
						q.add(new int[] {nx, ny});
						list.add(new int[] {nx, ny});
						sum += arr[nx][ny];	// 구역에 해당하는 인접 원소값 더해주기
					}
				}
			}
		}
		return sum;
	}

	private static void change(int num) {
		for (int i = 0; i < list.size(); i++) {
			int x = list.get(i)[0];
			int y = list.get(i)[1];
			arr[x][y] = num/list.size();	//   (인구수 합/영역수) 의 값으로 바꿔주기
		}
	}
}
