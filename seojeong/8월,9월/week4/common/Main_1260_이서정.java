import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_이서정 {

	static ArrayList<Integer> list[];
	static int N,M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(sb.nextToken());
		M = Integer.parseInt(sb.nextToken());
		int V = Integer.parseInt(sb.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i]=new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			sb = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(sb.nextToken());
			int to = Integer.parseInt(sb.nextToken());
			list[to].add(from);
			list[from].add(to);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		boolean[] visit=new boolean[N+1];
		dfs(V,visit);
		System.out.println();
		visit=new boolean[N+1];
		bfs(V,visit);
		
		
	}
	
	static void dfs(int start, boolean[] visit) {
		System.out.print(start+" ");
		visit[start]=true;
		
		for(int i=0; i<list[start].size(); i++) {
			if(visit[list[start].get(i)]==false) {
				dfs(list[start].get(i),visit);
				}
			}
		
		return;
	}
	
	static void bfs(int start,boolean[] visit) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visit[start]=true;
		
		while(!queue.isEmpty()) {
			int c=queue.poll();
			System.out.print(c+" ");
			for(int i=0; i<list[c].size(); i++) {
				if(visit[list[c].get(i)]==false) {
					visit[list[c].get(i)]=true;
					queue.offer(list[c].get(i));
				}
			}

		}
		
	}


}
