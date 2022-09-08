import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1931_김경삼 {
	public static class Input implements Comparable<Input>{
		Input(int i, int j){
			this.i =i;
			this.j =j;
		};
		
		int i;
		int j;
		@Override
		public int compareTo(Input o) {
			if(j==o.j) {
				return i-o.i;
			}
			
			return j-o.j;
		}
		
	}
	
	
	static int[][] arr;
	static List<Input> Inputs=new ArrayList<Input>();
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			int first=Integer.parseInt(st.nextToken());
			int second=Integer.parseInt(st.nextToken());
			Input input = new Input(first,second);
			Inputs.add(input);
		}
		find();
	}
	private static void find() {
		Collections.sort(Inputs);
		
		int count =0;
		int tmpEnd=0;
		for(int i=0;i<N;i++) {
			if(tmpEnd<=Inputs.get(i).i) {
				tmpEnd=Inputs.get(i).j;
				count++;
			}
		}
		System.out.println(count);
	}
	
}

