import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15658_송해찬 {
	
	static int n;
	static int[] arr;
	static int[] opNum;
	static List<Integer> opInput;
	static int[] opPerm;
	static boolean[] isSelected;
	static int maxValue;
	static int minValue;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// n 받고 n개의 숫자 받기
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 4개 연산자들의 갯수 받기
		opNum = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			opNum[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자들 갯수로 연산자 순열 만들기, 갯수 가변적이어서 arraylist 사용
		opInput = new ArrayList<Integer>();  // 연산자 총 N개의 숫자 배열
		opPerm = new int[n-1];   // R개 뽑은 순열
		for(int i=0; i<4; i++) {
			for(int j=0; j<opNum[i]; j++) {
				opInput.add(i);
			}
		}
		isSelected = new boolean[opInput.size()]; // 각 위치 사용중인지 확인
//		System.out.println(opInput.toString());
		
		
		calc(0);
		System.out.println(maxValue);
		System.out.println(minValue);
	}
	
	private static void calc(int cnt) {
		// cnt: 직전까지 뽑은 순열에 포함된 수의 개수, cnt+1번째 해당하는 순열에 포함될 수 뽑기
		if(cnt==n-1) {  // 들어갈 수 있는 연산자 개수 n-1개
			// 연산자 계산해서 최대, 최소 확인
//			System.out.println(Arrays.toString(opPerm));
			getValue(opPerm);
			return;
		}
		
		// 가능한 모든 수에 대한 시도
		for(int i=0; i<opInput.size(); i++) {
			// 시도하는 수가 선택되었는지 확인
			if(isSelected[i]) continue;
			// 선택되지 않았다면 수를 사용
			// 순열 numbers[cnt] = 인풋 input[i];
			opPerm[cnt] = opInput.get(i);
			isSelected[i] = true;
			// 다음 수 뽑으러 가기
			calc(cnt+1);
			// 사용했던 수 되돌려 놓기
			isSelected[i] = false;
		}
	}

	private static void getValue(int[] opPermArr) {
		int res = arr[0];  // res에 첫 값 넣기
		for(int i=0; i<opPermArr.length; i++) {  // +,-,*,/ 조건 나눠서 연산 횟수만큼 실행
			if(opPermArr[i] == 0) {
				res += arr[i+1];
			}
			else if(opPermArr[i] == 1) {
				res -= arr[i+1];
			}
			else if(opPermArr[i] == 2) {
				res *= arr[i+1];
			}
			else if(opPermArr[i] == 3) {
				res /= arr[i+1];
			}
		}
		maxValue = Math.max(maxValue, res);  // res 최댓값인지 확인
		minValue = Math.min(minValue, res);  // res 최솟값인지 확인
	}
}
