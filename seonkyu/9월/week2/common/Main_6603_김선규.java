import java.io.IOException;
import java.util.Scanner;

public class Main_6603_김선규 {
	
	static int testcase = 1;
	static int[] ans, arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Scanner sc = new Scanner(System.in);

		while (testcase != 0) {
			testcase = sc.nextInt();
			arr = new int[testcase];
			for (int i = 0; i < testcase; i++) {
				

				arr[i] = sc.nextInt();
			}
			
			ans = new int[6];
			visited = new boolean[testcase];
			perm(0, 0);
			System.out.println();
		}

	}

	public static void perm(int idx, int cnt) {
		if(idx == ans.length) {
			for(int i : ans)
				System.out.print(i+" ");
			System.out.println();
			
			return;
		}

		for(int i=cnt; i<testcase; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			ans[idx] = arr[i];
			perm(idx+1, i+1);
			visited[i] = false;
		}

	}

}
