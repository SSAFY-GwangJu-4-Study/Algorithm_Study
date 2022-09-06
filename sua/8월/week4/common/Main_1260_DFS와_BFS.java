import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와_BFS {
	public static int n, m, v;
	public static Node[] node;
	public static Queue<Node> queue;
	public static boolean[] visited;
	public static StringBuilder sb, sb2;
	public static class Node {
		int num;
		List<Integer> child;
		Node(int num){
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		sb2 = new StringBuilder();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());// 탐색 시작 정점
		node = new Node[n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 0; i < n+1; i++) {
			node[i] = new Node(i);
			node[i].child = new ArrayList<Integer>();
		}
		
		queue = new ArrayDeque<Node>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			node[a].child.add(b);
			node[b].child.add(a);
		}
		
		for(int i = 0; i < n+1; i++) {
			Collections.sort(node[i].child);		
		}

		dfs(v);	
		System.out.println(sb);
		
		
		for (int i = 0; i < n+1; i++) {
			visited[i] = false;
		}
		
		queue.add(node[v]);
		visited[v] = true;
		
		bfs();
		System.out.println(sb2);
	}

	public static void dfs(int a) {
		visited[a] = true;
		sb.append(a + " ");
		if (node[a].child.isEmpty())
			return;

		for (int i = 0; i < node[a].child.size(); i++) {
			if (!visited[node[a].child.get(i)]) {
				dfs(node[a].child.get(i));		
			}
		}

	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Node no = queue.poll();
			sb2.append(no.num + " ");
			
			for(int i = 0; i < no.child.size(); i++) {
				if(!visited[no.child.get(i)]) {
					visited[no.child.get(i)] = true;
					queue.offer(node[no.child.get(i)]);
				}
			}
		}
	}
}