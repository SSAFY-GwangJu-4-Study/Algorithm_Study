import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991_송해찬 {

	// 루트 노드 선언
	static Node head = new Node('A', null, null);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// root, left, right 순으로 들어옴, char로 받기
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insertNode(head, root, left, right);
		}
		
		
		preOrder(head);
		System.out.println();
		inOrder(head); 
		System.out.println();
		postOrder(head);
		System.out.println();
		
	}
	
	static class Node{
		char value;
		Node left;
		Node right;

		public Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	public static void insertNode(Node temp, char root, char left, char right) {
		
		// 루트 노드인 경우
		if(temp.value == root) {
			// 루트 노드가 갖고 있는 왼쪽/오른쪽 노드가 
			// . 이면 null, 문자인 경우 노드를 temp에 저장
			temp.left = (left == '.' ? null : new Node(left, null, null));
			temp.right = (right == '.' ? null : new Node(right, null, null));
		}
		// 루트 노드가 아닌 경우
		else {
			// temp가 갖고있는 왼쪽/오른쪽 노드가 
			// null이 아니면 왼쪽/오른쪽 노드 생성
			if(temp.left !=null) insertNode(temp.left, root, left, right);
			if(temp.right !=null) insertNode(temp.right, root, left, right);
		}
	}
	
	// 전위 순회 (루트 → 왼쪽 → 오른쪽 순)
	public static void preOrder(Node node) {
		if(node == null) return;
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	// 중위 순회 (왼쪽 → 루트 → 오른쪽 순)
	public static void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
	}
	
	// 후위 순회 (왼쪽 → 오른쪽 → 루트 순)
	public static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}
}
