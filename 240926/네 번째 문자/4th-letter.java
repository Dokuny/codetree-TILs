import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        char c = st.nextToken().charAt(0);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            String word = br.readLine();

            boolean isC = false;
            for(int j = 0; j < word.length(); j++) {
                if(word.charAt(j) == c) {
                    cnt++;
                    isC = true;
                    break;
                }
            }

            if(isC) sb.append(word).append("\n");
        }

        System.out.println(cnt+"\n"+sb.toString());
    }
}