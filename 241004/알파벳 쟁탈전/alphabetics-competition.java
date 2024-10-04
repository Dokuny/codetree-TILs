import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] possible;
    static List<Integer>[] impossible;
    static int[] word;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        possible = new List[n];
        impossible = new List[n];

        for(int i = 0; i < n; i++) {
            possible[i] = new ArrayList<>();
            impossible[i] = new ArrayList<>();
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            char command = st.nextToken().charAt(0);

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if(command == 'S') {
                possible[Math.max(a,b)].add(Math.min(a,b));    
            } else {
                impossible[Math.max(a,b)].add(Math.min(a,b));    
            }

        }

        word = new int[n];


        dfs(0, n);
        
        System.out.println(cnt);
    }

    static void dfs(int depth, int n) {
        if(depth == n) {
            cnt++;
            return;
        }

        for(int i = 'A'; i <= 'C'; i++) {
            // 동일 한지 확인
            boolean isPossible = true;

            word[depth] = i;
            for(int num : possible[depth]) {
                if(word[depth] != word[num]) {
                    isPossible = false;
                    break;
                }
            }

            if(!isPossible) continue;

            // 달라야하는지 확인
            for(int num : impossible[depth]) {
                if(word[depth] == word[num]) {
                    isPossible = false;
                    break;
                }
            }

            if(!isPossible) continue;

            dfs(depth + 1, n);

        }

    }
}