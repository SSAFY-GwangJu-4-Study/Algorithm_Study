import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_김선규 {
	
	static int N, M, day, remain;
	static int[][] cheese;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cheese = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if(cheese[i][j] == 1) remain++;
			}
		}
		// input end

		// (0,0)부터 시작해서 0인곳을 탐색한다. 만약 1을 발견하면 true체크하고 다시 0을 탐색
		while(true) {
			bfs(0, 0);
			if(checkCheese())
				break;
		}
		
		System.out.println(day);
		System.out.println(remain);
		
	}
	
	public static void bfs(int x, int y) {
		
		
		Queue<Location> q = new LinkedList<>();
		q.add(new Location(x, y));
		
		while(!q.isEmpty()) {
			Location loc = q.poll();
			
			// 4방 탐색
			for(int i=0; i<4; i++) {
				int nx = loc.x + delta[i][0];
				int ny = loc.y + delta[i][1];
				// 범위 안의 가장 바깥쪽 1인 곳을 탐색
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && cheese[nx][ny] == 1) {
					// 가장 바깥쪽 1은 2로 바꿔준다. -> 곧 녹을 치즈 
					cheese[nx][ny] = 2;
					
				}
				
				// 0인 곳은 3으로 바꿔준다.
				if(nx >= 0 && ny >= 0 && nx < N && ny < M && cheese[nx][ny] == 0) {
					cheese[nx][ny] = 3;
					q.add(new Location(nx, ny));
				}
			}
		}
		
		// 2와 3은 다시 0으로
		changeNumber();
		day++;
	}
	
	public static void changeNumber() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(cheese[i][j] == 2 || cheese[i][j] == 3) cheese[i][j] = 0;
				
			}
		}
	}
	
	public static boolean checkCheese() {
		int cnt = 0;
		int oneCnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(cheese[i][j] == 0) cnt++;
				else if(cheese[i][j] == 1) oneCnt++;
			}
		}
		
		if(oneCnt != 0)
			remain = oneCnt;
		
		if(cnt == N*M)
			return true;
		else
			return false;
	}
	
	static class Location {
		int x, y;
		
		public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
	}
	

}


