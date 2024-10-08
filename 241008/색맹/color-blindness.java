import java.util.*;
import java.io.*;

public class Main {

    static int[][] dirs = {{1,0}, {-1, 0}, {0,1}, {0,-1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int n = Integer.parseInt(br.readLine());

         char[][] normal = new char[n][n];
         char[][] abnormal = new char[n][n];

         for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                normal[i][j] = input.charAt(j);
                abnormal[i][j] = input.charAt(j) == 'G' ? 'R' : input.charAt(j);
            }
         }

         System.out.println(check(normal, n) +" "+check(abnormal, n));

         
    }

    static int check(char[][] map,int n) {

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'X') continue;

                ArrayDeque<int[]> queue = new ArrayDeque<>();
                
                queue.addLast(new int[]{j,i});

                char color = map[i][j];

                while(!queue.isEmpty()) {
                    int[] cur = queue.pollFirst();

                    for(int[] dir : dirs) {
                        int x = cur[0] + dir[0];
                        int y = cur[1] + dir[1];

                        if(x < 0 || y < 0 || x >= n || y >= n) continue;
                        if(color != map[y][x]) continue;

                        queue.addLast(new int[]{x,y});
                        map[y][x] = 'X';
                    }
                }
                cnt++;
            }
         }

         return cnt;

    }
}