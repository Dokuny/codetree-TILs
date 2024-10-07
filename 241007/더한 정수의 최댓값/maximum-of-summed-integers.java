import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 구해두기 
        int[] right = new int[n];
        int[] left = new int[n];
        right[0] = arr[0];
        left[n-1] = arr[n-1];
        for(int i = 1; i < n; i++) {
            right[i] = arr[i] + right[i-1];
        }

        for(int i = n-2; i >= 0; i--) {
            left[i] = arr[i] + left[i+1];
        }

        long max = 0;
        for(int i = 1; i < n; i++) {
            max = Math.max(max, (right[n-1] - right[0] - arr[i]) + (right[n-1] - right[i]));
        }

        for(int i = n - 2; i >= 0; i--) {
            max = Math.max(max, (left[0] - left[n-1] - arr[i]) + (left[0] - left[i]));
        }

        System.out.println(max);

    }
}