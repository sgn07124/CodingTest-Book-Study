package 이것이_취업을위한_코딩테스트다.구현;

import java.util.Scanner;

public class 왕실의_나이트 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputData = sc.nextLine();
        int row = inputData.charAt(1) - '0';
        int column = inputData.charAt(0) - 'a' + 1;

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        int cnt = 0;

        for (int i = 0; i < 8; i++) {
            int nr = row + dx[i];
            int nc = column + dy[i];

            if (nr < 1 || nc < 1 || nr > 8 || nc > 8) {  // 체스판 밖으로 나가는 경우는 제외
                continue;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
