package Math;

import java.util.*;


/**
 * 10진수 -> 2진수 변환 (stack 활용)
 */
public class BinaryNumber {
    public static int getBinaryNumber(int num){
        Deque<Integer> stack = new LinkedList<>();
        String binarySt = "";

        while(num > 0){
            int r = num % 2;
            int q = num / 2;
            stack.push(r);
            num = q;
        }

        while(!stack.isEmpty()){
            binarySt += stack.pop();
        }

        return Integer.parseInt(binarySt);
    }

    public static void main(String[] args){
        int num = 4;
        System.out.println(getBinaryNumber(num));
    }
}
