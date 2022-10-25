import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node6{
	int x;
	int y;
	public Node6(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
public class Main_23288_이서정 {
	static int dice[][]= {{0,2,0},{4,1,3},{0,5,0},{0,6,0}}; //주사위 좌표넣기
	static int del[][]= {{1,0},{-1,0},{0,1},{0,-1}}; //사방탐색 진행
	static int M,N,T;
	static int map[][];
	static int map2[][];
	static boolean visit[][];
	static int getx,gety;
	static int index=1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		visit=new boolean[N][M];
		
		
		for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		

		int count=0;
		roll(1); //동쪽부터 실행

		count=bfs(getx,gety); //첫번째 bfs진행
		
		for(int i=1; i<T; i++) {
			if(dice[3][1]>map[getx][gety]) {
				index=(index+1)%4; //0,1,2,3 시계방향
				roll(index); //주사위 굴리기
			}
			else if(dice[3][1]<map[getx][gety]) {
				if(index-1<0) {
					index=4-((Math.abs(index-1))%4);//3,2,1,0 반시계방향 (ex)-2넣으면 1)
				}
				else {
				index=(index-1)%4;
				}
				roll(index); //주사위 굴리기
			}
			else {
				roll(index); //주사위 굴리기
			}
			visit=new boolean[N][M];
			map2=new int[N][M];
			count=count+bfs(getx,gety);
		}
		System.out.println(count);
		
	}
	
	static int bfs(int sx,int sy)
	{
		Queue<Node6> queue= new LinkedList<>();
		queue.offer(new Node6(sx,sy));
		visit[sx][sy]=true;
		
		int count=1;
		int num=0;
		while(!queue.isEmpty()) {
			Node6 temp=queue.poll();
			for(int i=0; i<4; i++) {
				int nx = temp.x+del[i][0];
				int ny = temp.y+del[i][1];
				num=map[temp.x][temp.y];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny]==num && visit[nx][ny]==false) { //사방탐색하면서 
					visit[nx][ny]=true; 
					queue.add(new Node6(nx,ny));
					count++; //같은 값들의 개수세기

					
					}
			}
		}
		
		return count*num; //더해야되는 값 리턴
		
	}
	static void roll(int op) {
		if(op==0) {
			up();
		}
		else if(op==1) {
			right();
		}
		else if(op==2) {
			down();
		}
		else if(op==3){
			left();
		}

		
	}
	
	static void up() {
		if(getx-1<0) {
			index=2;
			down();
		}
		else {
			int a=dice[0][1];
			int b=dice[1][1];
			int c=dice[2][1];
			int d=dice[3][1];
			
			dice[0][1]=b;
			dice[1][1]=c;
			dice[2][1]=d;
			dice[3][1]=a;
			getx=getx-1;
		}
	}
	static void right() {
		if(gety+1>=M) {
			index=3;
			left();
		}
		else {
			int a=dice[1][0];
			int b=dice[1][1];
			int c=dice[1][2];
			int d=dice[3][1];
			
			dice[1][0]=d;
			dice[1][1]=a;
			dice[1][2]=b;
			dice[3][1]=c;
			gety=gety+1;
		}
		
	}
	static void down() {
		if(getx+1>=N) {
			index=0;
			up();
		}
		else {
			int a=dice[0][1];
			int b=dice[1][1];
			int c=dice[2][1];
			int d=dice[3][1];
			
			dice[0][1]=d;
			dice[1][1]=a;
			dice[2][1]=b;
			dice[3][1]=c;	
			getx=getx+1;
		}
		
	}
	static void left() {
		if(gety-1<0) {
			index=1;
			right();
		}
		else {
			int a=dice[1][0];
			int b=dice[1][1];
			int c=dice[1][2];
			int d=dice[3][1];
			
			dice[1][0]=b;
			dice[1][1]=c;
			dice[1][2]=d;
			dice[3][1]=a;
			gety=gety-1;
		}
		
	}


}
