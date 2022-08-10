import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_11650_김경삼{

	public static void main(String[] args) throws NumberFormatException, IOException {
		//2차원 배열 받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1]= Integer.parseInt(st.nextToken());
		}
		
		
		//sorting 구현하기. Arrays.sort의 Comparator 재정의
		Arrays.sort(arr,new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) { //x가 같은 경우 y비교해서 오름차순  정렬
					return o1[1]-o2[1]; 
				}
				//기본적으로는 x값으로 오름차순 정렬
				else {
					return o1[0]-o2[0];
				}
			}
		});
		for(int i=0;i<N;i++) {
			StringBuilder sb= new StringBuilder();
			sb.append(arr[i][0]).append(" ").append(arr[i][1]);
			System.out.println(sb.toString());
		}
	}

}
