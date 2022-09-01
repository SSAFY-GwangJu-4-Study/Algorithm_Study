import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main_1406_에디터 {
    public static List<Character> list = new LinkedList<Character>();
    public static int cursor = 0;

public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String s = st.nextToken();
    for (int i = 0; i < s.length(); i++) {
        list.add(s.charAt(i));
    }

    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    cursor = s.length();
    ListIterator<Character> it = list.listIterator(list.size());
    for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        String order = st.nextToken();
        
        switch (order) {
        case "L":
            if (it.hasPrevious())
                it.previous();
            break;
        case "D":
            if (it.hasNext())
                it.next();
            break;
        case "B":
            if (it.hasPrevious()) {
                it.previous();
                it.remove();
            }
            break;
        case "P":
            it.add(st.nextToken().charAt(0));
            break;
        }
    }

    StringBuilder sb = new StringBuilder();

    for (Character ch : list) {
        sb.append(ch);
    }

    System.out.println(sb);
}
}