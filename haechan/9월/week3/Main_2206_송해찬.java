import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_2206_송해찬 {

	static int N, M, ans;
	static char[][] grid;
	// 최단경로는 방문배열 int로 선언해서 값 갱신해나가기
	// boolean으로 방문배열 만들면 조건에 따른 방문 false 처리가 너무 복잡
//	static boolean[][] visited;
	static int[][] visited;
	static int[][] deltas = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	
	static class Pos{
		// 최단경로만 구하는거면 dist만 필요한데
		// 벽 1개 부수기 조건으로 boom 추가
		int y, x, dist, boom;

		public Pos(int y, int x, int dist, int boom) {
			super();
			this.y = y;
			this.x = x;
			this.dist = dist;
			this.boom = boom;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 쿠션 생성, 초기화
		grid = new char[N+1][M+1];
		visited = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=M; j++) {
				grid[i][j] = str.charAt(j-1);
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		// 출발점에서 bfs 시작
		bfs(1, 1);
		if(ans > 0) sb.append(ans);
		else sb.append(-1);
		System.out.println(sb);
	}
	
	static void bfs(int y, int x) {
		Queue<Pos> queue = new LinkedList<>();
		// 시작칸 0 초기화
		visited[y][x] = 0;
		queue.offer(new Pos(y, x, 1, 0));
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			// 도착점 (N,M) 가장 먼저 도착한 dist 저장
			if(pos.y == N && pos.x == M) {
				ans = pos.dist;
				break;
			}
			for(int d=0; d<deltas.length; d++) {
				int ny = pos.y + deltas[d][0];
				int nx = pos.x + deltas[d][1];
				if(!isInside(ny, nx)) continue;
				// 벽을 한번도 안부수고 온 쪽이 먼저 탐색했다면 젤빠른길, 
				// visited에 0 담겨서 벽 부수고 온 쪽이 탐색안해도됌
				// 그러나 벽부수고 온 쪽이 먼저 탐색했다면, 벽 안부수고 온 쪽이 늦게는 도착했지만 완주가능성 있음
				// visited에 1 담겨서 벽안부수고 온 쪽이 뒷 코드 확인 가능
				if(pos.boom >= visited[ny][nx]) continue;
				
				// 갈수있을때
				if(grid[ny][nx] == '0') {
					// 일단 0으로 가기
					visited[ny][nx] = pos.boom;
					queue.offer(new Pos(ny, nx, pos.dist+1, pos.boom));
				}
				// 벽일때
				else if(grid[ny][nx] == '1') {
					// 한번도 벽부수기 안썼으면
					if(pos.boom == 0) {
						// 벽부수고 이제부터 1로 가기
						visited[ny][nx] = pos.boom+1;
						queue.offer(new Pos(ny, nx, pos.dist+1, pos.boom+1));
					}
				}
			}
		}
	}
	
	static boolean isInside(int ny, int nx) {
		return ny>=1 && ny<=N && nx>=1 && nx<=M; 
	}
}
