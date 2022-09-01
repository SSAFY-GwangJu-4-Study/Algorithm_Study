import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//하는중
public class Main_1138_한_줄로_서기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];//자기보다 왼쪽에 "큰 사람이 몇명"있는지 저장하는 배열
		List<Integer> turn = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = n; i >= 1; i--) {//키가 큰 순서대로 넣어주기
			turn.add(arr[i], i);

		}
		
		for(int key : turn) {
			System.out.print(key + " ");
		}
	}

}
