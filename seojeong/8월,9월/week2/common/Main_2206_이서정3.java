import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class getnode3{
	int x;
	int y;
	int count;
	boolean change;
	
	public getnode3(int x, int y, int count, boolean change) {
		super();
		this.x = x;
		this.y = y;
		this.count = count;
		this.change=change;
	}
}

public class Main_2206_이서정3{
	static int del[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //위 아래 왼 오 
	static int map[][];
	static int N,M;
	static boolean visit[][][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map=new int[N+1][M+1];
		visit=new boolean[N+1][M+1][2];
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j]=Character.getNumericValue(s.charAt(j-1));
			}
		}
		
		go(1,1);
	}
	static void go(int x, int y) {
		
		Queue<getnode3> queue= new LinkedList<>();
        visit[x][y][0]=true;
		queue.add(new getnode3(x,y,1,false)); //큐에다가 첫번째 노드를 생성해서 넣음
		

		while(!queue.isEmpty()) {
				getnode3 get = queue.poll();//큐에 있는 원소 빼기
				int gx=get.x; //x좌표
				int gy=get.y; //y좌표
				int c = get.count; //count
				boolean g = get.change; //flag
				
				
				for(int k=0; k<4; k++) {
					int nx=gx+del[k][0]; //주변에 갈 x좌표
					int ny=gy+del[k][1];

					if(nx>=1 && nx<=N && ny>=1 && ny<=M) {
								if(map[nx][ny]==1 && visit[nx][ny][1]==false) { //벽이야
							if(g==false) { //벽 깬적 없어
								visit[nx][ny][1]=true;
								queue.add(new getnode3(nx,ny,c+1,true)); //벽 깼어
								}
							}
						if(map[nx][ny]==0) {
							if(g==false && visit[nx][ny][0]==false) {
								visit[nx][ny][0]=true;
								queue.add(new getnode3(nx,ny,c+1,false));
							}//벽 깬적 없어
							if(g==true && visit[nx][ny][1]==false) {
								visit[nx][ny][1]=true;
								queue.add(new getnode3(nx,ny,c+1,true));
							}//벽 깬적 있어
							
							}
						
						}
						
					if(gx==N && gy==M) {
						System.out.println(c);
						return;
						}
					}
				
				}
		System.out.println(-1);
		}
		
		
	}
