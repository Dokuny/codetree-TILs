import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(int i = arr[0]; i <= arr[2]; i++) {
            if(i == arr[1]) continue;
            for(int j = 1; j < 10; j++) {
                sb.append(i).append(" * ").append(j).append(" = ").append(i*j).append("\n");
            }
        }

        System.out.println(sb);

    }
}