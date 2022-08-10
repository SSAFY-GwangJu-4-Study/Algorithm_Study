import java.util.Arrays;
import java.util.Scanner;

public class Main_1931_최지성 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] arr = new int[N][2];	// 시작 시간, 끝난 시간
		int totalCnt = 0;
		
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, (int[] arr1, int[] arr2)->{
			if(arr1[1] == arr2[1])
				return arr1[0] - arr2[0];
			
			return arr1[1] - arr2[1];
		});

		int now = -1;
		
		for (int i = 0; i < N; i++) {
			if(arr[i][0] >= now) {
				totalCnt++;
				now = arr[i][1];
			}
		}
		
		System.out.println(totalCnt);
	}

}
