public class DFSRecursion{

    // 각 노드가 연결된 정보를 2차원 배열 자료형으로 표현
    public static int[][] graph = {{},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}};

    //각 노드의 방문 정보를 1차원 배열 자료형으로 표현
    public static boolean[] visited = new boolean[graph.length];

    /**
     * dfs 메소드
     * @param v
     */
    public static void dfs(int v){
        //현재 노드 방문 처리
        visited[v] = true;
        System.out.print(v + " ");

        //인접 노드 탐색
        for(int i : graph[v]){
            if(visited[i] == false){
                dfs(i);
            }
        }
    }

    public static void main(String[] ars){
        int start = 1;
        dfs(start);
    }
}