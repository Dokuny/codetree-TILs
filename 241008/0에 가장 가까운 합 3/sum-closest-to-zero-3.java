import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.sort(Comparator.comparingInt(Math::abs));

        // 슬라이딩 윈도우로 diff 계산
        int answer = Integer.MAX_VALUE;
        int check = Integer.MAX_VALUE;
        for(int i = 0; i < n-1; i++) {
            int sum = list.get(i) + list.get(i+1);
            if(check > Math.abs(sum)) {
                answer = sum;
                check = Math.abs(sum);
            } 
        }
        System.out.println(answer);
        
    }
}