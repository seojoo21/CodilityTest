package Graph.DFS;

// https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected){
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i=0; i< visited.length; i++){
            if(!visited[i]){
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    private static void dfs(int[][] isConnected, int i, boolean[] visited){
        for(int j=0; j<isConnected[i].length; j++){
            if(isConnected[i][j] !=0 && !visited[j]){
                visited[j] = true;
                dfs(isConnected, j, visited);
            }
        }
    }

    public static void main(String[] args){
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));

        int[][] isConnected2 = {{1,0,0}, {0,1,0}, {0,0,1}};
        System.out.println(findCircleNum(isConnected2));
    }
}
