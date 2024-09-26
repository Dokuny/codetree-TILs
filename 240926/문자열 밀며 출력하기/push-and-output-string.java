import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        StringBuilder sb = new StringBuilder();
        
        sb.append(word).append("\n");
        for(int i = 1; i <= word.length(); i++) {
            sb.append(word.substring(i)).append(word.substring(0,i)).append("\n");
        }

        System.out.println(sb);
    }
}