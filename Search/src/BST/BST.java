package BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST <E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root, e);
    }


    // 返回插入元素后二分搜索树根方法的插入操作
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    // 逻辑比较直观的插入操作
    public void addOld(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void addOld(Node node, E e) {
        if (e.equals(node)) return;
        else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(node.e) < 0) addOld(node.left, e);
        else if (e.compareTo(node.e) > 0) addOld(node.right, e);
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) return false;
        if (e.compareTo(node.e) == 0) return true;
        else if (e.compareTo(node.e) < 0) return contains(node.left, e);
        else return contains(node.right, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void preOrderNR() {
        preOrderNR(root);
    }

    private void preOrderNR(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node last = root;
        Node nlast =root;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.e + " ");
            if (cur.left != null) {
                queue.add(cur.left);
                nlast = cur.left;
            }
            if (cur.right != null) {
                queue.add(cur.right);
                nlast = cur.right;
            }
            if (cur == last) { //如果当前节点是最右节点，换行
                System.out.println();
                last = nlast; //让last等于最右节点
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateBSTString(depth) + "null\n");
            return;
        }
        res.append(generateBSTString(depth) + node.e + "\n");
        
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateBSTString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
