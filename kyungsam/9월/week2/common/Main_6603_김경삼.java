import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로또문제
 * 
 * @author 김경삼
 *
 */
public class Main_6603_김경삼 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		while (true) {
			String line= br.readLine();
			if(line.equals("0"))return;
			else {
				st = new StringTokenizer(line);
				int n= Integer.parseInt(st.nextToken());
				int[] nums= new int[n];
				int[] oneCase=new int[6];
				for(int i=0;i<nums.length;i++) {
					nums[i]=Integer.parseInt(st.nextToken());
				}
				//입력 끝
				comb(0,0,nums,oneCase);
				System.out.println();
			}
		}
	}
	
	private static void comb(int cnt,int start, int[]nums,int[] oneCase) {
		if(cnt==6) {
		//6개 조합 cnt완료
			for(int i=0;i<oneCase.length;i++) {
				System.out.print(oneCase[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<nums.length;i++) {
			oneCase[cnt]=nums[i];
			comb(cnt+1,i+1,nums,oneCase);
		}
	}
}
