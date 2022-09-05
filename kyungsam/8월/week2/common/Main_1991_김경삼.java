import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char data;
	Node left;
	Node right;

	Node(char data) {
		this.data = data;
	}
}
class Tree {
	Node root;

	public void createNode(char data, char leftNode, char rightNode) {
		if (root == null) {
			root = new Node(data);

			if (leftNode != '.') {
				root.left = new Node(leftNode);
			}
			if (rightNode != '.') {
				root.right = new Node(rightNode);
			}
		}else {
			searchNode(root,data,leftNode,rightNode);
			}
		}
	public void searchNode(Node root, char data, char leftNode, char rightNode) {
		if(root ==null) {
			return;
		}else if(root.data==data) {
			if(leftNode!='.') {
				root.left = new Node(leftNode);
			}
			if(rightNode!='.') {
				root.right= new Node(rightNode);
			}
		}else {
			searchNode(root.left,data,leftNode,rightNode);
			searchNode(root.right,data,leftNode,rightNode);
		}
	}
	public void preorder(Node root) {
		System.out.print(root.data);
		if(root.left!=null)preorder(root.left);
		if(root.right!=null)preorder(root.right);
	}
	public void inorder(Node root) {
		if(root.left!=null)inorder(root.left);
		System.out.print(root.data);
		if(root.right!=null)inorder(root.right);
	}
	public void postorder(Node root) {
		if(root.left!=null)postorder(root.left);
		if(root.right!=null)postorder(root.right);
		System.out.print(root.data);
	}
	
}
public class Main_1991_김경삼 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Tree tree= new Tree();
		
		for(int i=0;i<N;i++) {
			char[] data;
			data = br.readLine().replaceAll(" ", "").toCharArray();
			tree.createNode(data[0], data[1], data[2]);
		}
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		
	}




}
