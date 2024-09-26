import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while(true) {
            int num = Integer.parseInt(st.nextToken());

            if(num == -999) break;

            list.add(num);

        }

        list.sort((o1,o2) -> o1-o2);

        System.out.println(list.get(list.size()-1) +" "+ list.get(0));

    }
}