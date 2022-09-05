import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 잃어버린 괄호
 * @author 김경삼
 *
 */
public class Main_1541_김경삼 {
	static int sum=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), "-");
		List<String> list = new LinkedList<>();
		//list에 -단위로 나눠서 넣어주기
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		//-로 나눠진 것들을 다시 +로 나눠주기
		for(int i=0;i<list.size();i++) {
			int tmp=0;
			String[] second = list.get(i).split("\\+");
			for(int j=0;j<second.length;j++) {
				tmp+=Integer.parseInt(second[j]);
			}
		//처음에 0일때는 -를 만나기 전이므로 더해준다
		if(sum==Integer.MAX_VALUE) {
			sum=tmp;
		}else {// -를 만나는 순간부터 계속 묶어서 음수처리할 수 있으므로 빼준다.
			sum-=tmp;
		}
		}
		System.out.println(sum);
	}
}
