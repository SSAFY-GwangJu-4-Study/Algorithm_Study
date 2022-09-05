import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10974_모든순열 {
	static int N;
	static boolean[] visited;
	static int[] complete;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		N= Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		complete= new int[N];
		perm(0);
	}
	
	private static void perm(int cnt) {
		if(cnt==N) {
			for(int i=0;i<complete.length;i++) {
					System.out.print(complete[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1;i<=N;i++) {
			if(visited[i]) continue;
				complete[cnt]=i;
				visited[i]= true;
				perm(cnt+1);
				visited[i]= false;
		}
	}
}
