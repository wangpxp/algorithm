package BST;

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
            node.left = add(node, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node, e);
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

}
