import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1068_트리 {
	static int cnt, deleteNode;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int root = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		list = new LinkedList[N];
		
		for (int i = 0; i < N; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == -1) {
				root = i;			
			}else list[tmp].add(i);	
		}

		deleteNode = Integer.parseInt(br.readLine());
		
		if(root == deleteNode) System.out.println(0);
		else {
			list[deleteNode].clear();
			dfs(root);
			
			
			System.out.println(cnt);
		}
		

	}
	static void dfs(int a){
		if(list[a].isEmpty()) {
			cnt++;
			return;
		}
		for (int i = 0, n = list[a].size(); i < n; i++) {
			if(list[a].get(i) == deleteNode) continue;
			dfs(list[a].get(i));
		}
		
	}
}
