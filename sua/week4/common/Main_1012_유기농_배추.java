import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농_배추 {
	public static int map[][];
	public static boolean visited[][];
	static int n, m, k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < T; i++) {
			int zirong = 0;
			
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			map = new int[n][m];
			visited = new boolean[n][m];
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					visited[j][k] = true;
				}
			}
			
			for(int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = 1;
				visited[x][y] = false;
				
			}
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(!visited[j][k]) {
						dfs(j, k);
						zirong++;
					}
				}
			}
			
			System.out.println(zirong);
		}
	
	}
	public static void dfs(int x, int y) {
		if(visited[x][y]) {
			return;
		}
		visited[x][y] = true;
		{
			if(x+1 < n) dfs(x+1, y);
			if(x-1 >= 0) dfs(x-1, y);
			if(y+1 < m) dfs(x, y+1);
			if(y-1 >= 0)dfs(x, y-1);
		}
	}
}
