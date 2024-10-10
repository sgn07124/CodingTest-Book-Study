package 이것이_취업을위한_코딩테스트다.구현;

import java.util.Scanner;

public class 시각 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int l = 0; l < 60; l++) {
                    if(check(i, j, l)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
    public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m % 10 == 3 || s % 10 == 3 || m / 10 == 3 || s / 10 == 3) {
            return true;
        }
        return false;
    }
}
