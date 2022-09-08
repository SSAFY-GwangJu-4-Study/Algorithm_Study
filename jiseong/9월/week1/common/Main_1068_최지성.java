import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1068_최지성 {
	static int N;
	static int cutNode;
	static int root;	// root위치
	static int[] parent;	// input, 부모의 값들이 저장
	static int[] nodeStatus;	// 현재 노드가 가지고 있는 자식의 수를 담는 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		parent = new int[N];
		nodeStatus = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
			
			if(parent[i] == -1) {
				root = i;
				// root노드일 때 -1로 해놓으면 로직에 맞지 않기 때문에 root의 부모가 본인이도록 해놓음
				parent[i] = i;
			}
		}
		cutNode = Integer.parseInt(br.readLine());
		
		// 잘린 노드들은 부모가 -2라고 해놓을 예정
		parent[cutNode] = -2;

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(cutNode);
		
		while (!q.isEmpty()) {
			int point = q.poll();
			
			for (int i = 0; i < N; i++) {
				// 부모가 잘린 노드라면
				if(parent[i] == point) {
					// 해당 노드도 잘라줌
					parent[i] = -2;
					q.offer(i);
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			// 부모가 존재하면
			if(parent[i] > -1) {
				// 부모노드의 자식 개수를 증가시킴
				nodeStatus[parent[i]]++;
			} else {
				// 존재하지 않으면 자식 수 -2(제거됨)으로 변경
				nodeStatus[i] = -2;
			}
		}
		
		// 위에서 root의 부모를 본인으로 해줬으므로 하나를 빼준다
		nodeStatus[root]--;
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			// 자식이 0인 노드들이 leaf노드
			if(nodeStatus[i] == 0) {
				sum++;
			}
		}
		
//		System.out.println(Arrays.toString(parent));
//		System.out.println(Arrays.toString(nodeStatus));
		System.out.println(sum);
	}
}
