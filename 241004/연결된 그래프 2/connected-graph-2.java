import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];

        int[] check = new int[n+1];

        for(int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adjList[s].add(e);
        }

        int max = 0;

        for(int i = 1; i <= n; i++) {
            // BFS
            boolean[] visited = new boolean[n+1];

            ArrayDeque<Integer> queue = new ArrayDeque<>();

            queue.addLast(i);
            int cnt = 1;
            while(!queue.isEmpty()){
                int cur = queue.pollFirst();

                if(visited[i]) continue;

                visited[i] = true;

                for(int adj : adjList[cur]) {
                    if(visited[adj]) continue;

                    cnt++;
                    visited[adj] = true;
                }
            }

            max = Math.max(cnt, max);
            check[i] = cnt;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(check[i] == max) sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}