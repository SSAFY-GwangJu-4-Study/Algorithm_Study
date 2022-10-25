import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16197_두_동전 {
	static int N, M, min = Integer.MAX_VALUE;
	 // 두 동전의 좌표
	static char[][] map;
	static char[] arr = {'N', 'S', 'W', 'E'};
	static class Point{
		int ax, ay, bx, by;

		public Point(int ax, int ay, int bx, int by) {
			super();
			this.ax = ax;
			this.ay = ay;
			this.bx = bx;
			this.by = by;
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ax = -1, ay = -1, bx = 0, by = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(s.charAt(j) == 'o') {//동전이면 빈칸으로 만들어주고 좌표 받기
					map[i][j] = '.';
					if(ax == -1) {
						ax = i;
						ay = j;
					}else {
						bx = i;
						by = j;
					}
				}
			}
		}
		
		perm(0, ax, ay, bx, by);
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
	
	}
	
	static void perm(int cnt, int ax, int ay, int bx, int by) {
		if(isEscape(ax, ay, bx, by)) {
			if(isAll(ax, ay, bx, by)) return;
			min = Math.min(min, cnt);
			return;
		}
		if(cnt == 10) {
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			Point p = move(arr[i], ax, ay, bx, by);		
			perm(cnt+1, p.ax, p.ay, p.bx, p.by);
		}
	
	}
	
	static boolean isEscape(int ax, int ay, int bx, int by) {
		if(ax >= N || ax < 0 || ay >= M || ay < 0 || bx >= N || bx < 0 || by >= M || by < 0) return true;
		return false;
	}
	
	static boolean isAll(int ax, int ay, int bx, int by) {
		if((ax >= N || ax < 0 || ay >= M || ay < 0 )&&(bx >= N || bx < 0 || by >= M || by < 0)) return true;
		return false;
	}
	
	static Point move(char direction, int ax, int ay, int bx, int by) {
		Point p = new Point(ax, ay, bx, by);
		switch(direction) {
		case 'N':
			if(ax-1 < 0 || map[ax-1][ay] == '.') {
				p.ax -= 1;
			}
			if(bx-1 < 0 ||map[bx-1][by] == '.') {
				p.bx -= 1;
			}
			break;
			
		case 'S':
			if(ax+1 >= N || map[ax+1][ay] == '.') {
				p.ax += 1;
			}
			if(bx+1 >= N || map[bx+1][by] == '.') {
				p.bx += 1;
			}
			break;
			
		case 'W':
			if(ay-1 < 0 || map[ax][ay-1] == '.') {
				p.ay -= 1;
			}
			if(by-1 < 0 ||map[bx][by-1] == '.') {
				p.by -= 1;
			}			
			break;
			
		case 'E':
			if(ay+1 >= M || map[ax][ay+1] == '.') {
				p.ay += 1;
			}
			if(by+1 >= M || map[bx][by+1] == '.') {
				p.by += 1;
			}
			break;
		}
		
		return p;
			
	}

}
