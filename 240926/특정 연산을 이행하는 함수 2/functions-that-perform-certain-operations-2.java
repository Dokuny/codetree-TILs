import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        StringBuilder sb = new StringBuilder();

        double max = Math.max(a, Math.max(b,c));
        double min = Math.min(a, Math.min(b,c));
        double mid = a != max && a != min ? a : b != max && b != min ? b : c;

        sb.append((int)Math.ceil(max)).append(" ").append((int)Math.floor(min)).append(" ").append((int)Math.round(mid));

        System.out.println(sb);
    }
}