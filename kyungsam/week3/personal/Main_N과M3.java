import java.util.Arrays;
import java.util.Scanner;

public class Main_N과M3 {
	static int N,M;
	static int[] nums;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		M= sc.nextInt();
		nums = new int[M];
		sb = new StringBuilder();
		perm(0);
		System.out.println(sb);
	}
	
	private static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0;i<nums.length;i++) {
				sb.append(nums[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=N;i++) {
			
			nums[cnt]= i;
			perm(cnt+1);
		}
	}
}
