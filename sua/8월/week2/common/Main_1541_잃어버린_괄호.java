import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_1541_잃어버린_괄호 {
	public static char[] tmp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<String> list = new LinkedList<String>();
		String s = br.readLine();

		tmp = s.toCharArray();
		for (int i = 0; i < tmp.length; i++) {// 숫자와 연산자 분리
			if (i == tmp.length - 1) {// 마지막에
				sb.append(tmp[i]);
				list.add(sb.toString());

			} else if (tmp[i] != '-' && tmp[i] != '+') {// 숫자라면
				sb.append(tmp[i]);

			} else {// 연산자라면
				list.add(sb.toString());
				list.add(String.valueOf(tmp[i]));
				sb = new StringBuilder();
			}
		}


		
		while (list.contains("+")) {//덧셈먼저하기
			
			int j = list.indexOf("+");
			list.set(j-1, String.valueOf(
							operate(Integer.parseInt(list.get(j - 1)), Integer.parseInt(list.get(j + 1)), "+")));
			list.remove(j);
			list.remove(j);

		}
		
		while (list.contains("-")) {
			
			int j = list.indexOf("-");
			list.set(j-1, String.valueOf(
							operate(Integer.parseInt(list.get(j - 1)), Integer.parseInt(list.get(j + 1)), "-")));
			list.remove(j);
			list.remove(j);

		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}

	}

	static int operate(int a, int b, String c) {
		if (c.equals("-"))
			return a - b;
		else
			return a + b;
	}

}
