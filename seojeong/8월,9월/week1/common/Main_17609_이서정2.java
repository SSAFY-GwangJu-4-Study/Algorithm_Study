import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17609_이서정2 {
	
	static String st;
	static char put;
	static ArrayList<Character> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int T=Integer.parseInt(str.nextToken());
		for(int t=0; t<T; t++) {
			st=br.readLine();
			
			list = new ArrayList<Character>();
			
			for(int i=0; i<st.length(); i++) {
				list.add(st.charAt(i));
			}
			
			boolean first=false;
			for(int i=0; i<=list.size()/2; i++) {
				if(list.get(i)!=list.get(list.size()-i-1)) {
					remove(i,list.size()-i-1);
					break;
					}
				if(i==list.size()/2) {
					System.out.println("0");
				}
				}

			
	
		}
	
		
	}

static boolean check() {
	for(int i=0; i<=list.size()/2; i++) {
		if(list.get(i)!=list.get(list.size()-i-1)) {
			return false;
			}
		}
	return true;
	}

static void remove(int position,int position2) {
	StringBuilder origin = new StringBuilder(st);

	StringBuilder check1 = origin;
	check1 = check1.deleteCharAt(position);
	String s1= check1.toString();

	
	list = new ArrayList<Character>();
	for(int i=0; i<s1.length(); i++) {
		list.add(s1.charAt(i));
	}

	if(check()==true) {
		System.out.println(1);
	}
	else {
		
		
		origin = new StringBuilder(st);
		StringBuilder check2 = origin;
		check2 = check2.deleteCharAt(position2);
		
		s1= check2.toString();

		list = new ArrayList<Character>();
		for(int i=0; i<s1.length(); i++) {
			list.add(s1.charAt(i));
		}

		if(check()==true) {
			System.out.println("1");
			return;
		}
		else {
			System.out.println("2");
			return;
		}
		
	}

	}
}

