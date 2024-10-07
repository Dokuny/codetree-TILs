import java.util.*;
import java.io.*;

public class Main {

    static String word;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        word = br.readLine();

        int cnt = 0;
        int continuousCnt = 0;
        boolean isContinue = true;
        // a 체크
        for(int i = 0; i < n; i++) {
            if(word.charAt(i) == 'a') {
                cnt++;
                if(isContinue) continuousCnt++;
            }else {
                isContinue = false;
            }
        }

        int answer = Math.min(calculate('a', n) , Math.min(calculate('b', n) , Math.min(calculateReverse('a', n), calculateReverse('b',n))));

        System.out.println(answer);

    }

    static int calculate(char c, int n) {
        int cnt = 0;
        int continuousCnt = 0;
        boolean isContinue = true;

        for(int i = 0; i < n; i++) {
            if(word.charAt(i) == c) {
                cnt++;
                if(isContinue) continuousCnt++;
            }else {
                isContinue = false;
            }
        }

        return cnt - continuousCnt;
    }

    static int calculateReverse(char c, int n) {
        int cnt = 0;
        int continuousCnt = 0;
        boolean isContinue = true;

        for(int i = n-1; i >= 0; i--) {
            if(word.charAt(i) == c) {
                cnt++;
                if(isContinue) continuousCnt++;
            }else {
                isContinue = false;
            }
        }

        return cnt - continuousCnt;
    }
}