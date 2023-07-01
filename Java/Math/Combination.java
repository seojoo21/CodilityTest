package Math;

import java.util.Arrays;

public class Combination {

    private static int n,m;
    private static int[] arr;
    private static boolean[] visited;

    private static void combination(int cnt, int start){
        if(cnt == m){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=start; i<=n; i++){
            arr[cnt] = i;
            combination(cnt+1, i+1); // 오름차순으로 구하면 중복 체크하지 않아도 됨
        }
    }

    private static void repeatedCombination(int cnt, int start){
        if(cnt == m){
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=start; i<=n; i++){
            arr[cnt] = i;
            combination(cnt+1, i); // 중복 허용하니까 비내림차순
        }
    }

    public static void main(String[] args){
        n = 4;
        m = 2;
        arr = new int[m];
        visited = new boolean[n+1];

        System.out.println("////////조합///////");
        combination(0,1);
        System.out.println("///////중복조합/////////");
        repeatedCombination(0,1);
    }
}
