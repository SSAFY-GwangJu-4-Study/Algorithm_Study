import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 당근 훔쳐 먹기 문제
 * @author 김경삼
 *
 */
public class Main_18234_김경삼 {
	static int N,T;
	static Point[] input;
	static long ans;
	static class Point{
		int start;
		int up;
		
		@Override
		public String toString() {
			return "Point [start=" + start + ", up=" + up + "]";
		}
		public Point(int start,int up) {
			this.start=start;
			this.up= up;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= null;
		
		st= new StringTokenizer(br.readLine());
		N= Integer.parseInt(st.nextToken());
		T= Integer.parseInt(st.nextToken());
		input = new Point[(int) N];
		ans = 0;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine().trim());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			input[i]= new Point(first,second);
		}
		
		//끝까지 영양 키워놓고 가장 높은 값부터 차례대로 먹기 위해 정렬 수행
		//그리디한 접근법으로 , 영양제 값이 높은 당근을 늦게 먹을수록 토끼가 얻는 총 맛의 합은 커진다.
		//당근의 개수가 N개 일때, 영양제가 음수가 없으므로, 최대한 키운 후 N일 동안 당근을 먹을 때 최대가 된다. 
		Arrays.sort(input,new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return o2.up-o1.up;
			}
		});
		
//		System.out.println(Arrays.toString(input));
		// cur int로 받으면 1%에서 에러 발생..
		for(int i=0;i<N;i++) {
			long cur = input[i].start+(input[i].up*(long)(T-1));
			T--;
			ans+=cur;
		}
		System.out.println(ans);
	}
}
