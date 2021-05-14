package wearableDevices.classes;

public class Index<K> implements Comparable {
    private Node<K> root;

    public Index() {
        root = null;
    }

    public void put() {

    }

    public int get(K data) {
        return -1;
    }

    public int[] getPositionData() {
        return null;
    }

    @Override
    public int compareTo(Object otherData) {
        return 0;
    }

    private static class Node<K> {
        public K data;
        public int position;
        public Node<K> left;
        public Node<K> right;
        public DupNode same;

        public Node(K data) {
            this.data = data;
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
