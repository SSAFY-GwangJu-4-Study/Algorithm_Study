import java.util.Arrays;
import java.util.Scanner;

public class Main_1138_김경삼 {
	static int[] arr;
	static int[] sortArr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr= new int[N+1]; //arr에 자신보다 큰사람 수 저장
		arr[0]=99;
		sortArr= new int[N+1]; // sortArr에 for문 돌면서 키 순서대로 저장
		for(int i=1;i<=N;i++) {
			arr[i]= sc.nextInt();
		}
		for(int i=1;i<=N;i++) {
			int count= arr[i]; // 키가 i인 사람보다 왼쪽 큰 사람 수 ==count
			for(int j=1;j<=N;j++) {				
				if(count==0&&sortArr[j]==0) { // 왼쪽사람 수만큼 이동한 자리에서 sortArr 자리가 비어있다면. 키 i가 사람의 자리
					sortArr[j]=i;
					break;
				}else if(sortArr[j]==0) { //비어있는 자리만큼 count 감소하면서 찾기(자리가 차있으면 count 감소 안시킴)
					count--;
				}
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.print(sortArr[i]+" ");
		}
	}
}
