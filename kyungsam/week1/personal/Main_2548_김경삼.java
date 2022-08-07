import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2548_김경삼 {
	static int N ,ans;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int Min=Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			int tmp = arr[i];
			int sum = 0;
			for(int j=0;j<N;j++) {
				sum+=Math.abs(tmp-arr[j]);
			}
			int ansArr[]= new int[N];
			if(Min>sum) {
				ans=i;
				Min = sum;
			}
		}
		System.out.println(arr[ans]);
		//그냥 중앙 값 찾는 문제라고도 한다.
	}
}
