import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * BOJ 1241 머리 톡톡
 * 이중 for문은 시간초과 => 약수 구하는 방법에서 가지치기 해야 함
 * (실수) 두 번 더해지는 경우를 생각 못함
 * @author kjh
 *
 */
public class Main_1241_김정효 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] data = new int[1000001];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			data[arr[i]]++;	// 각 숫자의 개수 세기
		}
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = 0;
			// 약수의 성질을 이용하여 앞의 약수만 구해서 뒤의 약수는 곱셈으로 구해줌
			// 예) 10의 약수 = {1, 2, 5, 10}
			// 1*10 = 2*5 = 10
			for (int j = 1; j*j <= arr[i]; j++) {
				if (arr[i] % j == 0) {
					sum += data[j];
					// 예) 9 = 1*9 = 3*3 에서
					// 3이 두 번 더해지는 걸 걸러줌
					if (arr[i] / j != j) {
						sum += data[arr[i]/j];
					}
				}
			}
			// 자기자신 하나 빼줌
			System.out.println(sum-1);
		}
	}

}
