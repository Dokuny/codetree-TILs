import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] robots = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            robots[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        Integer[] stuffs = new Integer[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            stuffs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(stuffs, (o1,o2) -> o2-o1);
        Arrays.sort(robots, (o1,o2) -> o2-o1);

        int remainStuff = m;
        int time = 0;
        while(remainStuff != 0) {

            boolean checkOne = false;
            for(int i = 0; i < n; i++) {
                boolean isProcess = false;
                for(int j = 0; j < m; j++) {
                    // 물건의 무게가 더 큰 경우, 누군가가 처리한 경우
                    if(isProcess || robots[i] < stuffs[j]) break;
                    
                    if(stuffs[j] == -1) continue;
                    // 물건의 무게가 더 작은 경우
                    stuffs[j] = -1;
                    remainStuff--;
                    isProcess = true;
                    checkOne = true;
                }
            }
            if(!checkOne) break;
            time++;
        }
        int answer = -1;
        if(time != 0) {
            answer = time;
        }

        System.out.println(answer);

    }
}