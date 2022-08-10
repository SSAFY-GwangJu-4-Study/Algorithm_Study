import java.util.Scanner;

public class Main_15658_윤명지 {
	
	static int N;
	static int arr[];
	static int arr_x[];
	static int re_max = Integer.MIN_VALUE;
	static int re_min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		arr_x = new int[4];
		for(int i=0; i<4; i++) {
			arr_x[i] = sc.nextInt();
		}

		function(1, arr[0]);
		System.out.println(re_max);
		System.out.println(re_min);
	}
	
	public static void function(int x, int result) {
		if(x >= N) {
			re_max = Math.max(re_max,  result);
			re_min = Math.min(re_min, result);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(arr_x[i] == 0) {
				continue;
			}
			arr_x[i]--;
			switch(i) {
			case 0:
				function(x+1,result + arr[x]);
				break;
			case 1:
				function(x+1,result - arr[x]);
				break;
			case 2:
				function(x+1,result * arr[x]);
				break;
			case 3:
				function(x+1,result / arr[x]);
				break;
			}
			arr_x[i]++;
			
		}
	}

}
