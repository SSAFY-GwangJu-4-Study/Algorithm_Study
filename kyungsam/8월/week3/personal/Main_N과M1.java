import java.util.Arrays;
import java.util.Scanner;

public class Main_N과M1 {
	static int N,M;
	static int[] nums;
	static boolean[] isSelected;
	public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
		N =sc.nextInt();
		M =sc.nextInt();
		nums = new int[M];
		isSelected = new boolean[N+1];
		perm(0);
	}
	
	private static void perm(int cnt) {
		if(cnt==M) {
			for(int i=0;i<nums.length;i++) {
				System.out.print(nums[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(isSelected[i]) continue;
		isSelected[i]= true;
			nums[cnt]=i;
			perm(cnt+1);
		isSelected[i]= false;
		}
	}
}
