import java.util.*;

public class DFSStack {
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

        //각 노드의 방문 정보를 1차원 배열 자료형으로 표현
        boolean[] visited = new boolean[graph.length];

        dfs(graph, 1, visited);
    }

    /**
     * dfs 메서드
     * @param graph
     * @param start
     * @param visited
     */
    public static void dfs(int[][] graph, int start, boolean[] visited){
        // 현재 노드 방문 처리
        visited[start] = true;
        System.out.print(start + " ");

        Deque<Integer> stack = new LinkedList<>();
        stack.push(start); // 시작 노드를 스택에 삽입

        while(!stack.isEmpty()){
            int top = stack.peek();
            // 방문하지 않은 인접 노드가 있는지 확인
            boolean hasNearNode = false;
            for(int i : graph[top]){
                if(!visited[i]){
                    hasNearNode = true;
                    stack.push(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                    break;
                }
            }
            //방문하지 않은 인접 노드가 없는 경우 해당 노드를 꺼낸다.
            if(!hasNearNode){
                stack.pop();
            }
        }
    }
}
