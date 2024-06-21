import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

// 문제 02. 배열 제어하기
public class p02 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 1, 3, 4};

        long start1 = System.currentTimeMillis();
        int[] result1 = solution(arr);
        long end1 = System.currentTimeMillis();

        System.out.println("----- stream으로 변환하여 풀이 -----");  // 0.002초
        System.out.println("result1 = " + Arrays.toString(result1));
        System.out.println((end1 - start1) / 1000.0 + "초");

        long start2 = System.currentTimeMillis();
        int[] result2 = treeSet(arr);
        long end2 = System.currentTimeMillis();

        System.out.println("----- TreeSet을 사용하여 풀이 -----");  // 0.0초
        System.out.println("result2 = " + Arrays.toString(result2));
        System.out.println((end2 - start2) / 1000.0 + "초");


    }

    public static int[] solution (int[] arr) {  // 스트림 사용하는 방식

        // 1. 중복값 제거
        Integer[] result = Arrays.stream(arr)  // stream으로 변환
                .boxed()  // boxed()로 stream의 프리미티브 타입인 IntStream의 데이터를 레퍼런스 타입인 Integer로 변환
                .distinct()  // distinct()로 중복 제거
                .toArray(Integer[]::new);  // Integer형 배열로 중복 제거된 데이터를 반환

        // 2. 내림차순 정렬
        Arrays.sort(result, Collections.reverseOrder());  // Collections.reverseOrder()가 추가되면 내림차순 정렬

        // Integer[]형 배열을 int[] 형태로 변환하여 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    public static int[] treeSet (int[] arr) {
        // 1. TreeSet을 사용하여 중복 제거와 정렬(Collections.reverseOrder() 추가로 내림차순)을 동시에 수행
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int num : arr) {
            set.add(num);
        }

        // int형 배열에 담아서 반환
        int [] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }

        return result;
    }
}
