import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11725_송해찬 {

	static int n;
	static ArrayList<ArrayList<Integer>> adj;
	static Queue<Integer> queue;
	static int[] parent;
	static boolean[] checked;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		parent = new int[n+1];
		checked = new boolean[n+1];
		adj = new ArrayList<>();
		queue = new LinkedList<>();
		
		// 트리 만들기 위해 리스트 n개 준비, 0 안씀
		for (int i=0; i<=n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for(int i=0; i<n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adj.get(n1).add(n2); // 누가 부모인지 모르는 상태
			adj.get(n2).add(n1); // 인접노드끼리 일단 담기 (1,6) (4,1) ...
		}
		
		checked[1] = true; // 1번 루트노드 시작
		queue.offer(1);
		
		// bfs를 위해 큐에 노드 저장 
		while(!queue.isEmpty()) {
			// 방문할 노드 now 꺼내오기
			int now = queue.poll();
			// 인접노드 1개 or 2개 → adj.get(now).size()까지 반복
			for(int i=0; i<adj.get(now).size(); i++) {
				// 인접노드 n 구하기
				int n = adj.get(now).get(i);
				// n이 아직 사용안되었다면,
				if(!checked[n]) {
					// 지금 방문한 now가 부모노드가 맞음, 저장 (1번 루트노드부터 큐를 이용해 bfs 순서로 진행되므로)
					parent[n] = now;
					// 자식노드가 부모노드가 되지않도록 방문처리
					checked[n] = true;
					// 다음 방문을 위해 자식노드 큐에 저장
					queue.offer(n);
				}
			}
		}
		
		// 문제 목적인 부모노드 정보를 출력
		for(int i=2; i<=n; i++) {
			System.out.println(parent[i]);
		}
	}

}
