import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_14620_꽃길 {
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int map[][];
	static ArrayList<Node> nodelist;
	static Node picknode[];
	static int count;
	static int min=Integer.MAX_VALUE;
	static int del[][]= {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		nodelist=new ArrayList<Node>();
		picknode=new Node[3];
		
		for(int i=0;i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(i>=1 && i<=N-2 && j>=1 && j<=N-2) {
					nodelist.add(new Node(i,j));
				}
				
			}
		}
		comb(0,0);
		System.out.println(min);

	}
	
	static void comb(int cnt, int start) {
		int cost=0;
		if(cnt==3) {
			if(die()==false) {//안죽으면
				for(int i=0; i<3; i++) {
					cost=cost+map[picknode[i].x][picknode[i].y];
					for(int j=0; j<4; j++) {
						cost=cost+map[picknode[i].x+del[j][0]][picknode[i].y+del[j][1]];
					}
				}
				min=Math.min(cost, min);
			}
			
			return;
		}
		
		for(int i=start; i<nodelist.size(); i++) {
			picknode[cnt]=nodelist.get(i);
			comb(cnt+1, i+1);
		}
	}
	
	static boolean die() {
		int l1=Math.abs(picknode[0].x-picknode[1].x)+Math.abs(picknode[0].y-picknode[1].y);
		int l2=Math.abs(picknode[0].x-picknode[2].x)+Math.abs(picknode[0].y-picknode[2].y);
		int l3=Math.abs(picknode[1].x-picknode[2].x)+Math.abs(picknode[1].y-picknode[2].y);
		if(l1<=2 || l2<=2 || l3<=2) {
			return true;
		}
		return false;
	}
}
