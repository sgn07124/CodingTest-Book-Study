import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

// 문제 03. 두 개 뽑아서 더하기
public class p03 {
    /**
     * HashSet이 TreeSet보다 0.001~0.003초 정도 느림(20회 정도 실행)
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 1};

        long start1 = System.currentTimeMillis();
        int [] res1 = solution1(arr);
        long end1 = System.currentTimeMillis();
        System.out.println(Arrays.toString(res1) + "time = " + (end1 - start1) / 1000.0 + "초");  // 0.002~0.003초

        long start2 = System.currentTimeMillis();
        int [] res2 = solution2(arr);
        long end2 = System.currentTimeMillis();
        System.out.println(Arrays.toString(res2) + "time = " + (end2 - start2) / 1000.0 + "초");  // 0~0.001초

    }

    public static int[] solution1 (int[] numbers) {
        HashSet<Integer> set = new HashSet<>();  // HashSet : 중복값 제거

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        // HashSet의 값을 오름차순 정렬하고, int[] 형태의 배열로 변환하여 반환
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solution2 (int[] numbers) {
        TreeSet<Integer> set = new TreeSet<>();  // TreeSet : 정렬과 중복 제거 동시에 가능

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();  // 정렬할 필요가 없음
    }
}
