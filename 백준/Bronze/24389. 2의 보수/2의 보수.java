import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 메모리, 속도 성능 비교용
        int outputNum = ~N + 1;
        int sameBitNum = N ^ outputNum;
        
        // 서로 다른 비트 수 카운트
        int count = 0;
        for (char ch : Integer.toBinaryString(sameBitNum).toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        
        System.out.println(count);

        /*
        int[] two_path = new int[32];
        for (int i = 31; i >= 0; i--) {
            two_path[i] = N % 2;
            N /= 2;
        }

        int[] reverse_two_path = new int[32];
        for (int i = 0; i < 32; i++) {
            if (two_path[i] == 0) {
                reverse_two_path[i] = 1;
            } else {
                reverse_two_path[i] = 0;
            }
        }

        int bit = 31;
        while (bit >= 0) {
            if (reverse_two_path[bit] == 0) {
                reverse_two_path[bit] = 1;
                break;
            } else {
                reverse_two_path[bit] = 0;
                bit -= 1;
            }
        }

        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (two_path[i] != reverse_two_path[i]) {
                count++;
            }
        }

        System.out.println(count);
        */
    }
}
