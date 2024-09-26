import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean isPrime = false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) isPrime = true;
        }

        String answer = "";
        if(n == 1) {
            answer = "one";
        }else if(!isPrime) {
            answer = "composition";
        }else {
            answer = "prime";
        }

        System.out.println(answer);
    }
}