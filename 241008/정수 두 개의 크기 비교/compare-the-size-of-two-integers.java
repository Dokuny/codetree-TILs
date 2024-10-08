import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 두 수의 차이가 10% 이하 

        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println(0);
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 투포인터로 비교
        int l = 0;
        int r = 1;

        int cnt = 0;
        int con = 0;
        while(r < n) {
            // 비교
            if(l == r) {
                r++;
                continue;
            }

            if(arr[r] * 0.9 <= arr[l]) {
                con++;
                r++;
            }else {
                cnt += (con * (con + 1)) / 2;
                con = 0;
                l++;
            }
        }

        cnt += (con * (con + 1)) / 2;

        System.out.println(cnt);


    }
}