import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class nodelist{
	int x;
	int y;
	int count;
	
	public nodelist(int x, int y, int count) {
		super();
		this.x = x;
		this.y = y;
		this.count = count;
	}
}

public class Main_2589_이서정{
	static int del[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //위 아래 왼 오 
	static char map[][];
	static int N,M;
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map=new char[N+1][M+1];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=s.charAt(j);
			}
		}
		
		int result=Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]=='L') {
					visit=new boolean[N][M];
					result=Math.max(go(i,j), result);
				}
			}
		}
		System.out.println(result);

	}
	static int go(int x, int y) {
		
		Queue<nodelist> queue= new LinkedList<>();
        visit[x][y]=true;
		queue.add(new nodelist(x,y,0)); //큐에다가 첫번째 노드를 생성해서 넣음
		int c=0;
		int max=Integer.MIN_VALUE;
		while(!queue.isEmpty()) {
				nodelist get = queue.poll();//큐에 있는 원소 빼기
				int gx=get.x; //x좌표
				int gy=get.y; //y좌표
				
				c = get.count; //count
						
				for(int k=0; k<4; k++) {
					int nx=gx+del[k][0]; //주변에 갈 x좌표
					int ny=gy+del[k][1];

					if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]=='L' && visit[nx][ny]==false) {
						visit[nx][ny]=true; //여기다 넣는거랑 모가달라
						queue.add(new nodelist(nx,ny,c+1));
						max=Math.max(c+1, max);
						
						}
					}
				
				}

		return max;
		}
		
		
	}
