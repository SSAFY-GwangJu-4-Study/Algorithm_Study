import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	};
	
}
public class Main_1012_이서정 {

	static int map[][];
	static boolean visit[][];
	static int M,N;
	static int del[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T=input.nextInt();
		for(int test=0; test<T; test++) {
			M=input.nextInt();
			N=input.nextInt();
			int K=input.nextInt();
			int count=0;
			map=new int[N][M];
			for(int i=0; i<K; i++) {
				int x=input.nextInt();
				int y=input.nextInt();
				map[y][x]=1;
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
						if(map[i][j]==1) {
							count++;
							bfs(i,j);
						}
				}

			}

			System.out.println(count);
		}

	}
	
	static void bfs(int x,int y) {
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x,y));
		
		while(!queue.isEmpty()) {

			Point p=queue.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x+del[i][0];
				int ny = p.y+del[i][1];
				
				if(nx<N && nx>=0 && ny<M && ny>=0 && map[nx][ny]==1) {
					queue.add(new Point(nx,ny));
					map[nx][ny]=0;
				}
				
			}
		}
		
	}

}
