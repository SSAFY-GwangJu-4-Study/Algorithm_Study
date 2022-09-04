import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1931_윤명지 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		int cnt = 0;
		int fin_time = 0;
		
		
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1] - o2[1];
			}
			
		});
		
//		for(int i=0; i<N; i++) {
//			System.out.println(arr[i][0] + " " + arr[i][1]);
//		}
		
		for(int i=0; i<N; i++) {
			if(fin_time<=arr[i][0]) {
				cnt = cnt + 1;
				fin_time = arr[i][1];
			}
		}
		
		System.out.println(cnt);
	}

}
