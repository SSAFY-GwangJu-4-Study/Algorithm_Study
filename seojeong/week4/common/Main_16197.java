import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16197 {

	static char map[][];
	static int num[];
	static int count,M,N;
	static int coin[][];
	static int min=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s;
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		int c=0;
		map= new char[N][M];
		coin= new int[2][2];
		for(int i=0; i<N; i++) {
			s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='o') {
					coin[c][0]=i;
					coin[c][1]=j;
					c++;
				}
			}
		}
		num=new int[10];
		perm(0);
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(min);	
		}
		
		
	}
	
	static void perm(int cnt) {
		if(cnt==10) {
//			System.out.println(Arrays.toString(num));
			min=Math.min(min, bfs());
			return;
		}
		
		for(int i=0; i<4; i++) {
			num[cnt]=i;
			perm(cnt+1);
		}
	}
	static int bfs() {
		int fx=coin[0][0];
		int fy=coin[0][1];
		int sx=coin[1][0];
		int sy=coin[1][1];
		
		int counttime=0;
		
		for(int i=0; i<10; i++) {
			counttime++;
			if(num[i]==0) {
				if(fx-1<0 && sx-1<0) {
					return Integer.MAX_VALUE;
				}
				if(fx-1<0 || sx-1<0) {
					return counttime;
				}
				if(fx-1>=0 && map[fx-1][fy]!='#') {
					fx=fx-1;
				}
				if(sx-1>=0 && map[sx-1][sy]!='#') {
					sx=sx-1;
				}
			}
			if(num[i]==1) {
				if(fy+1>=M && sy+1>=M) {
					return Integer.MAX_VALUE;
				}
				if(fy+1>=M || sy+1>=M) {
					return counttime;
				}
				if(fy+1<M && map[fx][fy+1]!='#') {
					fy=fy+1;
				}
				if(sy+1<M && map[sx][sy+1]!='#') {
					sy=sy+1;
				}
			
			}
			if(num[i]==2) {
				if(fx+1>=N && sx+1>=N) {
					return Integer.MAX_VALUE;
				}
				if(fx+1>=N || sx+1>=N) {
					return counttime;
				}
				if(fx+1<N && map[fx+1][fy]!='#') {
					fx=fx+1;
				}
				if(sx+1<N && map[sx+1][sy]!='#') {
					sx=sx+1;
				}
				
			}
			if(num[i]==3) {
				if(fy-1<0 && sy-1<0) {
					return Integer.MAX_VALUE;
				}
				if(fy-1<0 || sy-1<0) {
					return counttime;
				}
				if(fy-1>=0 && map[fx][fy-1]!='#') {
					fy=fy-1;
				}
				if(sy-1>=0 && map[sx][sy-1]!='#') {
					sy=sy-1;
				}
				
			}
		}
		return Integer.MAX_VALUE;
	}

}
