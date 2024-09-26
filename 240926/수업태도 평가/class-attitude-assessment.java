import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("Bessie", 0);
        map.put("Elsie", 0);
        map.put("Daisy", 0);
        map.put("Gertie", 0);
        map.put("Annabelle", 0);
        map.put("Maggie", 0);
        map.put("Henrietta", 0);

        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            map.put(name , map.getOrDefault(name, 0) + Integer.parseInt(st.nextToken()));
        }

        TreeMap<Integer, ArrayList<String>> tMap = new TreeMap<>();

        for(String name : map.keySet()){
            if(tMap.containsKey(map.get(name))) {
                tMap.get(map.get(name)).add(name);
            }else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(name);
                tMap.put(map.get(name), list);
            }
        }

        String answer = "";
        if(tMap.size() == 1) {
            answer = "Tie";
        }else {
            int idx = 0;
            for(Integer key : tMap.keySet()) {
                if(idx == 1) {
                    if(tMap.get(key).size() > 1) {
                        answer = "Tie";
                    }else {
                        answer = tMap.get(key).get(0);
                    }
                    break;
                }
                idx++;
            }
        }
        System.out.println(answer);


    }

}