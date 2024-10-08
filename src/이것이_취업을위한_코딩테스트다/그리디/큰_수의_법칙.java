package 이것이_취업을위한_코딩테스트다.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 큰_수의_법칙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Integer[] tmp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());

        int first = tmp[0];
        int second = tmp[1];
        int sum = 0;

        while (true) {
            for (int i = 0; i < K; i++) {
                if (M == 0) break;
                sum += first;  // 첫 번재로 큰 수는 K번(최대한 많이) 더한다.
                M -= 1;
            }
            if (M == 0) break;
            sum += second;  // 두 번째로 큰 수는 한 번만 더한다.
            M -= 1;
        }

        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
