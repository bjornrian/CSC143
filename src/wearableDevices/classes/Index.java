package wearableDevices.classes;

public class Index<K> {
    private Node<K> root;

    public Index() {
        root = null;
    }

    public void  put(K data, int position) {
        Node<K> newNode = new Node<>(data, position);
        if(root == null) {
            root = newNode;
        }
    }

    public int get(K data) {
        return -1;
    }

    public int[] getPositionData() {
        return null;
    }

    private static class Node<K> {
        public K data;
        public int position;
        public Node<K> left;
        public Node<K> right;
        public DupNode same;

        public Node(K data, int position) {
            this.data = data;
            this.position = position;
        }

        public int compareTo() {
            return -1;
        }
    }

    private static class DupNode {
        public int position;
        public DupNode same;

        public DupNode(int position) {
            this.position = position;
        }
    }
}
