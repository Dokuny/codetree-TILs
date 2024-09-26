import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < a; i++) {
         list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < b; i++) {
         list.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        for(int i : list) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}