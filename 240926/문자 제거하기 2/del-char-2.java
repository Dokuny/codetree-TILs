import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String word = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder(word);

        for(int i = 0; i < n; i++) {
            int idx = Integer.parseInt(br.readLine());

            if(sb.toString().length() < idx) continue;

            sb.deleteCharAt(idx - 1);

            answer.append(sb.toString()).append("\n");
        }

        System.out.println(answer);
    }
}