import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
 
        int[] arr = new int[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 1;
        int base = arr[n-1];
        for(int i = n-2; i >= 0; i--) {
            if(arr[i] <= base) {
                cnt++;
                base = arr[i];
            }
        }
        
        System.out.println(cnt);
    }
}