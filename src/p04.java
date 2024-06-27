import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// 문제 04. 모의고사
public class p04 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 2};
        int[] res = solution1(arr);
        System.out.println(Arrays.toString(res));

    }

    public static int[] solution1 (int[] answers) {
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i%pattern[j].length]) {  // i번째 답안 == pattern[수포자 번호(j)][답안(i)%(각 수포자의 답안 패턴의 길이)]
                    score[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(score).max().getAsInt();  // score[]의 최댓값 -> 가장 높은 점수
        //System.out.println(maxScore);

        // 가장 높은 점수를 가진 수포자들의 번호를 찾아서 리스트에 담음
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (maxScore == score[i]) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
