import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 나무 출제자의 모든 문제 풀기
 * d1 나머지의 합 문제
 * @author Kyungsam Kim
 *
 */
public class swea_14505_김경삼 {
	static int N,ans;
	static int[]arr,tmp;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		int T =Integer.parseInt(br.readLine().trim());
		for(int tc=1;tc<=T;tc++) {
			N =Integer.parseInt(br.readLine());
			arr = new int[N];
			ans=0;
			visited= new boolean[N];
			tmp=new int[2];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			perm(0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void perm(int cnt) {
		if(cnt==2) {
//			System.out.println(Arrays.toString(tmp));
			ans+=tmp[0]%tmp[1];
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				tmp[cnt]=arr[i];
				perm(cnt+1);
				visited[i]=false;
			}
		}
	}
}
