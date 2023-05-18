package BinaryTree;

// Problem: https://leetcode.com/problems/delete-node-in-a-bst/description/
public class DeleteBSTNode {

    public static TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;

        if(root.val<key){
            root.left = deleteNode(root.left, key);
            return root;
        }else if(root.val>key){
            root.right = deleteNode(root.right, key);
            return root;
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode min = root.right;
                while(root.left != null){
                    min = root.left;
                }
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
                return root;
            }
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        deleteNode(root, 3);
        System.out.println(root);
    }
}
