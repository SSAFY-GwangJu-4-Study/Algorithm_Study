import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2572_빙산2 {
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N,M;
	static int map[][];
	static int map2[][];
	static boolean visit[][];
	static int del[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	static int year;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
			}
		}
		
		while(true) {
			int countz=0;
			year++;
			map2=new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]!=0) {
						changemap(i,j);
					}
					
				}
			}
			map=map2.clone();//map2에 붙여넣기
			boolean fin=false;
			visit=new boolean[N][M];

			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==0) {
						countz++;
					}
				}
			}
			if(countz==N*M) {
				System.out.println(0);
				break;
			}
			int countout=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]!=0 && visit[i][j]==false) {
						countout++;
						if(countout>=2) {
							fin=true;
							break;
						}
						bfs(i,j);
					}
				}
				if(fin==true) {
					break;
				}
			}
			
			if(fin==true) {
				System.out.println(year);
				break;
			}
	
			
		}
		
		


	
	}
	static void bfs(int x, int y) {
		Queue<Node> queue= new ArrayDeque<>();
		queue.add(new Node(x,y));
		visit[x][y]=true;
		while(!queue.isEmpty()) {
			Node temp=queue.poll();
			for(int i=0; i<4; i++) {
				int nx=temp.x+del[i][0];	
				int ny=temp.y+del[i][1];
				if(nx>=0 && nx<N && ny>=0&& ny<M && visit[nx][ny]==false && map[nx][ny]!=0) {
					//범위안에 있고 들른적 없고 숫자이면
					visit[nx][ny]=true;
					queue.add(new Node(nx,ny));
				}
			}
			
			
		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<M; j++) {
//				System.out.print(visit[i][j]);
//			}
//			System.out.println();
//		}
	}
	static void changemap(int x, int y) {
		int count=0;
		for(int i=0; i<4; i++) {
			int nx=x+del[i][0];
			int ny=y+del[i][1];
			
			if(nx>=0 && nx<N && ny>=0&& ny<M) {
				if(map[nx][ny]==0) {//주변이 0이면
					count++;
				}
			}
		}
		if(map[x][y]-count<0) {
			map2[x][y]=0;
		}
		else {
			map2[x][y]=map[x][y]-count;	
		}
		
	}
}
