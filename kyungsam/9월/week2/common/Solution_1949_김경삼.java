import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 등산로 조성 SWEA 모의역량문제
 * 스터디 때 질문할 내용: 왜 visited false처리 해야하는지.
 * @author Kyungsam Kim
 *
 */
public class Solution_1949_김경삼 {
	static int N,K,cnt,ans;
	static int[][] map,copyMap;
	static boolean[][] visited;
	static int[] deltaR = {-1,1,0,0}; //상하 좌우
	static int[] deltaC = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb =  new StringBuilder();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			map= new int[N][N];
			int max=0;
			ans =0;
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
					max=Math.max(max,map[i][j]);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==max) {
						recur(i,j);
					}
				}
			}
			sb.append(ans);
			System.out.println(sb);
		}
	} //main끝
	
	private static void recur(int r,int c) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
//				if(i==r&&j==c) continue;
				for(int k=1;k<=K;k++) {
					copyMap=new int[N][N];
					visited=new boolean[N][N];
					cnt=0;
					for(int a=0;a<N;a++) {
						for(int b=0;b<N;b++) {
							copyMap[a][b]=map[a][b];
						}
					}
					copyMap[i][j]-=k;
					dfs(r,c,1,copyMap);
					ans= Math.max(ans, cnt);
				}
			}
		}
	}
	
	private static void dfs(int r,int c,int depth,int[][]copyMap) {
		int cur = copyMap[r][c];
		visited[r][c]=true;
		for(int d=0;d<4;d++){
			if(depth>cnt) cnt=depth;
			int nr = r+deltaR[d];
			int nc = c+deltaC[d];
			if(nr<0||nc<0||nr>=N||nc>=N||visited[nr][nc])continue;
			if(copyMap[nr][nc]>=cur)continue;
			if(copyMap[nr][nc]<cur) {
				visited[nr][nc]=true;
				dfs(nr,nc,depth+1,copyMap);
				visited[nr][nc]=false;
			}
		}
//		cnt = Math.max(cnt,depth);
	}
}
