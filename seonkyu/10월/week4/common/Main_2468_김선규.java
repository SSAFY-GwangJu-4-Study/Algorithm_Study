import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_김선규 {
	
	
	static boolean[][] visit;
	static int[][] map, delta = {{1, 0},{0, 1},{-1, 0},{0, -1}};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int maxH = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		// input end
		
		int sector = 1;
		
		for(int i=0; i<maxH; i++) {
			
			int cnt = 0;
			visit = new boolean[N][N];
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(map[j][k] > i && !visit[j][k]) {
						dfs(j, k, N, i);
						cnt++;
					}
				}
			}
			
			sector = Math.max(sector, cnt);
		}
		System.out.println(sector);
		
	}

	private static void dfs(int j, int k, int N, int h) {
		
		visit[j][k] = true;
		
		for(int i=0; i<4; i++) {
			int nx = j + delta[i][0];
			int ny = k + delta[i][1];
			
			if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny] && map[nx][ny] > h) {
				dfs(nx, ny, N, h);
			}
		}
		
	}

}
