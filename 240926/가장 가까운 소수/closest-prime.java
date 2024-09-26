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

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 2; i < Math.sqrt(isNoPrime.length); i++) {
            if(isNoPrime[i]) continue;

            set.add(i);

            for(int j = i + i; j < isNoPrime.length; j += i) {
                isNoPrime[j] = true;
            }
        }

        int prevNum = 2;
        int curNum = 2;
        for(Integer num : set) {
            if(num >= standard) {
                curNum = num;
                break;
            }

            prevNum = num;
        }

        System.out.println(!isNoPrime[standard] ? standard : Math.abs(standard-prevNum) < Math.abs(standard-curNum) ? prevNum : curNum);


    }
}