import java.util.ArrayList;
import java.util.Scanner;

public class Main_14889_윤명지 {
	
	static int N, R;
	static int[] number, input;
	static int[] number2, number3;
	static int[][] arr;
	static boolean[] isSelected, isSelected2;
	static ArrayList<Integer> number_li;
	
	static int l, l2;
	
	static int min;
	
	static int[] num;
	
	
	public static void perm(int cnt) {
		if(cnt == 2) {
			l = l + arr[number2[0]][number2[1]];
			return;
		}
		for(int i=0; i<R; i++) {
			if(isSelected[i]) continue;
			number2[cnt] = number[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	
	public static void perm2(int cnt) {
		if(cnt == 2) {
			l2 = l2 + arr[number3[0]][number3[1]];
			return;
		}
		for(int i=0; i<R; i++) {
			if(isSelected2[i]) continue;
			number3[cnt] = num[i];
			isSelected2[i] = true;
			perm2(cnt+1);
			isSelected2[i] = false;
		}
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == R) {
			l = 0;
			l2 = 0;
			
			perm(0);
			number_li = new ArrayList<Integer>();
			for(int i=0; i<R; i++) {
				number_li.add(number[i]);
			}
			int a = 0;
			for(int i=0; i<N; i++) {
				if(number_li.contains(i)) {
					continue;
				} else {
					num[a] = i;
					a++;
				}
			}
			perm2(0);
			
			min = Math.min(min, Math.abs(l-l2));
			return;
		}
		
		for(int i=start; i<N; i++) {
			number[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		min = Integer.MAX_VALUE;
		
		N = sc.nextInt();
		R = N/2;
		
		input = new int[N];
		number = new int[R];
		number2 = new int[R];
		number3 = new int[R];
		isSelected = new boolean[R];
		isSelected2 = new boolean[R];
		
		num = new int[R];
		
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			input[i] = i;
		}
		
		comb(0,0);
		
		System.out.println(min);

	}

}
