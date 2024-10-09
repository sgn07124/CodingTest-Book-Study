package 이것이_취업을위한_코딩테스트다.구현;

import java.io.*;
import java.util.Scanner;

public class 상하좌우 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String [] plans = sc.nextLine().split(" ");
        int x = 1; int y = 1;  // 출발 지점

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);
            int nx = -1; int ny = -1;  // 이동한 결과의 좌표 (초기화)
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                }
            }
            if (nx < 1 || ny < 1 || nx > n || ny > n) {  // 공간을 벗어나는 경우는 무시
                continue;
            }
            // 이동한 좌표를 현제 좌표에 저장
            x = nx;
            y = ny;
        }
        System.out.println(x + " " + y);
    }
}
