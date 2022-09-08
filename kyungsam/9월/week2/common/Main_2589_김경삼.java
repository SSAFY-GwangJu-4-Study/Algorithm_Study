import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 보물섬 문제 골드5
 * @author Kyungsam Kim
 *
 */

public class Main_2589_김경삼 {
	static class Node{
		int r,c;
		int time;
		public Node(int r,int c,int time) {
			this.r = r;
			this.c= c;
			this.time =time;
		}
		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", time=" + time + "]";
		}
	}
	static int[] deltaR= {-1,1,0,0};
	static int[] deltaC= {0,0,-1,1};
	static char[][]map;
	static boolean[][] visited;
	static int ans,R,C;
	public static void main(String[] args) throws IOException {
	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = null;
	
	st= new StringTokenizer(br.readLine());
	R = Integer.parseInt(st.nextToken());
	C = Integer.parseInt(st.nextToken());
	map = new char[R][C];
	ans=0;
	for(int i=0;i<R;i++) {
		char[] line = br.readLine().toCharArray();
		for(int j=0;j<C;j++) {
			map[i][j]= line[j];
		}
	}
//	print();
	for(int i=0;i<R;i++) {
		for(int j=0;j<C;j++){
			visited =new boolean[R][C];
			if(map[i][j]=='W')visited[i][j]=true;
			if(visited[i][j])continue;
			visited[i][j]=true;
			bfs(i,j);
		}
	}
	System.out.println(ans);
	
	} //메인
	
	private static void bfs(int r,int c) {
		Node node = new Node(r,c,0);
		Queue<Node> queue = new LinkedList<>();
		queue.offer(node);
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
//			System.out.println(cur);
			ans=Math.max(ans, cur.time);
//			System.out.println(tmpAns);
			
			for(int d=0;d<4;d++) {
				int nr = cur.r+deltaR[d];
				int nc = cur.c+deltaC[d];
				if(nr<0||nc<0||nr>=R||nc>=C)continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc]=='L') {
					visited[nr][nc]=true;
					Node tmp= new Node(nr,nc,cur.time+1);
					queue.offer(tmp);
//					System.out.println(tmp);
				}
			}
		}
		
	}
	
	private static void print() {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}//클래스
