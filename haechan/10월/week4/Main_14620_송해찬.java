import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main_14620_송해찬 {

	static int N, minCost;
	static int[][] grid;
	static List<Pos> posList;
	static Pos[] seedPos;
	static int[][] deltas = {{0,0}, {1,0}, {-1,0}, {0,1}, {0,-1}};
	
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
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		posList = new ArrayList<>();
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				posList.add(new Pos(i, j));
			}
		}
		
		seedPos = new Pos[3];
		minCost = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(minCost);
	}
	
	
	static void comb(int cnt, int start) {
		if(cnt == 3) {
//			for(int i=0; i<3; i++) {
//				System.out.println(seedPos[i].r + " " + seedPos[i].c);
//			}
//			System.out.println();
			
			// 씨앗 거리 2 이하면 패스
			for(int i=0; i<3; i++) {
				// 0 1 2
				// 01 12 20
				if(distCheck(seedPos[i].r, seedPos[i].c, seedPos[(i+1)%3].r, seedPos[(i+1)%3].c)) {
					return;
				}
			}
			
//			for(int i=0; i<3; i++) {
//			System.out.println(seedPos[i].r + " " + seedPos[i].c);
//			}
//			System.out.println();

			int temp = 0;
			for(int i=0; i<3; i++) {
				temp += getCost(seedPos[i]);
			}
			
			minCost = Math.min(minCost, temp);
			return;
		}
		
		for(int i=start; i<posList.size(); i++) {
			seedPos[cnt] = posList.get(i);
			comb(cnt+1, start+1);
		}
	}
	
	static boolean distCheck(int x0, int y0, int x1, int y1) {
		// 씨앗 사이 거리가 2 이하면 체크에 걸림
		if(Math.abs(x0-x1) + Math.abs(y0-y1) <= 2) {
			return true;
		}
		else return false;
	}
	
	// 5칸에 대한 비용 가져오기
	static int getCost(Pos pos) {
		int cost = 0;
		for(int d=0; d<deltas.length; d++) {
			int nr = pos.r + deltas[d][0];
			int nc = pos.c + deltas[d][1];
			cost += grid[nr][nc];
		}
		return cost;
	}
	
}
