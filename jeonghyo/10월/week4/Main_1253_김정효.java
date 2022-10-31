import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_1253_김정효 {
	static int result, arr[];
	static List<Integer> list;
	static boolean check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[2];
		HashSet<Integer> s = new HashSet<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			s.add(Integer.parseInt(st.nextToken()));
		}
		list = new ArrayList<Integer>(s);
		
		for (int i = 2; i < n; i++) {
			check = false;
			comb(0, list.get(i), 0);
		}
		System.out.println(result);

	}

	private static void comb(int start, int end, int cnt) {
		if (cnt == 2) {
			if (arr[0] + arr[1] == end) {
				result++;
//				System.out.println(arr[0]+" "+arr[1]+" "+end);
				check = true;
			}
			return;
		}
		
		for (int i = start; i < end; i++) {
			arr[cnt] = list.get(i);
			comb(i+1, end, cnt+1);
			if (check) return;
		}
		
	}

}
