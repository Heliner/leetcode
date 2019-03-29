public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private Node root;

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value val, int n, boolean color) {
            this.key = key;
            this.val = val;
            N = n;
            this.color = color;
        }
    }


    private boolean isRed(Node h) {
        if (h == null)
            return false;
        return h.color == RED;
    }


    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node h) {
        if (h == null)
            return 0;
        return h.N;
    }


    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node root, Key key, Value val) {
        if (root == null)
            return new Node(key, val, 1, RED);
        int cmp = key.compareTo(root.key);
        if (cmp < 0) root.left = put(root.left, key, val);
        else if (cmp > 0) root.right = put(root.right, key, val);
        else root.val = val;
        if (isRed(root.right) && !isRed(root.left)) root = rotateLeft(root);
        if (isRed(root.left) && isRed(root.left.left)) root = rotateRight(root);
        if (isRed(root.left) && isRed(root.right)) flipColors(root);
        root.N = size(root.left) + size(root.right) + 1;
        return root;
    }

    @Override
    public String toString() {
        return "RedBlackBST{" +
                "root=" + root +
                '}';
    }
}
