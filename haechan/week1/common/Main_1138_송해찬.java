import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1138_송해찬 {
	static int[] arr;
	static List<Integer> ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		// 위치 정보 배열 받기
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Arrays.toString(arr));
		
		// 사람 배열에 인덱스로 넣기
		ans = new ArrayList<>();
		for(int i=N-1; i>=0; i--) {
			ans.add(arr[i], i+1);
		}
		
		for(int num : ans) {
			System.out.printf("%d ", num);
		}
	}
}
