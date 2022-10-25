import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int N;
	static int[][] map;
	static int[][] tempmap;
	static boolean[][] visit;
	static int max=Integer.MIN_VALUE;
	static int[][] del={{-1,0},{1,0},{0,1},{0,-1}};
	static int result=1;
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N=Integer.parseInt(st.nextToken());
			map=new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					max=Math.max(map[i][j], max);
				}
			}
			
			

			//다 잠길때까지 안전영역 확인해보기
			//일단 안전영역의 최대수는 1로 초기화하기
			for(int i=1; i<max; i++) {
				//max값보다 작으면 다 잠기게 만들기
				tempmap=map.clone();
				visit=new boolean[N][N];
				int count=0;
				for(int k=0; k<N; k++) {
					for(int j=0; j<N; j++) {
						if(map[k][j]<=i) {
							tempmap[k][j]=0;
						}
					}
				}//물에 잠기면 0으로 만듦
				for(int k=0; k<N; k++) {
					for(int j=0; j<N; j++) {
						if(tempmap[k][j]!=0 && visit[k][j]==false) {//물에 잠긴 영역이라면 bfs를 돌아
							count++;
							bfs(k,j);
						}
					}
				}
				

				result=Math.max(result, count);
			}
			
			System.out.println(result);
	}

	static void bfs(int x, int y) {
		Queue<Node> queue=new ArrayDeque<>();
		queue.add(new Node(x,y));
		visit[x][y]=true;
		
		while(!queue.isEmpty()) {
			Node tempnode=queue.poll();
			for(int i=0; i<4; i++) {
				int nx=tempnode.x+del[i][0];
				int ny=tempnode.y+del[i][1];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && tempmap[nx][ny]!=0 && visit[nx][ny]==false) {
					visit[nx][ny]=true;
					queue.add(new Node(nx,ny));
				}
			}
		}
		
		
	}

}