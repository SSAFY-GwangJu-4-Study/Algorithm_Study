import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main_1406_최지성 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] str = br.readLine().toCharArray();
		LinkedList<Character> list = new LinkedList<>();
		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);
		}

		int n = Integer.parseInt(br.readLine());

		ListIterator<Character> iter = list.listIterator(list.size());
		for (int i = 0; i < n; i++) {
			String line = br.readLine();

			switch (line.charAt(0)) {
			case 'L':
				if (iter.hasPrevious())
					iter.previous();
				break;
			case 'D':
				if (iter.hasNext())
					iter.next();
				break;
			case 'B':
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();// 삭제
				}
				break;
			case 'P':
				char c = line.charAt(2);
				iter.add(c);
				break;
			}
		}

		for (char c : list)
			bw.write(c);

		bw.flush();
		br.close();
		bw.close();
	}
}

//class MyLinkedList {
//	MyNode head;
//	MyNode now;
//
//	public MyLinkedList() {
//
//	}
//
//	public void add(MyNode node) {
//		if (head == null) {
//
//		}
//	}
//
//	public void insert(MyNode node) {
//		now.prev.next = node;
//		node.prev = now.prev;
//		node.next = now;
//		now.prev = node;
//	}
//
//	public void remove() {
//		now.prev.next = now.next;
//		now = now.prev;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//
//		MyNode n = head;
//		while (n != null) {
//			sb.append(n.c + " ");
//			n = n.next;
//		}
//
//		return sb.toString();
//	}
//}
//
//class MyNode {
//	char c;
//	MyNode next;
//	MyNode prev;
//
//	public MyNode(char c) {
//		this.c = c;
//	}
