import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13549_숨바꼭질3 {
	static int min = Integer.MAX_VALUE;
	static int N, M;
	static final int MAX =100_000;
	static boolean[] visited;

	public static class Node {
		int x;
		int time;

		public Node(int x, int time) {
			this.x = x;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[100001];
		bfs(N);
		System.out.println(min);
	}

	private static void bfs(int start) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start, 0));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.x] = true;

			if (node.x == M)
				min = Math.min(min, node.time);
			
			if(node.x*2<=MAX&&!visited[node.x*2]) queue.offer(new Node(node.x*2,node.time));
			if(node.x+1<=MAX&&!visited[node.x+1]) queue.offer(new Node(node.x+1,node.time+1));
			if(node.x-1>=0&&!visited[node.x-1]) queue.offer(new Node(node.x-1,node.time+1));
		}
	}
}
