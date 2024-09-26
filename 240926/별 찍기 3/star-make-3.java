import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();


        // 증가 별
        for(int i = 1; i <= n/2+1; i++) {
            for(int empty = 1; empty < i; empty++) {
                sb.append(" ");
            }

            for(int star = 0; star < i*2 - 1; star++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        // 감소 별
        for(int i = n/2; i >= 1; i--) {
            for(int empty = 1; empty < i; empty++) {
                sb.append(" ");
            }

            for(int star = 0; star < i*2 - 1; star++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}