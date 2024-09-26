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

        PriorityQueue<Student> pq = new PriorityQueue<>((o1,o2) -> o1.grade - o2.grade);

        for(String name : map.keySet()) {
            pq.add(new Student(name, map.get(name)));
        }

        Student prev = pq.poll();
        int no = 1;
        int cnt = 1;
        String answer = "";
        while(!pq.isEmpty()) {
            Student cur = pq.poll();
            if(no == 2) {
                if(cur.grade == prev.grade) {
                    answer = "Tie";
                }
                break;
            }

            if(cur.grade != prev.grade) {
                no += 1;
                answer = cur.name;
            }
        }

        System.out.println(answer);



    }

    static class Student {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }
}