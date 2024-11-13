import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] arr;
    static int min;
    static int L;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // H , W
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        min = Integer.MAX_VALUE;

        dfs(0,0,0,0,0, false);

        System.out.println(min);

    }

    static void dfs(int boxNo, int floor, int width, int height, int hSum, boolean flag) {
        // 종료 조건
        if(boxNo == N) {
            // min 값 기록
            min = Math.min(min, hSum);
            return;
        }

        if(boxNo < floor || hSum >= min) return;

        // 현재 박스를 해당 층에 놓을 수 있는가?
        // 1. 길이가 초과하지 않으면 일단 놓고 보자
        if(width + arr[boxNo][1] <= L) {
            // 근데 지금 놓여있는 박스 중에 현재 박스가 높이가 제일 높니?
            if(height < arr[boxNo][0]) {
                dfs(boxNo + 1, floor, width + arr[boxNo][1], arr[boxNo][0], hSum - height + arr[boxNo][0], true);
            }else {
                dfs(boxNo + 1, floor, width + arr[boxNo][1], height, hSum, true);
            }
        }

        // 일단 다음 층에 놔
        if(flag) {
            dfs(boxNo, floor + 1, 0, 0, hSum, false);
        }
    }

}