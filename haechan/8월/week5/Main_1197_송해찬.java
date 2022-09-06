import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1197_송해찬 {
	
	static int[] parents;
	static int V, E;
	static Edge[] edgeList;
	
	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}
		// 가중치 오름차순 정렬
		Arrays.sort(edgeList);
		
		// parents 관계 생성
		make();
		
		// 가중치 값 100만 누적되면 int 범위 초과해서 long 사용
		int cnt = 0;
		long result = 0; 
		for(Edge edge : edgeList) {
			// union 가능하면 (부모노드 다르면)
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				// V-1개 되면 멈춤
				if(++cnt == V-1) break;
			}
		}
		System.out.println(result);
	}
	
	static void make() {
		parents = new int[V];
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
}