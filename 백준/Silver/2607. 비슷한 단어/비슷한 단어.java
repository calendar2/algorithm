import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String first_word = br.readLine();
        int len = first_word.length();

        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            int cnt = 0;
            String word = br.readLine();
            int[] words = new int[26];

            for (int j = 0; j < len; j++) {
                words[first_word.charAt(j) - 'A']++;
            }

            for (int j = 0; j < word.length(); j++) {
                if (words[word.charAt(j) - 'A'] > 0) {
                    cnt++;
                    words[word.charAt(j) - 'A']--;
                }
            }

            if (first_word.length() == word.length() + 1) {
                if (word.length() == cnt) {
                    ans += 1;
                }
            } else if (first_word.length() == word.length() - 1) {
                if (word.length() - 1 == cnt) {
                    ans += 1;
                }
            } else if (first_word.length() == word.length()) {
                if (word.length() == cnt || word.length() - 1 == cnt) {
                    ans += 1;
                }
            }
        }

        System.out.println(ans);
    }
}
