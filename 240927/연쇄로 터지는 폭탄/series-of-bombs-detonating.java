import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;

        // 투포인터 문제
        for(int i = 0; i < N; i++) {
            int power = 1;
            int lIdx = i - 1;
            int rIdx = i + 1;
            int preLidx = i;
            int preRidx = i;

            int cnt = 1;
            while(lIdx >= 0 && rIdx < N) {
                boolean isBomb = false;
                if(power >= Math.abs(arr[preLidx] - arr[lIdx])){
                    cnt++;
                    preLidx = lIdx;
                    lIdx--;
                    power++;
                    isBomb = true;
                }

                if(power >= Math.abs(arr[preRidx] - arr[rIdx])) {
                    cnt++;
                    preRidx = rIdx;
                    rIdx++;
                    power++;
                    isBomb = true;
                }


                if(!isBomb) break;


            }   

            while(lIdx >= 0) {
                boolean isBomb = false;
                if(power >= Math.abs(arr[preLidx] - arr[lIdx])){
                    cnt++;
                    preLidx = lIdx;
                    lIdx--;
                    power++;
                    isBomb = true;
                }
                if(!isBomb) break;
            }

            while(rIdx < N) {
                boolean isBomb = false;
                if(power >= Math.abs(arr[preRidx] - arr[rIdx])) {
                    cnt++;
                    preRidx = rIdx;
                    rIdx++;
                    power++;
                    isBomb = true;
                }
                if(!isBomb) break;
            }

            max = Math.max(max, cnt);
        }
        System.out.println(max);
        
    }
}