import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
    
        int max = 0;
        char team = 'A';

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();

            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            if(max < sum) {
                max = sum;
                team = (char)('A' + i);
            }

            sb.append((char)('A'+i)).append(" - ").append(sum).append("\n");
        }

        sb.append("Class ").append(team).append(" is winner!");

        System.out.println(sb);
    }
}