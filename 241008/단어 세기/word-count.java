import java.util.*;
import java.io.*;

public class Main {

    static String END = "end";
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        TreeMap<String,Integer> map = new TreeMap<>();
        
        while(true) {
            String input = br.readLine();

            if(input.equals(END)) break;

            StringTokenizer st = new StringTokenizer(input);

            while(st.hasMoreTokens()) {
                String word = st.nextToken();

                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            for(String key : map.keySet()) {
                sb.append(key).append(" : ").append(map.get(key)).append("\n");
            }
        }

        System.out.println(sb);
    }
}