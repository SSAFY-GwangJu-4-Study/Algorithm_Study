import java.util.Scanner;

public class Main_2798_송해찬 {
 
public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner input = new Scanner(System.in);
    int N = input.nextInt();
    int M = input.nextInt();
    int black[] = new int[N];
    int sum=0;
    int result=0;
    for(int i=0; i<N; i++) {
        black[i] = input.nextInt();
    }
    
    for(int i=0; i<N; i++) {
        for(int j=0; j<N; j++) {
            for(int k=0; k<N; k++) {
                if(i!=j && j!=k && i!=k ) {
                    sum=black[i]+black[j]+black[k];
                    if(sum<=M) {
                        result = Math.max(result, sum);
                    }
                }
            }
        }
    }
    System.out.println(result);
}
}

