import java.util.ArrayList;
import java.util.Arrays;

public class p34 {

    private static ArrayList<Integer>[] adjList;  // 인접 리스트 저장
    private static boolean[] visited;  // 방분 여부 저장
    private static ArrayList<Integer> answer;  // 결과 리스트

    private static int[] solution(int[][] graph, int start, int n) {
        // 인접 리스트 초기화
        adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();  // 인접 리스트이므로 리스트 내에 각 인덱스마다 ArrayList 객체 생성
        }

        // 그래프를 인접 리스트로 변환
        for (int[] edge : graph) {
            adjList[edge[0]].add(edge[1]);  // adjList[i]에 vertex 를 add하는 방식을 적용하여 주어진 graph를 인접 리스트로 변환
        }

        // DFS 순회한 결과 반환
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void dfs(int now) {
        visited[now] = true;  // 현재 노드를 방문했음을 저장
        answer.add(now);  // 현재 노드를 결과 리스트에 추가
        // 현재 노드와 인접한 노드 순회
        for (Integer next : adjList[now]) {
            if (!visited[next]) {  // 방문하지 않은 노드라면, 해당 노드를 다음 노드로 하여 dfs(next) 호출
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        int [][] graph = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };
        int start = 1;
        int n = 5;

        int[] res;
        res = solution(graph, start, n);
        System.out.println(Arrays.toString(res));
    }
}
