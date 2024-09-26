import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 세자리씩 끊어서 변환
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        for(int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';

            StringBuilder bSb = new StringBuilder();

            while(num != 0) {
                bSb.append(num % 2);
                num /= 2;
            }
            if(i !=0 && bSb.length() < 1) {
                bSb.append("0");
            }

            if(i !=0 && bSb.length() < 2) {
                bSb.append("0");
            }

            if(i !=0 && bSb.length() < 3) bSb.append("0");
            
            sb.append(bSb.reverse());
        }
        System.out.println(sb);

    }
}