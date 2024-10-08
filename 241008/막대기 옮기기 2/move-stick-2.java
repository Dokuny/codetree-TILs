import java.util.*;
import java.io.*;

public class Main {

    // 가로 - 0, 세로 - 1, 대각선 - 2
    static int[][][] dirs = {{{1,0},{0,0},{1,1}}, {{0,0}, {0,1}, {1,1}}, {{1,0},{0,1},{1,1}}};
    static int[][] check;
    static int[][] map;
    static int n;
    static int END;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // DFS
        n = Integer.parseInt(br.readLine());
        END = n - 1;

        map = new int[n][n];
 
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new int[n][n];

        System.out.println(dfs(1,0,0));

    }

    static int dfs(int x, int y, int dir) {
        if(x == END && y == END) {
            return 1;
        }

        if(check[y][x] != 0) {
            return check[y][x];
        }

        int[][] moves = dirs[dir];

        int cnt = 0;

        // 대각선 이외 이동
        for(int i = 0; i < moves.length; i++) {
            if(moves[i][0] == 0 && moves[i][1] == 0) continue;

            int newX = x + moves[i][0];
            int newY = y + moves[i][1];

            if(newX < 0 || newY < 0 || newX >= n || newY >= n) continue;
            if(map[newY][newX] == 1) continue;
            
            // 대각선 조건 확인
            if(i == 2) {
                // 왼쪽 및 위 확인
                if(map[newY][newX-1] == 1 || map[newY-1][newX] == 1) continue;
            }

            // 이동이 가능
            // 근데 이미 앞서 방문한 곳이면 값 가져오기
            if(check[newY][newX] != 0) {
                cnt += check[newY][newX];
            }else {
                cnt += dfs(newX, newY, i);
            }
        }


        return cnt;

    }

}