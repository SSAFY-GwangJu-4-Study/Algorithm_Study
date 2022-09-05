import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_헌터_김경삼 {
	static int[][]map;
	static ArrayList<Pos> monsters;
	static ArrayList<Pos> customers;
	static boolean[] visitedMon;
	static boolean[] visitedCus;
	static int ans;
	static class Pos{
		int r,c;
		int num;
		public Pos(int r, int c,int num) {
			this.r= r;
			this.c= c;
			this.num= num;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int T= Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N= Integer.parseInt(br.readLine());
			map= new int[N][N];
			monsters= new ArrayList<>();
			customers= new ArrayList<>();
			visitedMon= new boolean[5];
			visitedCus= new boolean[5];
			ans = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]>0) { //monster인 경우
						monsters.add(new Pos(i,j,map[i][j]));
					}
					if(map[i][j]<0) {
						customers.add(new Pos(i,j,map[i][j]));
					}
				}
			}
			dfs(0,0,0,0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	private static void dfs(int cnt,int dist,int r,int c) {
		if(dist>=ans) return;
		if(cnt==monsters.size()+customers.size()) {
			ans= Math.min(ans, dist);
		}
		for(int i=0;i<monsters.size();i++) {
			if(visitedMon[monsters.get(i).num]) {
				continue;
			}
			int d= calcDist(monsters.get(i).r, monsters.get(i).c, r, c);
			visitedMon[monsters.get(i).num]=true;
			dfs(cnt+1,dist+d,monsters.get(i).r,monsters.get(i).c);
			visitedMon[monsters.get(i).num]=false;
		}
		for(int i=0;i<customers.size();i++) {
			int n= Math.abs(customers.get(i).num);
			if(visitedCus[n]||!visitedMon[n]) continue;
			int d= calcDist(customers.get(i).r, customers.get(i).c, r, c);
			visitedCus[n]= true;
			dfs(cnt+1,dist+d,customers.get(i).r,customers.get(i).c);
			visitedCus[n]= false;
		}
	}
	private static int calcDist(int r1,int c1,int r2,int c2) {
		return Math.abs(r1-r2)+Math.abs(c1-c2);
	}
}
