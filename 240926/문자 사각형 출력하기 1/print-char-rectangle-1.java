import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];


        char c = 'A';

        for(int i = n-1; i >= 0 ; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(c > 'Z') c = 'A';

                map[j][i] = c;

                c++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}