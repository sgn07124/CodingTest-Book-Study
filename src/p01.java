import java.util.Arrays;

// 문제 01. 배열 정렬하기
public class p01 {
    public static void main(String[] args) {
        //int [] org = {4, 2, 3, 1, 5};
        //int [] sorted = solution1(org);  // org 배열 자체를 정렬
        /**
         * 100,000개의 데이터를 오름차순으로 정렬해보면 sort()를 사용했을 때, 0.001초가 나오고, 버블 정렬을 사용하면 1.007초가 나온다.
         * 즉, sort() 를 사용하는 것이 속도 측면에서 훨씬 좋다는 것을 알 수 있다.
         */
        int [] org = new int [100000];

        System.out.println("----- sort() API 사용 -----");
        long start1 = System.currentTimeMillis();
        int [] sorted = solution(org);  // org 배열의 복사체를 생성하여 정렬. org 배열은 유지
        long end1 = System.currentTimeMillis();
        //System.out.println("org : " + Arrays.toString(org));
        //System.out.println("org : " + Arrays.toString(sorted));
        System.out.println((end1 - start1) / 1000.0 + "초");

        System.out.println("----- 버블 정렬 사용 -----");
        long start2 = System.currentTimeMillis();
        int [] bubble = bubbleSort(org);
        long end2 = System.currentTimeMillis();
        //System.out.println("org : " + Arrays.toString(org));
        //System.out.println("org : " + Arrays.toString(sorted));
        System.out.println((end2 - start2) / 1000.0 + "초");

    }

    public static int[] solution (int[] arr) {  // sort() API 사용 : O(NlogN)
        int [] clone = arr.clone();  // clone() : 타겟이 되는 배열을 복사하여 새로운 배열로 생성
        Arrays.sort(clone);
        return clone;
    }

    public static int[] bubbleSort(int[] org) {  // 버블 정렬 사용 : O(N^2)
        int [] arr = org.clone();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        return arr;
    }
}
