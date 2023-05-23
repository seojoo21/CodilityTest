package BinaryTree;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class BinaryTreeZigZagTraversals {

    public static void zigZagDfs(TreeNode root){
        if(root == null) return;

        Deque<TreeNode> curLevel = new LinkedList<>();
        Deque<TreeNode> nextLevel = new LinkedList<>();

        curLevel.push(root);
        boolean leftToRight = true;

        while(!curLevel.isEmpty()){
            root = curLevel.pop();

            System.out.print(root.val + " ");

            if(leftToRight){
                if(root.left != null) nextLevel.push(root.left);
                if(root.right != null) nextLevel.push(root.right);
            }else{
                if(root.right != null) nextLevel.push(root.right);
                if(root.left != null) nextLevel.push(root.left);
            }

            if(curLevel.isEmpty()){
               leftToRight = false;
               Deque<TreeNode> tmp = curLevel;
               curLevel = nextLevel;
               nextLevel = tmp;
            }
        }
    }

    public static void main(String[] args){
        /*       1
        *      /   \
        *     2     3
        *    / \   / \
        *   7  6  5   4
        * */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);

        zigZagDfs(root);

    }
}
