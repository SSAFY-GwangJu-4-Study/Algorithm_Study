import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1303 전쟁-전투
 * @author 김경삼
 *
 */
public class Main_1303_김경삼 {
	static int N,M,wCnt,bCnt,wSum,bSum;
	static int[][] arr;
	static int[] deltaR = {-1,1,0,0}; // 상하좌우 탐색
	static int[] deltaC = {0,0,-1,1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		visited = new boolean[M][N];
		for(int i=0;i<M;i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				arr[i][j]=line[j]; 
			}
		}
//		System.out.println(Arrays.deepToString(arr)); //W = 87, B =66
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false) {
					wCnt=1;
					bCnt=1;
					dfs(i,j);
					if(arr[i][j]==87) {
						wSum+=(wCnt*wCnt);
					}else {
						bSum+=(bCnt*bCnt);
					}
				}
			}
		}
		System.out.println(wSum+" "+bSum);
		
	}
	//막히면 해당 위치의 Wcnt, Bcnt 제곱해서 sum에 더해주기.
	private static void dfs(int r, int c) { //상하좌우보고 현재와 같은게 있는지 판단
		int value = arr[r][c];
		visited[r][c]=true;
		
		for(int i=0;i<4;i++) {
			int nr = r+deltaR[i];
			int nc = c+deltaC[i];
			
			if(nr<0||nc<0||nr>=M||nc>=N) continue;
			if(arr[nr][nc]!=value) continue;
			if(visited[nr][nc]==true)continue;
			if(value==87)wCnt++;
			if(value==66)bCnt++;
			dfs(nr,nc);
		}
	}
}
