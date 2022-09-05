import java.util.Arrays;
import java.util.Scanner;

public class Main_N과M4 {
	static int N,M;
	static int[] arr;
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	arr = new int[N+1];
	int[] nums = new int[M];
	for(int i=0;i<N;i++){
		arr[i] = i+1;
	}
	boolean[] visited = new boolean[N];
	comb(0,visited,0,nums);
	}
	
	private static void comb(int cnt,boolean[] visited,int r,int[] nums) {
		//기저 조건
		if(r == M) {
			
			return;
		}
		
		
		if(cnt==N) {
			return;
		}
		
			visited[cnt]= true;
			comb(cnt+1,visited,r+1,nums);
			visited[cnt]= false;
			comb(cnt+1,visited,r,nums);
			
	}
}
