import java.io.*;
import java.util.*;

public class Main {
    // 비트마스킹과 조합 속도, 메모리 비교
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] ingredients = new int[n][2];
        for(int i=0; i<n; ++i){
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        // 신 --> 곱, 쓴 --> 합
        int ans = Integer.MAX_VALUE;
        int lth = 1<<n;
        for(int i=1; i<lth; ++i){ // 공집합 제외
            int sour=1, bitter = 0;
            for(int j=0; j<n; ++j){ // 0번째 재료, 1번째 재료...
                if((i & 1<<j) > 0){ // 숫자는 미리 뽑아낸 후, 똑같이 비트로 만들어 접근
                    sour *= ingredients[j][0];
                    bitter += ingredients[j][1];
                }
            }
            int diff = Math.abs(sour - bitter);
            ans = Math.min(ans, diff);
        }

        System.out.print(ans);
    }
}
