import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cheeselist{
	int x;
	int y;
	public Cheeselist(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main_2636_이서정2{
	
	static int[][] del = {{-1,0},{1,0},{0,-1},{0,1}};
	static int map[][];
	static int map2[][];
	static int N,M;
	static boolean visit[][];
	static int count=0;
	static int countone;
	static Queue<Cheeselist> queue;
	static int cheesecount;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//1인 애들중에서 사방탐색하면서 끝까지 가다가 가장자리에 도달하는 애들은 0으로 지워주기
		//끝까지 한바퀴돌면  count세주기, 그 당시에 남아있는 1의 개수 세어주기
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		map2=new int[N][M];
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					cheesecount++;
				}
			}
		}
		visit=new boolean[N][M];

		
		int temp=0;
		while(true) {
			visit=new boolean[N][M];
			temp=cheesecount;
			bfs(0,0);
			meltingcheese();
			countone=cheesecount;
			count++;
			if(cheesecount<=0) {
				break;
			}
		}
		System.out.println(count);
		System.out.println(temp);
		

	}
	static void bfs(int x,int y) {
		queue = new LinkedList<>();
		queue.offer(new Cheeselist(x,y));
		
		while(!queue.isEmpty()) {
			Cheeselist c=queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx=c.x + del[i][0];
				int ny=c.y + del[i][1];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==1) {
					map2[nx][ny]=3;
				}
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==0 && visit[nx][ny]==false) {
					queue.offer(new Cheeselist(nx,ny));
					visit[nx][ny]=true;
				}
			}
			
			
		}
		
		
	}
	static void meltingcheese() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map2[i][j]==3) {
					cheesecount--;
					map[i][j]=0;
					map2[i][j]=0;
				}
				
			}
		}
	}


}
