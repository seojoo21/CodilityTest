import java.util.*;

public class BFS {
    public static void main(String[] args){
        //각 노드가 연결된 정보를 2차원 배열 자료형으로 표현
        int[][] graph = {{},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}};

        //각 노드가 방문된 정보를 1차원 배열 자료형으로 표현
        boolean[] visited = new boolean[graph.length];

        int start = 1; // 시작노드

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = true; //현재 노드 방문 처리

        //큐가 빌 때까지 반복
        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v + " ");

            // 인접한 노드 중 아직 방문하지 않은 노드를 큐에 삽입
            for (int i : graph[v]){
                if(visited[i] == false){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
