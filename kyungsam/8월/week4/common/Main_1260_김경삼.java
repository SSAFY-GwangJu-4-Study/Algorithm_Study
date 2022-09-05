import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_김경삼 {
	static int N,M;
	static int[][] adjMatrix;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		adjMatrix= new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = adjMatrix[from][to]=1;
		}
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		bfs(V);
	}
	
	private static void dfs(int cur) {
		visited[cur]=true;
		System.out.print(cur+" ");
		for(int i=1;i<=N;i++) {
			if(!visited[i]&&adjMatrix[cur][i]!=0) {
				dfs(i);
			}
		}
	}
	
	private static void bfs(int cur) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		visited[cur]= true;
		queue.offer(cur);
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			System.out.print(tmp+" ");
			for(int i=1;i<=N;i++) {
				if(!visited[i]&&adjMatrix[tmp][i]!=0) {
					visited[i]=true;
					queue.offer(i);
				}
			}
		}
		
	}
}
