package 이것이_취업을위한_코딩테스트다.그리디;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자_카드_게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = 0;
        for (int i = 0; i < n; i++) {
            min = Arrays.stream(arr[i]).min().getAsInt();  // 각 행에서 가장 작은 수를 min에 저장
        }
        bw.write(min + "");
        bw.flush();
        bw.close();
    }
}
