package BinaryTree;

// LeetCode Question: https://leetcode.com/problems/path-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class PathSum2Solution {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int curSum = 0;
        List<Integer> curList = new ArrayList<>();
        if(root != null){
            rootToLeafPathSum(root, targetSum, curSum, curList);
        }
        return result;
    }

    public static void rootToLeafPathSum(TreeNode node, int targetSum, int curSum, List<Integer> curList){
        curSum = curSum + node.val;
        curList.add(node.val);

        if(node.left == null && node.right == null && curSum == targetSum){
            result.add(curList);
        }

        if(node.left != null){
            rootToLeafPathSum(node.left, targetSum, curSum, new ArrayList<>(curList));
        }

        if(node.right != null){
            rootToLeafPathSum(node.right, targetSum, curSum, new ArrayList<>(curList));
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> result = pathSum(root, 22);
        System.out.println(result);

    }
}


