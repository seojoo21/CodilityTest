package BinaryTree;

// LeetCode Question: https://leetcode.com/problems/path-sum/description/

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

public class PathSumSolution {

    public static boolean hasPathSum(TreeNode root, int targetSum){
        int curSum = 0;
        return rootToLeafPathSum(root, targetSum, curSum);
    }

    public static boolean rootToLeafPathSum(TreeNode node, int targetSum, int curSum){
        if(node == null) return false;

        if(node.left == null && node.right == null){
            curSum = curSum + node.val;
            if(curSum == targetSum){
                return true;
            }
        }
        return rootToLeafPathSum(node.left, targetSum, curSum+node.val) || rootToLeafPathSum(node.right, targetSum, curSum+node.val);
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
        root.right.right.right = new TreeNode(1);

        boolean result = hasPathSum(root, 22);
        System.out.println(result);
    }
}


