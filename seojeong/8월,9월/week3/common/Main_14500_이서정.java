import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_이서정 {
	
	static int[][] del = {{-1,0},{1,0},{0,-1},{0,1}};
	static int map[][];
	static int N,M;
	static boolean visit[][];
	static int num;
	static int four[];
	static int max=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		visit= new boolean[N][M];
		four = new int[4];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visit[i][j]=true;
				dfs(i,j,1,map[i][j]);
				visit[i][j]=false;
				getcount(i,j);
			}
		}

		System.out.println(max);
		
	}
	

	static void dfs(int x, int y,int cnt,int sum) {
		if(cnt==4) {
			max=Math.max(max, sum);
			return;
		}
		for(int i=0; i<4; i++) { //4방 탐색을 진행하면서
			int nx=x + del[i][0];
			int ny=y + del[i][1];
			
			if(nx>=0 && nx<N && ny>=0 && ny<M && visit[nx][ny]==false) {
				visit[nx][ny]=true;
				dfs(nx,ny,cnt+1,sum+map[nx][ny]);
				visit[nx][ny]=false;
			}
			
			
		}

	}
	
	static void getcount(int x, int y) {
		//ㅜ
		int getsum1=0;
		if(y-1>=0 && y+1<M && x+1<N ) {
			getsum1=map[x][y-1]+map[x][y+1]+map[x][y]+map[x+1][y];
		}
		max=Math.max(getsum1, max);
		//ㅗ
		int getsum2=0;
		if(y-1>=0 && y+1<M && x-1>=0 ) {
			getsum2=map[x][y-1]+map[x][y+1]+map[x][y]+map[x-1][y];
		}
		max=Math.max(getsum2, max);
		//ㅓ
		int getsum3=0;
		if(y-1>=0 && x+1<N && x-1>=0) {
			getsum3=map[x][y-1]+map[x+1][y]+map[x][y]+map[x-1][y];
		}
		max=Math.max(getsum3, max);
		//ㅏ
		int getsum4=0;
		if(x-1>=0 && y+1<M && x+1<N ) {
			getsum4=map[x][y+1]+map[x+1][y]+map[x][y]+map[x-1][y];
		}
		max=Math.max(getsum4, max);
	}

}
