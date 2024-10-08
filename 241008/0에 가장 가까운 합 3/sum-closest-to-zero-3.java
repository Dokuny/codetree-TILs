import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = Math.abs(num);
            set.add(num);
        }

        Arrays.sort(arr);

        // 슬라이딩 윈도우로 diff 계산
        int max = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++) {
            int diff = arr[i+1] - arr[i];

            if(diff < max) {
                // 가능한 수인지 검증
                // a가 음수이고 b가 양수
                if(set.contains(-arr[i+1]) && set.contains(arr[i])){
                    max = diff;
                    answer = -arr[i+1] + arr[i];
                }else if(set.contains(arr[i+1]) && set.contains(-arr[i])){
                    max = diff;
                    answer = arr[i+1] + -arr[i];
                }else if(set.contains(-arr[i]) && set.contains(-arr[i+1])){
                    // a가 음수 b가 음수
                    int sum = -arr[i] + -arr[i+1];
                    if(Math.abs(sum) <= max) {
                        max = Math.abs(sum);
                        answer = sum;
                    }
                }else {
                    // a가 양수 b가 양수
                    int sum = arr[i] + arr[i+1];
                    if(sum <= max) {
                        max = sum;
                        answer = sum;
                    }
                }
            }
        }




        System.out.println(answer);
        
    }
}