import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2798_∫Ì∑¢¿Ë {

public static void main(String[] args) throws IOException{
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] card = new int[n];
    
    int min = 100000;
    int result = 0;
    
    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < n; i++) {
        card[i] = Integer.parseInt(st.nextToken());
    }
    
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            for(int k = 0; k < n; k++) {
                if((m - (card[i] + card[j] + card[k])) < min && m - (card[i] + card[j] + card[k]) >= 0 && i != j && j != k && i != k) {
                    min = m - (card[i] + card[j] + card[k]);
                    result = card[i] + card[j] + card[k];
                }
            }
        }
    }
    
    System.out.println(result);
}
}