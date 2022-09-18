import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_23288_송해찬 {

	static int N, M, K, dir, score, moveCnt;
	static int[][] grid;
	static boolean[][] visited;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}}; // 동, 남, 서, 북 (시계방향)
	static Dice dice;
	static int[][] diceMap;
	
	static class Dice{
		int r, c, bottomNum;
		public Dice(int r, int c, int bottomNum) {
			super();
			this.r = r;
			this.c = c;
			this.bottomNum = bottomNum;
		}
	}
	static class Pos{
		int r, c;
		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		grid = new int[N+1][M+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 주사위 전개도 초기화
		diceMap = new int[][]{{0,2,0},{4,1,3},{0,5,0},{0,6,0}};
		// 주사위 출발 좌표 (1,1) 아랫면 숫자 6
		dice = new Dice(1, 1, 6);
		// 이동방향 동쪽
		dir = 0;
		
		// K번 이동 횟수 동안
		for(int k=0; k<K; k++) {
			// dir 방향대로 한 칸 굴러가기
			dice.r += deltas[dir][0];
			dice.c += deltas[dir][1];
			// 이동방향이 범위 벗어나면, 반대로 한칸
			if(!isInside(dice.r, dice.c)) {
				dice.r -= 2*deltas[dir][0];
				dice.c -= 2*deltas[dir][1];
				// 이동방향 반대방향으로 만들기
				dir = (dir+2)%4;
				// 반대방향 한칸 이동했으니 전개도 바뀜
				changeDiceMap(dir);
			}
			// 벗어나지 않은 경우 원래 방향대로 굴리기
			else {
				// 방향대로 굴러가면서 전개도 바뀜 -> bottomNum 바뀜
				changeDiceMap(dir);
			}
			// 도착한 칸에 대한 점수 획득
			getScore(dice.r, dice.c);
			// 다음 방향 결정
			getDir(dice.bottomNum, dice.r, dice.c);
		}
		sb.append(score);
		System.out.println(sb);
	}
	
	static void getScore(int r, int c) {
		moveCnt = 0;
		visited = new boolean[N+1][M+1];
		// dfs하면 중간 시작 시 최대 개수 못찾아서 bfs로 함
		bfs(r, c);
//		System.out.println("r, c :" + r + " " + c + "  dir : " + dir + " bottomNum : " + dice.bottomNum + " score : " + grid[r][c]*moveCnt);
		score += grid[r][c]*moveCnt;
	}
	
	static void bfs(int r, int c) {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.offer(new Pos(r, c));
		visited[r][c] = true;
		moveCnt++;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			for(int d=0; d<deltas.length; d++) {
				int nr = pos.r + deltas[d][0];
				int nc = pos.c + deltas[d][1];
				if(!isInside(nr, nc) || visited[nr][nc] || grid[nr][nc] != grid[r][c]) continue;
				visited[nr][nc] = true;
				moveCnt++;
				queue.offer(new Pos(nr, nc));
			}
		}
	}
	
	static void getDir(int num, int r, int c) {
		int A = num;
		int B = grid[r][c];
		if(A>B) {
			// 시계방향
			dir = (dir+1)%4;
		}
		else if(A<B) {
			// 반시계방향
			dir = dir-1;
			if(dir<0) dir = 3;
		}
		else {
			// 그대로
		}
	}
	
	static void changeDiceMap(int dir) {
		int[] arr = new int[4];
		// 동쪽으로 구를때
		if(dir==0) {
			arr = new int[]{diceMap[3][1], diceMap[1][0], diceMap[1][1], diceMap[1][2]};
			diceMap[1][0] = arr[0];
			diceMap[1][1] = arr[1];
			diceMap[1][2] = arr[2];
			diceMap[3][1] = arr[3];
		}
		// 남쪽으로 구를때
		else if (dir==1) {
			arr = new int[]{diceMap[3][1], diceMap[0][1], diceMap[1][1], diceMap[2][1]};
			diceMap[0][1] = arr[0];
			diceMap[1][1] = arr[1];
			diceMap[2][1] = arr[2];
			diceMap[3][1] = arr[3];
		}
		// 서쪽으로 구를때
		else if (dir==2) {
			arr = new int[]{diceMap[1][1], diceMap[1][2], diceMap[3][1], diceMap[1][0]};
			diceMap[1][0] = arr[0];
			diceMap[1][1] = arr[1];
			diceMap[1][2] = arr[2];
			diceMap[3][1] = arr[3];
		}
		// 북쪽으로 구를때
		else if (dir==3) {
			arr = new int[]{diceMap[1][1], diceMap[2][1], diceMap[3][1], diceMap[0][1]};
			diceMap[0][1] = arr[0];
			diceMap[1][1] = arr[1];
			diceMap[2][1] = arr[2];
			diceMap[3][1] = arr[3];
		}
		// 아랫면 숫자 갱신
		dice.bottomNum = diceMap[3][1];
	}
	
	static boolean isInside(int nr, int nc) {
		return nr >= 1 && nr <= N && nc >= 1 && nc <= M;
	}
}
