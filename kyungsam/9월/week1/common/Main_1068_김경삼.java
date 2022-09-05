import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1068 트리 문제
 * @author 김경삼
 *
 */
public class Main_1068_김경삼 {
	
	static ArrayList<Integer>[] tree;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		int n= Integer.parseInt(br.readLine());
		tree= new ArrayList[n];
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			tree[i]=new ArrayList<Integer>();
		}
		int root= 0;
		for(int i=0;i<n;i++) {
			int cur = Integer.parseInt(st.nextToken());
			int curIdx= i;
			if(cur==-1) {
				root=curIdx;
				continue;
			}else {
				tree[cur].add(curIdx);
			}
		}
		int deleteNode= Integer.parseInt(br.readLine());
//		System.out.println(Arrays.toString(tree));
		delete(deleteNode);
		
		int tmp=tree.length;
		for(int i=0;i<tree.length;i++) {
			if(tree[i].size()==0)tmp--;
		}
		if(tmp ==1) {
			System.out.println(1);
			return;
		}
//		System.out.println(Arrays.toString(tree));
		dfs(n,root);
		System.out.println(cnt-1);
	}
	
	private static void dfs(int n, int start) {
			if(tree[start].size()==0) {
				cnt++;
				return;
			}
			
			for(int i=0;i<tree[start].size();i++) {
				dfs(n,tree[start].get(i));
			}
		}
	private static void delete(int num) {
		int size=tree[num].size();
		for(int i=0;i<size;i++) {
			delete(tree[num].get(i));
		}
		tree[num].clear();
	}
	}
	
