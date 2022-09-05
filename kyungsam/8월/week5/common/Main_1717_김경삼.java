import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 집합의 표현
 * @author 김경삼
 *
 */
public class Main_1717_김경삼 {
	static int V, E,m; // V=n 초기 집합, m= 연산 횟수
	static Edge[] edgeList;
	static int[] parents;
	private static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
			st= new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			make();
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(order ==0) {
					union(a,b);
				}else if(order==1) {
					if(find(a)==find(b)) {
						System.out.println("YES");
					}else {
						System.out.println("NO");
					}
				}
			}
	}

	private static void make() { // 크기가 1인 서로 소 집합 생성
		parents = new int[V+1];

		for (int i = 0; i < V; i++) { // 모든 노드가 자신을 대표자 집합으로 만듦.
			parents[i] = i;
		}
	}

	private static int find(int a) { // a의 대표자 찾기
		if(parents[a]==a) return a;
		
		return parents[a] = find(parents[a]); //우리의 대표자를 나의 부모로 : path compression
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot =find(b);
		
		if(aRoot == bRoot)return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
}
