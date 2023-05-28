package Graph.BFS;

import java.util.*;

// https://leetcode.com/problems/keys-and-rooms/description
public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(0);
        queue.offer(0);

        while(!queue.isEmpty()){
            int rn = queue.poll();
            List<Integer> keys = rooms.get(rn);
            for(int key : keys){
                if(!visited.contains(key)){
                    visited.add(key);
                    queue.offer(key);
                }
            }
        }
        if(visited.size() == rooms.size()) return true;
        return false;
    }
}
