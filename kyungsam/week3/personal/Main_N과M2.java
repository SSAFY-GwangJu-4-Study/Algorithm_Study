import java.util.Scanner;

public class Main_N과M2 {
	static int N;
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		int M= sc.nextInt();
		int[] arr = new int[N+1];
		nums = new int[M+1];
		for(int i=1;i<=N;i++) {
			arr[i]=i;
		}
		boolean[] visited = new boolean[arr.length];
		
		comb(arr,visited,0,M);
	}
	private static void comb(int[]arr, boolean[] visited,int cnt,int r) {
		if(r==0) {
			for(int i=0;i<N;i++) {
				if(visited[i]==true) {
					System.out.print(arr[i]+1+" ");
				}
			}
			System.out.println();
			return;
		}
		if(cnt==N) {
			return;
		}
			visited[cnt]= true;
			comb(arr,visited,cnt+1,r-1); //선택하는 경우
			visited[cnt]=false; //선택하지 않는 경우
			comb(arr, visited, cnt+1, r);
	}
}
