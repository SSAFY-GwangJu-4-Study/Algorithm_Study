import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11650_좌표_정렬하기 {
    static class xy{
        int x;
        int y;
        xy(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        xy[] arr = new xy[n];



        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new xy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        }

        Arrays.sort(arr, new Comparator<xy>() {
            @Override
            public int compare(xy o1, xy o2) {
                if(o1.x == o2.x) {
                    return Integer.valueOf(o1.y).compareTo(Integer.valueOf(o2.y));
                }

                return o1.x - o2.x;
            }
        });

    
    for(int i = 0; i < n; i++) {
        bw.write(arr[i].x + " " + arr[i].y + "\n");
    }
    
    bw.close();
    
}
}