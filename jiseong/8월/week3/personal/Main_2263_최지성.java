import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2263_최지성 {
	static int idx; // 휘위 순회의 좌표를 탐색
	static ArrayList<String> in;
	static ArrayList<String> post;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		in = new ArrayList<>();
		post = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			in.add(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			post.add(st.nextToken());
		}

		idx = N - 1;
		Tree_2263 tree = new Tree_2263(makeTree(in));

		preOrder(tree.root);
	}

	public static Node_2263 makeTree(List<String> nodes) {
//		System.out.println(nodes);
//		System.out.print("현재 위치 : " + idx + " " + "찾아야할 값 : " + post.get(idx));

		if (nodes.size() == 0) {
			idx++;
			return null;
		}

		if (nodes.size() == 1)
			return new Node_2263(post.get(idx));

		Node_2263 node = new Node_2263(post.get(idx));
		int now = nodes.indexOf(post.get(idx));
//		System.out.println(" inorder 위치 : " + now);
//		System.out.println();
		
		--idx;
		node.right = makeTree(nodes.subList(now + 1, nodes.size()));
//		System.out.println();
		--idx;
		node.left = makeTree(nodes.subList(0, now));

		return node;
	}

	public static void preOrder(Node_2263 node) {
		System.out.print(node);

		if (node.left != null) {
			preOrder(node.left);
		}

		if (node.right != null) {
			preOrder(node.right);
		}
	}

	static class Tree_2263 {
		public Node_2263 root;

		public Tree_2263(Node_2263 root) {
			this.root = root;
		}
	}

	static class Node_2263 {
		public String value;
		public Node_2263 left;
		public Node_2263 right;

		public Node_2263(String value) {
			this.value = value;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return value + " ";
		}

	}
}
