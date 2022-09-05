import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14889_김경삼 {
	static int N, totalsum, ans, cnt2 = 0;
	static int[][] map;
	static boolean[] visited;
	static ArrayList<Integer> nums, nums2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ans=Integer.MAX_VALUE;
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(ans);
	}

	private static void comb(int cnt, int start) {
		if(cnt==N/2) {
			nums = new ArrayList<>();
			nums2 = new ArrayList<>();
			int sum=0;
			int sum2=0;
			for(int i=0;i<visited.length;i++) {
				if(visited[i]) {
					nums.add(i);
				}else {
					nums2.add(i);
				}
			}
			for(int i=0;i<nums.size();i++) {
				for(int j=0;j<nums.size();j++) {
					sum+=map[nums.get(i)][nums.get(j)];
				}
			}
			for(int i=0;i<nums.size();i++) {
				for(int j=0;j<nums.size();j++) {
					sum2+=map[nums2.get(i)][nums2.get(j)];
				}
			}
//			System.out.println((nums));
//			System.out.println((nums2));
//			System.out.println("sum:"+sum+"sum2:"+sum2);
			int diff = Math.abs(sum2-sum);
			ans = Math.min(ans,diff);
			return;
		}
		
		
		for(int i=start;i<N;i++) {
			visited[i]=true;
			comb(cnt+1,i+1);
			visited[i]=false;
		}
	}
}
