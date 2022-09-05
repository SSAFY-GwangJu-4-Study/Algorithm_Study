import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 1068 트리 - (미완성)
 * 왜 안될까 왜왜왜?
 * 
 * @author kjh
 *
 */
public class Main_1068_김정효 {
	static int n, start, cnt, node[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		node = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a == -1) start = i;
			node[i] = a;
		}
		
		int r = Integer.parseInt(br.readLine());
		
		if(r==start) {
			System.out.println(cnt);
			return;
		}
		
		remove(r);
		node[r] = -2;
		dfs();
		System.out.println(cnt);
	}

	private static void remove(int r) {
		for (int i = 0; i < n; i++) {
			if(r == node[i]) {
				node[i] = -2;
				remove(i);
			}
		}
		return;
		
	}

	private static void dfs() {
		Stack<Integer> stack = new Stack<>();
		
		stack.add(0);
		
		while(!stack.isEmpty()) {
			boolean visit = false;
			int current = stack.pop();
			
			for (int i = 0; i < n; i++) {
				if (node[i] == current && node[i] != -2) {
					stack.push(i);
					visit = true;
				}
			}
			if(!visit) cnt++;
		}
		
		
		
	}

}
