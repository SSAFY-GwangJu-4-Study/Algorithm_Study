import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12931_두배더하기 {
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		arr = new int[N];
		boolean flag;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		while(!isDone()) {		
			for (int i = 0; i < N; i++) {//1차 홀수 거르기
				if(arr[i]%2 == 1 || arr[i] == 1) {
					arr[i] = arr[i]-1;
					cnt++;
				}
			}
			
			flag = false;
			
			for (int i = 0; i < N; i++) {
				if(arr[i] >= 2 && arr[i]%2 == 0) {
					flag = true;
					arr[i] = arr[i]/2;
				}
			}
			if(flag == true) cnt++;
			
		}
		
		for (int i = 0; i < N; i++) {//마무리 1 지워주기
			if(arr[i] == 1) {
				arr[i] = arr[i]-1;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	public static boolean isDone() {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != 1 && arr[i] != 0) return false;
		}
		return true;
	}

}
