import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_1138_윤명지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		ArrayList<Integer> result = new ArrayList<>();
		//int[] result = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=N; i>=1; i--) {
			result.add(arr[i],i);
		}
		
		
		
		for(int re : result) {
			System.out.print(re + " ");
		}

	}

}
