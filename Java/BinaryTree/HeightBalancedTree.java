package BinaryTree;

// https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
public class HeightBalancedTree {
    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(30);
        root.right.left = new Node(15);
        root.right.right = new Node(20);

        if(isBalanced(root) > 0 ) System.out.println("Balanced");
        else System.out.println("Not Balanced");
    }

    /**
     * For each node make two recursion calls – one for left subtree and the other for the right subtree.
     * Based on the heights returned from the recursion calls, decide if the subtree whose root is the current node is height-balanced or not.
     * If it is balanced then return the height of that subtree. Otherwise, return -1 to denote that the subtree is not height-balanced.
     *
     * Time Complexity: O(n)
     * Because we are only one dfs call and utilizing the height returned from that to determine the height balance, it is performing the task in linear time.
     * Auxiliary Space: O(n)
     *
     * @param root
     * @return
     */
    public static int isBalanced(Node root){
        if (root == null) return 0;

        int lh = isBalanced(root.left);
        if(lh == -1) return -1;

        int rh = isBalanced(root.right);
        if(rh == -1) return -1;

        if(Math.abs(lh-rh) > 1) return -1;
        else return Math.max(lh, rh) + 1;

    }
}
