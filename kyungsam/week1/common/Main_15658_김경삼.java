import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15658_김경삼 {
	static int N, min,max;
	static int[] arr;
	static int[] opers;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr= new int[N];
		opers =new int[4];
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			opers[i]= Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(opers));
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		oper(1,arr[0]); //sum에 첫번째 숫자 넣고 2번째 값인 1번 index 값과 연산 시작.
		System.out.println(max);
		System.out.println(min);
		
	}
	private static void oper(int index,int sum) {
		//brute force 탐색, 재귀,dfs.
		// 연산 횟수 = N-1번, 첫 자리엔 연산자 개수 모두 합한 만큼 경우의 수, 선택되면 개수 한개 차감.
			if(index==N) { //기저 조건: 수의 개수-1 연산
				max =Math.max(max, sum);
				min =Math.min(min, sum);
				return;
			}
			for(int i=0;i<4;i++) {
				if(opers[i]==0) {
					continue; //해당 인덱스 연산자 다쓴경우.
				}
				opers[i]--;
				
				switch(i) {
				case 0:
					oper(index+1,sum+arr[index]);
					break;
				case 1:
					oper(index+1,sum-arr[index]);
					break;
				case 2:
					oper(index+1,sum*arr[index]);
					break;
				case 3:
					oper(index+1,sum/arr[index]);
					break;
				}
				opers[i]++;
			}
	}

}
