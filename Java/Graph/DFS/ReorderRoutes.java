package Graph.DFS;

import java.util.*;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
public class ReorderRoutes {
    public static int minReorder(int n, int[][] connections){
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i<n; i++){
            al.add(new ArrayList<>());
        }
        for(int[] c : connections){
            al.get(c[0]).add(c[1]); // the direction from parent to child
            al.get(c[1]).add(-c[0]); // the direction from child to parent
        }
        System.out.println(al);
        return dfs(al, new boolean[n], 0);
    }

    public static int dfs(List<List<Integer>> al, boolean[] visited, int from){
        int change = 0;
        visited[from] = true;
        for(int to : al.get(from)){
            if(!visited[Math.abs(to)]){
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return change;
    }


    public static void main(String[] args){
        int n = 6;
        int[][] connections = {{0,1}, {1,3}, {2,3}, {4,0}, {4,5}};
        System.out.println(minReorder(n, connections));

        int n2 = 5;
        int[][] connections2 = {{1,0}, {1,2}, {3,2}, {3,4}};
        System.out.println(minReorder(n2, connections2));
    }
}
