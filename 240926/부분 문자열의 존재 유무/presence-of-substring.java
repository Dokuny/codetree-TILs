import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        boolean isEE = false;
        boolean isEA = false;

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) == 'e') {
                if(s.charAt(i) == 'e') {
                    isEE = true;
                }

                if(s.charAt(i) == 'a') {
                    isEA = true;
                }
            }
        }

        String answer = "";

        if(isEE) {
            answer += "YES";
        }else {
            answer += "NO";
        }
    

        if(isEA) {
            answer += " YES";
        }else {
            answer += " No";
        }

        System.out.println(answer.trim());
        
    }
}