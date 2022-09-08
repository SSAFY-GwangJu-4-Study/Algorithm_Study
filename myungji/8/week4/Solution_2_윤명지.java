import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution_2_윤명지 {
	
	static int N;
	static int[] numbers,input;
	static boolean[] isSelected;
	
	static int[][] mon;
	static int[][] go;
	static int hx, hy;
	static ArrayList<Integer> res;
	static int totalcnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int A = sc.nextInt();
			int[][] arr = new int[A][A];
			res = new ArrayList<>();
			hx = 0;
			hy = 0;
			totalcnt = 0;
			
			mon = new int[5][2];
			go = new int[5][2];
			
			int cnt = 0;
			
			for(int i=0; i<A; i++) {
				for(int j=0; j<A; j++) {
					arr[i][j] = sc.nextInt();
					if(arr[i][j] > 0) {
						mon[arr[i][j]][0] = i;
						mon[arr[i][j]][1] = j;
						cnt++;
					} else if(arr[i][j]<0) {
						go[Math.abs(arr[i][j])][0] = i;
						go[Math.abs(arr[i][j])][1] = j;
					}
				}
			}
			
			N = cnt * 2;
			
			input = new int[N];
			numbers = new int[N];
			isSelected = new boolean[N];
			
			for(int i=0; i<cnt; i++) {
				input[i] = i+1;
			}
			
			for(int i=cnt; i<N; i++) {
				input[i] = -(i-cnt+1);
			}
			
			perm(0);
			int min = Integer.MAX_VALUE;
			for(int i : res) {
				min = Math.min(i, min);
			}
			System.out.println("#"+tc+" "+min);
			
		}

	}
	
	private static void perm(int cnt){ 
		
		if(cnt==N) {
			System.out.println(totalcnt);
			HashSet<Integer> set = new HashSet<Integer>();
			int l = 0;
			hx = 0;
			hy = 0;
			for(int i=0; i<N; i++) {
				if(numbers[i]>0) {
					set.add(numbers[i]);
					l = l+Math.abs(hx-mon[numbers[i]][0])+Math.abs(hy-mon[numbers[i]][1]);
					hx = mon[numbers[i]][0];
					hy = mon[numbers[i]][1];
				} else if(numbers[i]<0) {
					if(set.contains(Math.abs(numbers[i])) != true) {
						return;
					} else {
						l = l+Math.abs(hx-go[Math.abs(numbers[i])][0])+Math.abs(hy-go[Math.abs(numbers[i])][1]);
						hx = go[Math.abs(numbers[i])][0];
						hy = go[Math.abs(numbers[i])][1];
					}
				}
			}
			totalcnt++;
			
			res.add(l);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}

}
