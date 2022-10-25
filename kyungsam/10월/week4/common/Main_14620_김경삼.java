import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 꽃길 문제
 * 2차원을 1차원으로 바꿔서 3개의 점을 고르고 꽃이 죽지 않는 조건을 만족할때 최소비용을 구하기.
 * @author 김경삼
 *
 */
public class Main_14620_김경삼 {
	static int N,ans,sum;
	static int[] tmp;
	static int[][]map;
	static boolean[]seleceted;
	static boolean[][]visited;
	static int[] deltaR= {-1,1,0,0};
	static int[] deltaC= {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		N= Integer.parseInt(br.readLine());
		map=new int[N][N];
		seleceted =new boolean[N*N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		tmp=new int[3];
		ans =Integer.MAX_VALUE;
		comb(0,0);
		System.out.println(ans);
	}
	
	static void comb(int cnt,int start) {
		if(cnt==3) {
			int tmpCnt=0;
			sum=0;
			visited=new boolean[N][N];
			for(int i=0;i<tmp.length;i++) {
				//가장자리면 탐색필요 x
				if(tmp[i]/N==0||tmp[i]%N==0||tmp[i]/N==N-1||tmp[i]%N==N-1) {
					return;
				}
				//꽃이 피었을때, 방문한 곳을 다시 방문하면 return
				int r = tmp[i]/N;
				int c = tmp[i]%N;
				visited[r][c]=true;
				for(int d=0;d<4;d++){
					int nr = r+deltaR[d];
					int nc = c+deltaC[d];
					if(visited[nr][nc])return;
					visited[nr][nc]=true;
				}
				
			}
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(visited[j][k]) {
						tmpCnt++;
						sum+=map[j][k];
					}
				}
			}
//			print();
//			System.out.println("tmpCnt: "+tmpCnt);
//			System.out.println(Arrays.toString(tmp));
//			System.out.println(sum);
			//두 조건을 피하면 꽃 필 수 있음.
			 ans= Math.min(ans, sum);
			return;
		}
		
		
		for(int i=start;i<N*N;i++) {
			seleceted[i]=true;
			tmp[cnt]=i;
			comb(cnt+1,i+1);
			seleceted[i]=false;
		}
	}
	
	static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
	}
}
