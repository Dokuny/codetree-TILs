import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] row = new int[n];

        for(int i = 0; i < n; i++) {
            row[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(row);
        
        int max = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, row[i] * (n - i));
        }
        System.out.println(max);
    }
}