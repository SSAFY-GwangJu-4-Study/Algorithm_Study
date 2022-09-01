import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Solution_shuffle_matic_김경삼 {
	static int N,min;
	static int[] card;
	static int[] sortedUpCard;
	static int[] sortedDownCard;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int T= Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringBuilder sb= new StringBuilder();
			sb.append("#").append(tc).append(" ");
			N= Integer.parseInt(br.readLine());
			card= new int[N];
			sortedUpCard=new int[N];
			sortedDownCard=new int[N];
			min= Integer.MAX_VALUE;
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				card[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) {
				sortedUpCard[i]=i+1;
				sortedDownCard[i]=N-i;
			}
			dfs(0,card);
			if(min==Integer.MAX_VALUE) {
				sb.append(-1);
				System.out.println(sb);
				continue;
			}
			sb.append(min);
			System.out.println(sb);
		}
	}
	private static void dfs(int cnt, int[] card) {
		if(cnt>5) return;
		if(cnt>=min) return;
		if(check1(card)||check2(card)) {
			min = Math.min(min,cnt);
			return;
		}
		int[]left= new int[N/2];
		int[]right= new int[N/2];
		for(int i=0;i<N/2;i++) {
			left[i]=card[i];
		}
		for(int i=N/2;i<N;i++) {
			right[i-N/2]=card[i];
		}
		for(int x=0;x<N;x++) {
			int[]next= new int[N];
			if (x<N/2) {
				next =shuffle(x, left, right);
			}else {
				next =shuffle(x-N/2, right, left);
			}
			dfs(cnt+1,next);
		}
	}
	private static int[] shuffle(int x,int[]left,int[] right) {
		int[] next= new int[N];
		int idx=0;
		int leftIdx=0;
		int rightIdx=0;
		int center = N/2;
		while(leftIdx<center-x) {
			next[idx]=left[idx];
			idx++;
			leftIdx++;
		}
		boolean flag =true;
		while(leftIdx<center&&rightIdx<center) {
			if(flag) {
				next[idx]=right[rightIdx];
				idx++;
				rightIdx++;
			}else {
				next[idx]=left[leftIdx];
				idx++;
				leftIdx++;
			}
			flag= !flag;
		}
		while(rightIdx<center) {
			next[idx]=right[rightIdx];
			idx++;
			rightIdx++;
		}
		return next;
	}
	private static boolean check1(int[]card) {
		for(int i=0;i<N;i++) {
			if(card[i]!=sortedUpCard[i]) return false;
		}
		return true;
	}
	private static boolean check2(int[]card) {
		for(int i=0;i<N;i++) {
			if(card[i]!=sortedDownCard[i]) return false;
		}
		return true;
	}
}
