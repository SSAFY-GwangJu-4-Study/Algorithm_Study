import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_김경삼 {
	static int N;
	static boolean[] visited;
	static int[] parents;
	static List<Integer>[] tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];
		parents = new int[N + 1];
		tree = new LinkedList[N+1];
		for(int i=0;i<=N;i++) {
			tree[i]= new LinkedList<>();
		}
		for(int i=1;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			int prev = Integer.valueOf(st.nextToken());
			int next = Integer.valueOf(st.nextToken());

			tree[prev].add(next);
			tree[next].add(prev);
		}
		
		bfs();
		for(int i=2;i<=N;i++) {
			System.out.println(parents[i]);
		}
	}

	private static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		que.offer(1);
		parents[1]=1;
		
		while(!que.isEmpty()) {
			int cur = que.poll();
			
			for(int child:tree[cur]) {
				if(parents[child]!=0) continue;
				parents[child] =cur;
				que.add(child);
			}
		}
	}
}
