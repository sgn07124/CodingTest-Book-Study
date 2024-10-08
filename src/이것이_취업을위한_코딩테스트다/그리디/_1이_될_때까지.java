package 이것이_취업을위한_코딩테스트다.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1이_될_때까지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while (n != 1) {
            // k로 가능한 한 많이 나눴을 때 가장 빠르게 n = 1을 만들 수 있다.
            if (n % k == 0) {
                n /= k;
                cnt++;
            }  else {
                n -= 1;
                cnt++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}
