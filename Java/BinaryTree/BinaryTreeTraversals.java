package BinaryTree;// https://minhamina.tistory.com/83

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
    }
}

class TreeOrderClass{
    public Node root; // 초기 root는 null

    public void createNode(int data, int leftData, int rightData){
        if(root == null){ // 초기상태: 루트 노드 생성
            root = new Node(data);
            // 좌우 값이 있는 경우, 즉 -1이 아닌 경우 노드 생성
            if(leftData != -1){
                root.left = new Node(leftData);
            }
            if(rightData != -1) {
                root.right = new Node(rightData);
            }
        } else { // 초기 상태가 아니라면 루트 노드 생성 이후 만들어진 노드 중 어떤건지를 찾아야 함
            searchNode(root, data, leftData, rightData);
        }
    }

    //매개 변수로 들어온 루트 노드를 시작으로 data와 같은 값을 가진 노드를 찾는다.
    //찾을 때까지 루트 노드에서부터 왼쪽, 오른쪽으로 내려간다.
    public void searchNode(Node node, int data, int leftData, int rightData){
        if(node == null){ //도착한 노드가 null 이면 종료 (찾을 노드 없음)
            return;
        } else if(node.data == data){ // 들어갈 위치를 찾았다면
            if(leftData != -1){ // -1이 아니라 값이 있는 경우에만 좌우노드 생성
                node.left = new Node(leftData);
            }
            if(rightData != -1){
                node.right = new Node(rightData);
            }
        } else{ // 아직 찾지 못했고 탐색할 노드가 남아있다면 좌우 재귀 탐색
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    // preOrder: root -> left -> right
    public void preOrder(Node node){
        if(node != null){
            System.out.print(node.data + " ");
            if(node.left != null) preOrder(node.left);
            if(node.right != null) preOrder(node.right);
        }
    }

    // inOrder: left -> root -> right
    public void inOrder(Node node){
        if(node != null){
            if(node.left != null) inOrder(node.left);
            System.out.print(node.data + " ");
            if(node.right != null) inOrder(node.right);
        }
    }

    // postOrder: left -> right -> root
    public void postOrder(Node node){
        if(node != null){
            if(node.left != null) postOrder(node.left);
            if(node.right != null) postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // 반복적 순회: inOrder 결과와 동일
    public void iterativeOrder(Node node){
        Stack<Node> stack = new Stack<>();
        //처음 루트 노드 부터 시작
        while(node != null || !stack.isEmpty()){
            //현재 노드의 왼쪽 노드들을 null에 도달할 때까지(마지막 왼쪽 자식 노드까지) 스택에 추가한다.
            while(node != null){
                stack.push(node);
                node = node.left;
            }

            node = stack.pop(); //null 노드에 도달하면 스택에서 하나씩 꺼낸다.
            System.out.print(node.data + " "); //삭제된 노드 방문 -> 삭제된 노드의 값 출력
            node = node.right;  //삭제된 노드를 방문한 후에 이 노드의 오른쪽 노드로 이동한다.
                                //다시 이 노드를 기준으로 왼쪽 노드들을 null에 도달할 때까지 스택에 추가한다.
                                // -> 이를 스택이 빌 때까지 반복하면 이진트리를 중위순회할 수 있다.
        }
    }

    // 레벨 순회
    public void levelOrder(Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.data + " ");

            if(node.left != null) queue.offer(node.left); //왼쪽 자식 노드가 있으면 추가
            if(node.right != null) queue.offer(node.right); // 오른쪽 자식 노드가 있으면 추가
        }
    }

    //레벨별 노드
    public void levelByLevel(Node node){
        // 전체 레벨을 담기 위한 ArrayList
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>(); // 레벨별 값을 담기 위한 ArrayList

            int size = queue.size();
            for(int i=0; i<size; i++){
                node = queue.poll();
                level.add(node.data); // 큐에서 꺼낸 노드를 level list 에 저장

                if(node.left != null) queue.offer(node.left); // 왼쪽 자식 노드가 있으면 추가
                if(node.right != null) queue.offer(node.right);// 오른쪽 자식 노드가 있으면 추가
            }
            list.add(level); // 한 레벨이 끝날 때마다 레벨별 저장된 값들을 전체 list 에 저장
        }

        for(ArrayList<Integer> i : list){
            System.out.println(i);
        }
    }

    //노드 개수 구하기
    //노드의 개수를 세기 위해서는 트리안의 노드들을 전체적으로 순회하여야 한다.
    //각각의 서브트리에 대하여 순환 호출한 다음, 반환되는 값에 1을 더하여 반환한다.
    public int getNodeCount(Node node){
        int count = 0;
        if(node != null){
            count = 1 + getNodeCount(node.left) + getNodeCount(node.right);
        }
        return count;
    }

    //단말 노드 개수 구하기
    //단말 노드의 개수를 세기 위해서는 트리안의 노드들을 전체적으로 순회하여야 한다.
    //순회하면서 만약 왼쪽 자식과 오른쪽 자식이 동시에 0이 되면 단말 노드이므로 1을 반환한다.
    //만약 그렇지 않다면 비 단말 노드이므로 각각의 서브 트리에 대하여 순환 호출한 다음, 반환되는 값을 서로 더하면 된다.
    public int getLeafNodeCount(Node node){
        int count = 0;
        if(node != null){
            if(node.left == null && node.right == null){
                return 1;
            }else{
                count = getLeafNodeCount(node.left) + getLeafNodeCount(node.right);
            }
        }
        return count;
    }

    // 트리 높이 구하기
    public int getHeight(Node node){
        int height = 0;
        if(node != null){
            height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
        return height;
    }
}

public class BinaryTreeTraversals {

    public static void main(String[] args){
        TreeOrderClass t = new TreeOrderClass();
        t.createNode(1,2,3);
        t.createNode(2,4,5);
        /*   1
         *  /  \
         *  2    3
         * / \
         * 4  5
         * */

        System.out.println("전위 순회 (PreOrder)");
        t.preOrder(t.root);

        System.out.println("\n중위 순회 (InOrder)");
        t.inOrder(t.root);

        System.out.println("\n후위 순회 (PostOrder)");
        t.postOrder(t.root);

        System.out.println("\n반복적 순회 (iterativeOrder)");
        t.iterativeOrder(t.root);

        System.out.println("\n레벨 순회 (levelOrder)");
        t.levelOrder(t.root);

        System.out.println("\n레벨별 노드");
        t.levelByLevel(t.root);
        
        System.out.println("\n노드 개수 구하기");
        System.out.print(t.getNodeCount(t.root));

        System.out.println("\n단말 노드 개수 구하기");
        System.out.print(t.getLeafNodeCount(t.root));

        System.out.println("\n트리 높이 구하기");
        System.out.print(t.getHeight(t.root));
        
    }
}
