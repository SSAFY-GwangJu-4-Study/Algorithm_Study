import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토{
	public static Queue<Tomato> queue;
	public static int n, m, h, zero;
	public static int[][][] tomato;
	public static int result;
	static class Tomato {
		int x;
		int y;
		int z;
		int day;

		public Tomato(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		tomato = new int [h][n][m];
		queue = new ArrayDeque<Tomato>();
		
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					tomato[k][i][j] = Integer.parseInt(st.nextToken());
					if (tomato[k][i][j] == 1) {
						queue.offer(new Tomato(i, j, k, 0));
					}
				}
			}
		}
		

		bfs();
		
		for (int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(tomato[k][i][j] == 0)
						result = -1;
				}
			}
		}
		
		if(result != -1) System.out.println(result-1);
		else System.out.println(result);

	}

	public static void bfs() {
		int[] dx = {1, -1, 0, 0, 0, 0};
		int[] dy = {0, 0, 1, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		
		while(!queue.isEmpty()) {
			Tomato tomas = queue.poll();
			int nx = tomas.x;
			int ny = tomas.y;
			int nz = tomas.z;
			int days = tomas.day+1;
			for(int i = 0; i < 6; i++) {
				int tx = nx + dx[i];
				int ty = ny + dy[i];
				int tz = nz + dz[i];
				if(tx >= 0 && tx < n && ty >= 0 && ty < m && tz >= 0 && tz < h) {
					result = days;
					if(tomato[tz][tx][ty] == 0) {
						queue.offer(new Tomato(tx, ty, tz, days));
						tomato[tz][tx][ty] = 1;
					}
				}
			}
			
		}
	}

}
