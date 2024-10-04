import java.util.*;
import java.io.*;

public class Main {

    static int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[1001][1001];
        boolean[][] comforMap = new boolean[1001][1001];

        StringTokenizer st;
        int comfortPinset = 0;
        StringBuilder sb = new StringBuilder();
        // 핀셋 꼽고 네방향 확인, 그리고 네방향에서도 다시 네방향 확인해서 편안한 핀셋인지 확인(이거 하기 전에 편안한 핀셋인지 표식을 해두기, 그래서 편안한 핀셋이라면 건너 뛰기)
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[y][x] = true;

            int pinsetCnt = 0;
            for(int[] dir : dirs) {
                int adjX = x + dir[0];
                int adjY = y + dir[1];

                if(adjX < 0 || adjY < 0 || adjX > 1000 || adjY > 1000) continue;
                if(map[adjY][adjX]) pinsetCnt++;

                // 주변 핀셋이 편안한 핀셋이 아니라면 편안해질 수 있는지 확인
                if(!comforMap[adjY][adjX]) {
                    int adjPinsetCnt = 0;
                    for(int[] dir1 : dirs) {
                        int adjAdjX = adjX + dir1[0];
                        int adjAdjY = adjY + dir1[1];

                        if(adjAdjX < 0 || adjAdjY < 0 || adjAdjX > 1000 || adjAdjY > 1000) continue;
                        if(map[adjAdjY][adjAdjX]) adjPinsetCnt++;
                    }
                     if(adjPinsetCnt == 3) {
                        comforMap[adjY][adjX] = true;
                        comfortPinset++;
                    };
                }else {
                    comforMap[adjY][adjX] = false;
                    comfortPinset--;
                }
            }
            if(pinsetCnt == 3) {
                comforMap[y][x] = true;
                comfortPinset++;
            };

            
            sb.append(comfortPinset).append("\n");
        }

        System.out.println(sb);
    }
}