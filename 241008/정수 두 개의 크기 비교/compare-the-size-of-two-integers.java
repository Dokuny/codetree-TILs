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
        int prevR = 0;

        long cnt = 0;
        boolean isCon = false;
        while(r < n) {
            // 비교
            if(l == r) {
                r++;
                continue;
            }

            if(arr[r] * 0.9 <= arr[l]) {
                r++;
                isCon = true;
            }else {
                if(isCon) {
                    cnt += (r-l) * (r-l-1) / 2;
                    if(l < prevR) {
                        cnt -= (prevR-l) * (prevR-l-1) / 2;
                    }
                    prevR = r;
                }
                l++;
            }

                if(isCon) {
                    cnt += (r-l) * (r-l-1) / 2;
                    if(l < prevR) {
                        cnt -= (prevR-l) * (prevR-l-1) / 2;
                    }
                    prevR = r;
                }
        }

        System.out.println(cnt);

    }
}