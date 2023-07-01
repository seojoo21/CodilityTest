package Math;

import java.util.Arrays;

public class Permutation {
    private static int n, m;
    private static int[] arr;               // 원소 저장 배열
    private static boolean[] visited;       // 중복 제거를 위한 방문 처리

    // 순열
    private static void permutation(int cnt){
        if(cnt == m){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                permutation(cnt+1);
                visited[i] = false;
            }
        }
    }

    //중복 순열
    private static void repeatedPermutation(int cnt){
        if(cnt == m){
            System.out.println(Arrays.toString(arr));
        }
        for(int i=1; i<=n; i++){
            arr[cnt] = i;
            permutation(cnt+1);
        }
    }

    public static void main(String[] args){
        n = 4;
        m = 2;
        arr = new int[m];
        visited = new boolean[n+1];

        System.out.println("////////순열///////");
        permutation(0);
        System.out.println("///////중복순열/////////");
        repeatedPermutation(0);

//        ////////순열///////
//        [1, 2]
//        [1, 3]
//        [1, 4]
//        [2, 1]
//        [2, 3]
//        [2, 4]
//        [3, 1]
//        [3, 2]
//        [3, 4]
//        [4, 1]
//        [4, 2]
//        [4, 3]
//        ///////중복순열/////////
//        [1, 1]
//        [1, 2]
//        [1, 3]
//        [1, 4]
//        [2, 1]
//        [2, 2]
//        [2, 3]
//        [2, 4]
//        [3, 1]
//        [3, 2]
//        [3, 3]
//        [3, 4]
//        [4, 1]
//        [4, 2]
//        [4, 3]
//        [4, 4]
    }
}
