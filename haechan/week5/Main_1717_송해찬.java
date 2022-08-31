import java.io.*;
import java.util.StringTokenizer;

public class Main_1717_송해찬 {
	
	static int n, m;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		make();
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			// 0:합집합, 1:같은집합인지 확인
			int k = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(k==0) {
				union(a, b);
			}
			else if(k==1) {
				if(find(a) == find(b)) {
					sb.append("YES").append("\n");
				}
				else {
					sb.append("NO").append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	static void make() {
		// 모든 원소를 자신을 대표자로 만듬
		parents = new int[n+1];
		for(int i=0; i<n+1; i++) {
			parents[i] = i;
		}
	}
	
	// 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		// 이미 같은 집합이기 때문에 합치지 않음
		if(aRoot == bRoot) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
	}
	
	// a가 속한 집합의 대표자 찾기
	static int find(int a) {
		// 자신이 대표자
		if(a == parents[a]) return a;
		// 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
		return parents[a] = find(parents[a]);
	}
	
}