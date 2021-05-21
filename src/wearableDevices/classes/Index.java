package wearableDevices.classes;

public class Index<K extends Comparable<K>> {
    private Node<K> root;
    private int indexSize;

    public Index() {
        root = null;
    }

    public void put(K data, int position) {
        root = put(data, position, root);
    }

    //COMPLETELY CHANGE THIS
    //todo check data and position variable placing
    public Node<K> put(K data, int position, Node<K> startNode) {
        if (startNode == null) {
            startNode = new Node<>(data, position);
        } else if (data.compareTo(startNode.data) < 0) {
            startNode.left = put(data, position, startNode.left);
        } else {
            startNode.right = put(data, position, startNode.right);
        }
        return startNode;
    }

    public int get(K data) {
        return get(data, root);
    }

    public int get(K data, Node<K> startNode) {
        if (startNode.data == data) {
            return startNode.position;
        } else if (data.compareTo(startNode.data) < 0) {
            return get(data, startNode.left);
        } else {
            return get(data, startNode.right);
        }
    }

    public int[] getPositionData() {
        return getPositionData(root);
    }

    public int[] getPositionData(Node<K> startNode) {
        if (startNode != null) {
            getPositionData(startNode.left);
            System.out.print(startNode.position + ", ");
            getPositionData(startNode.right);
        }
        return new int[0];
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
    }

    private static class DupNode {
        public int position;
        public DupNode same;

        public DupNode(int position) {
            this.position = position;
        }
    }
}
