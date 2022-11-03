import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 김성렬씨 문제 다 풀어보자
 * 게임 점수 d1
 * @author Kyungsam Kim
 *
 */
public class swea_14509_김경삼 {
	static int N,ans,bCnt;
	static int[]arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		int T =Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			N =Integer.parseInt(br.readLine());
			arr= new int[N];
			ans =Integer.MAX_VALUE;
//			bCnt=Integer.MAX_VALUE;
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				arr[i]= Integer.parseInt(st.nextToken());
			}
			simul();
			System.out.println("#"+tc+" "+ans);
		}
	}
	static void simul() {
		for(int i=0;i<N;i++) {
			int a = arr[i];
			int leftIdx=i;
			int left=0;
			while(--leftIdx>=0){
				int tmpLeft=0;
				for(int j=leftIdx;j>=0;j--) {					
					tmpLeft+=arr[j];
				}
				left=Math.max(left, tmpLeft);
			}
			
			int rightIdx=i;
			int right=0;
			while(++rightIdx<=N-1){
				int tmpRight=0;
				for(int j=rightIdx;j<N;j++) {
					tmpRight+=arr[j];
				}
				right=Math.max(right, tmpRight);
			}
			
//			System.out.println("left:" +left);
//			System.out.println("right:" +right);
			bCnt= Math.max(left,right);
			ans = Math.min(ans, bCnt);
		}
	}
	
}
