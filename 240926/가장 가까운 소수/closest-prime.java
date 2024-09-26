import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int standard = Integer.parseInt(br.readLine());

        boolean[] isNoPrime = new boolean[2000001];
        isNoPrime[0] = true;
        isNoPrime[1] = true;

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int i = 2; i < Math.sqrt(isNoPrime.length); i++) {
            if(isNoPrime[i]) continue;

            int diff = Math.abs(standard - i);

            if(map.containsKey(diff)) {
                map.get(diff).add(i);
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(diff, list);
            }

            for(int j = i + i; j < isNoPrime.length; j += i) {
                isNoPrime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Integer diff : map.keySet()) {
            for(Integer num : map.get(diff)) {
                sb.append(num).append(" ");
            }
            break;
        }

        System.out.println(sb);


    }
}